package com.sri.sm.dao;

import java.util.List;

import com.sri.sm.domain.Student;

public interface StudentDAO {

	List<Student>  loadStudents();
		
	Student getStudent(int id);
	
	int addStudent(Student student);

	void updateStudent(Student student);

	void deleteStudent(Student student);
}
