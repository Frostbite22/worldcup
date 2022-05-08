package isi.tn.wordcup.services;

import java.util.List;

import isi.tn.wordcup.entities.Tournoi;
import isi.tn.wordcup.payload.response.MessageResponse;

public interface ITournoiService {

	public MessageResponse save(Tournoi tournoi);
    public MessageResponse update(Tournoi tournoi);
    public MessageResponse delete(Long id);
    public List<Tournoi> findAll();
    public Tournoi findById(Long id);
}
