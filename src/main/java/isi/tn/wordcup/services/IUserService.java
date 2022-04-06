package isi.tn.wordcup.services;

import java.util.List;

import isi.tn.wordcup.entities.User;


public interface IUserService {

	User saveUser(User user);

	List<User> findAllUsers();
}
