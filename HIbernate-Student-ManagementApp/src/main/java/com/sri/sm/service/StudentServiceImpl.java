package com.sri.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.sm.dao.StudentDAO;
import com.sri.sm.domain.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	public List<Student> loadStudents() {
		
		List<Student> studentList = studentDAO.loadStudents();
		
		return studentList;
	}

	

	@Override
	public int addStudent(Student student) {
		// TODO Auto-generated method stub
		
		int result = studentDAO.addStudent(student);
		
		return result;
	}

	@Override
	public Student getStudent(int id) {
		
		
		Student student = studentDAO.getStudent(id);
		
		return student;
	}

	@Override
	public void updateStudent(Student student) {
		
		studentDAO.updateStudent(student);
		
	}

	@Override
	public void deleteStudent(Student student) {

		studentDAO.deleteStudent(student);
	}

	

}
