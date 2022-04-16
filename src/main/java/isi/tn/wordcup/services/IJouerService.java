package isi.tn.wordcup.services;

import java.util.List;

import isi.tn.wordcup.entities.Jouer;
import isi.tn.wordcup.payload.response.MessageResponse;

public interface IJouerService {

	public MessageResponse save(Jouer jouer);
    public MessageResponse update(Jouer jouer);
    public MessageResponse delete(Long id);
    public List<Jouer> findAll();
    public Jouer findById(Long id);
}
