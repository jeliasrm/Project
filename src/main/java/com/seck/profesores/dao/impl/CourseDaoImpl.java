package com.seck.profesores.dao.impl;

import java.util.List;

import com.seck.profesores.dao.AbstractSession;
import com.seck.profesores.dao.CourseDao;
import com.seck.profesores.model.Course;
import com.seck.profesores.model.SocialMedia;
import com.seck.profesores.model.Teacher;

public class CourseDaoImpl extends AbstractSession implements CourseDao {

	@Override
	public void saveCourse(Course course) {
		// TODO Auto-generated method stub
		getSession().persist(course);
	}

	@Override
	public void deleteCourseById(Long idCourse) {
		// TODO Auto-generated method stub
		Course course = findById(idCourse);
		if (course  != null) {
			getSession().delete(course );
		}
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		getSession().update(course);
	}

	@Override
	public List<Course> findAllCourses() {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Course").list();
	}

	@Override
	public Course findById(Long idCourse) {
		// TODO Auto-generated method stub
		return (Course) getSession().get(Course.class, idCourse);
	}

	@Override
	public Course findByName(String name) {
		// TODO Auto-generated method stub
		return (Course) getSession().createQuery(
				"from Course where name = :name")
				.setParameter("name", name).uniqueResult();
	}

	@Override
	public List<Course> findByIdTeacher(Long idTeacher) {
		// TODO Auto-generated method stub
		return (List<Course>) getSession().createQuery(
				"from Course c join c.teacher t where t.idTeacher = :idTeacher")
				.setParameter("idTeacher", idTeacher).list();
	}

}
