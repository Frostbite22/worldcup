package isi.tn.wordcup.services;

import java.util.List;

import isi.tn.wordcup.entities.Role;
import isi.tn.wordcup.payload.response.MessageResponse;


public interface IRoleService {
    public MessageResponse save(Role role);
    public MessageResponse update(Role role);
    public MessageResponse delete(Long id);
    public List<Role> findAll();
    public Role findById(Long id);
}
