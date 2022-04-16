package isi.tn.wordcup.services;

import java.util.List;

import isi.tn.wordcup.entities.Equipe;
import isi.tn.wordcup.payload.response.MessageResponse;

public interface IEquipeService {
	public MessageResponse save(Equipe equipe);
    public MessageResponse update(Equipe equipe);
    public MessageResponse delete(Long id);
    public List<Equipe> findAll();
    public Equipe findById(Long id);
}
