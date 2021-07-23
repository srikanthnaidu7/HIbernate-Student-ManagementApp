package com.sri.sm.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sri.sm.domain.Student;
import com.sri.sm.dto.StudentDTO;

@Component
public class StudentDTOToDomain {

	public Student convertStudentDomain(StudentDTO studentDTOObj) {

		Student student = new Student();
		student.setId(studentDTOObj.getId());
		student.setName(studentDTOObj.getName());
		student.setMobile(studentDTOObj.getMobile());
		student.setCountry(studentDTOObj.getCountry());
		student.setEmail(studentDTOObj.getEmail());
		return student;
	}

}
