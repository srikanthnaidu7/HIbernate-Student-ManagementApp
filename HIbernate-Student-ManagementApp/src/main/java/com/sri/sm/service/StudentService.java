package com.sri.sm.service;

import java.util.List;

import com.sri.sm.domain.Student;

public interface StudentService {

	List<Student> loadStudents();

	int addStudent(Student student);
	
	Student getStudent(int id);

	void updateStudent(Student student);

	void deleteStudent(Student student);
}
