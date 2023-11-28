package com.sammySpring.aplicacion.service;

import com.sammySpring.aplicacion.entity.User;


public interface UserService {
	public Iterable<User>getALLUsers();

	public User createUser(User user) throws Exception;
	
	public User getUserById(Long id)throws Exception;
	
	public User updateUser(User user)throws Exception;

}
