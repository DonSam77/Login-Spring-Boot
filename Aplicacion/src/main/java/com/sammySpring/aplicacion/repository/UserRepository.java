package com.sammySpring.aplicacion.repository;

import org.springframework.data.repository.CrudRepository;

import com.sammySpring.aplicacion.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{

	
}
