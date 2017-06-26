package com.seck.profesores.dao.impl;

import java.util.Iterator;
import java.util.List;

import com.seck.profesores.dao.AbstractSession;
import com.seck.profesores.dao.TeacherDao;
import com.seck.profesores.model.Teacher;
import com.seck.profesores.model.TeacherSocialMedia;


public class TeacherDaoImpl extends AbstractSession implements TeacherDao {
	

	@Override
	public void saveTeacher(Teacher teacher) {
		
		getSession().persist(teacher);
		
	}

	@Override
	public void deleteTeacherById(Long idTeacher) {
		
		Teacher teacher = findById(idTeacher);
		if (teacher != null) {
			
			Iterator<TeacherSocialMedia> i =  teacher.getTeacherSocialMedias().iterator();
			while (i.hasNext()) {
				TeacherSocialMedia teacherSocialMedia = i.next();
				i.remove();
				getSession().delete(teacherSocialMedia);
			}
			teacher.getTeacherSocialMedias().clear();
			getSession().delete(teacher);
		}
		
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		
		getSession().update(teacher);
		
	}

	@Override
	public List<Teacher> findAllTeachers() {
		
		return getSession().createQuery("from Teachers").list();
	}

	@Override
	public Teacher findById(Long idTeacher) {
		
		return getSession().get(Teacher.class, idTeacher);
	}

	@Override
	public Teacher findByName(String name) {
		
		return (Teacher) getSession().createQuery(
				"from Teachear where name = :name")
				.setParameter("name", name).uniqueResult();
	}
	
	
}
