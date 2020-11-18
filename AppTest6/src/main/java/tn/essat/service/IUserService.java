package tn.essat.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import tn.essat.model.User;

public interface IUserService extends UserDetailsService{
	public User findByUsername(String username);
}
