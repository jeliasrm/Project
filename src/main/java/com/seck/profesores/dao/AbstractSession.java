package com.seck.profesores.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractSession {
	
	@Autowired
	private SessionFactory sessionfactory;
	
	protected Session getSession(){
		return sessionfactory.getCurrentSession();
	}

}
