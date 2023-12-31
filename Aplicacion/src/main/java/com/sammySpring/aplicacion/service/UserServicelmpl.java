package com.sammySpring.aplicacion.service;

import java.util.Optional;

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
	
	

	private boolean checkUsernameAvailable(User user) throws Exception {
		Optional<User> userFound = repository.findByUsername(user.getUsername());
		if (userFound.isPresent()) {
			throw new Exception("Username no disponible");
		}
		return true;
	}
	private boolean checkPasswordValid(User user) throws Exception {
		if (user.getConfirmPassword() == null || user.getConfirmPassword().isEmpty()) {
			throw new Exception("Confirm Password es obligatorio");
		}
		
		if( !user.getPassword().equals(user.getConfirmPassword())) {
			throw new Exception("Password y Confirm Password no son iguales");
		   }
		   return true;
		}



	@Override
	public User createUser(User user) throws Exception {
		if (checkUsernameAvailable(user) && checkPasswordValid(user)) {
			user = repository.save(user);
		}
		return user;
	}



	@Override
	public User getUserById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(()-> new Exception("El usuario no existe."));
	}



	@Override
	public User updateUser(User fromUser)throws Exception {
	    User toUser = getUserById(fromUser.getId());
	    mapUser(fromUser,toUser);
	    return repository.save(toUser);
	}
	protected void mapUser(User from,User to) {
		to.setUsername(from.getUsername());
		to.setFistName(from.getFistName());
		to.setLastName(from.getLastName());
		to.setEmail(from.getEmail());
		to.setRoles(from.getRoles());
	}



	@Override
	public void deleteUser(Long id) throws Exception {
	  User user = getUserById(id);
	  repository.delete(user);
	}
}
