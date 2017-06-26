package com.seck.profesores.dao;

import java.util.List;

import com.seck.profesores.model.Teacher;


public interface TeacherDao {
	
	void saveTeacher(Teacher teacher);
	
	void deleteTeacherById(Long idTeacher);
	
	void updateTeacher(Teacher teacher);
	
	List<Teacher> findAllTeachers();
	
	Teacher findById(Long idTeacher);
	
	Teacher findByName(String name);

}
