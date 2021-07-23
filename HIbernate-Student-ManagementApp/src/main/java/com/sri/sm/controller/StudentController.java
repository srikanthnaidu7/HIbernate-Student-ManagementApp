package com.sri.sm.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sri.sm.convert.StudentDTOToDomain;
import com.sri.sm.convert.StudentDomainToDTO;
import com.sri.sm.domain.Student;
import com.sri.sm.dto.StudentDTO;
import com.sri.sm.service.StudentEmailService;
import com.sri.sm.service.StudentService;

@Controller
public class StudentController {
	
	Logger logger = Logger.getLogger(StudentController.class.getName());

	@Autowired
	private StudentService studentService;

	@Autowired
	private StudentDTOToDomain studentDTOToDomain;

	@Autowired
	private StudentDomainToDTO studentDomainToDTO;
	
	@Autowired
	private StudentEmailService studentEmailService;


	// @RequestMapping(value = "/showStudent",method = RequestMethod.GET)
	@GetMapping("/showStudents")
	public String showStudentList(Model model) {

		List<Student> studentList = studentService.loadStudents();
		model.addAttribute("students", studentList);

		return "student-list";
	}

	@GetMapping("/addstudent")
	public String addStudent(Model model) {

		StudentDTO studentDTO = new StudentDTO();
		model.addAttribute("student", studentDTO);

		return "add-student";
	}

	@PostMapping("/save-student")
	public String saveStudent(StudentDTO studentDTO) {

		if (null != studentDTO.getId() && studentDTO.getId() != 0) {
			logger.info("update student");
			studentService.updateStudent(studentDTOToDomain.convertStudentDomain(studentDTO));
		} else {
			logger.info("add student");
			int id = studentService.addStudent(studentDTOToDomain.convertStudentDomain(studentDTO));
			if(id==1) {
				logger.info("->>>> Send Mail Starts>>>");
				studentEmailService.sendEmail(studentDTO.getEmail(), studentDTO.getName());
			}
		}

		return "redirect:/showStudents";
	}

	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam("userId") int id, Model model) {

		Student student = studentService.getStudent(id);

		if (null != student) {
			model.addAttribute("student", studentDomainToDTO.convertStudentDTO(student));
		}
		return "add-student";
	}

	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("userId") int id, Model model) {

		Student student = studentService.getStudent(id);

		studentService.deleteStudent(student);

		return "redirect:/showStudents";
	}

}
