package isi.tn.wordcup.services;

import java.util.List;

import isi.tn.wordcup.entities.Joueur;
import isi.tn.wordcup.payload.response.MessageResponse;

public interface IJoueurService {

	public MessageResponse save(Joueur joueur);
    public MessageResponse update(Joueur joueur);
    public MessageResponse delete(Long id);
    public List<Joueur> findAll();
    public Joueur findById(Long id);
}
