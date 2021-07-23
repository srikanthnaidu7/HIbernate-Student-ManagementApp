package com.sri.sm.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sri.sm.domain.Student;
import com.sri.sm.dto.StudentDTO;

@Component
public class StudentDomainToDTO {

	public StudentDTO convertStudentDTO(Student student) {
		
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setId(student.getId());
		studentDTO.setName(student.getName());
		studentDTO.setMobile(student.getMobile());
		studentDTO.setCountry(student.getCountry());
		studentDTO.setEmail(student.getEmail());
		
		return studentDTO;
	}
	
}
