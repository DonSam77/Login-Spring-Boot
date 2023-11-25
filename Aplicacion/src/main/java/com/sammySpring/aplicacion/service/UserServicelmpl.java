package com.sammySpring.aplicacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sammySpring.aplicacion.entity.User;
import com.sammySpring.aplicacion.repository.UserRepository;

@Service
public class UserServicelmpl implements UserService	{
	
	@Autowired
	UserRepository repository;

	@Override
	public Iterable<User> getALLUsers() {
		return repository.findAll();
	}

}
