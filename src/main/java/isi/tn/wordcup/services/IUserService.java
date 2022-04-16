package isi.tn.wordcup.services;

import java.util.List;

import isi.tn.wordcup.entities.User;
import isi.tn.wordcup.payload.response.MessageResponse;


public interface IUserService {
    public MessageResponse save(User user);
    public MessageResponse update(User user);
    public MessageResponse delete(Long id);
    public List<User> findAll();
    public User findById(Long id);
}
