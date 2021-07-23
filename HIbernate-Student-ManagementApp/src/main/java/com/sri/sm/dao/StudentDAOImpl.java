package com.sri.sm.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sri.sm.domain.Student;

@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		System.out.println("sessionfactory:" + sessionFactory);
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Student> loadStudents() {


		Criteria criteria = getSession().createCriteria(Student.class);
		return (List) criteria.list();
	}

	@Override
	public Student getStudent(int id) {
		/*
		 * String sql = "SELECT * FROM STUDENTS WHERE ID = ?"; return
		 * jdbcTemplate.queryForObject(sql, new Object[] { id }, new
		 * StudentRowMapper());
		 */
		System.out.println("id:::impl"+id);

		Student studentObj = (Student) getSession().get(Student.class, new Long(id));
		return studentObj;

	}

	@Override
	public int addStudent(Student student) {
		/*
		 * String sql =
		 * "insert into STUDENTS (name, mobile, country, email) values (?, ?, ?, ?)";
		 * int id = jdbcTemplate.update(sql, student.getName(), student.getMobile(),
		 * student.getCountry(), student.getEmail());
		 */
		getSession().save(student);

		return 1;
	}

	@Override
	public void updateStudent(Student student) {
		/*
		 * String SQL =
		 * "update Students set name = ?,mobile=?,country=?,email=? where id = ?"; int
		 * id = jdbcTemplate.update(SQL, student.getName(), student.getMobile(),
		 * student.getCountry(),student.getEmail(), student.getId());
		 */

		getSession().update(student);
	}

	@Override
	public void deleteStudent(Student student) {

		// String SQL = "delete from Students where id = ?";

		Student studentObj = (Student) getSession().get(Student.class, student.getId());
		getSession().delete(studentObj);

	}

}
