package isi.tn.wordcup.services;

import java.util.List;

import isi.tn.wordcup.entities.Groupe;
import isi.tn.wordcup.payload.response.MessageResponse;

public interface IGroupeService {

	public MessageResponse save(Groupe groupe);
    public MessageResponse update(Groupe groupe);
    public MessageResponse delete(Long id);
    public List<Groupe> findAll();
    public Groupe findById(Long id);
}
