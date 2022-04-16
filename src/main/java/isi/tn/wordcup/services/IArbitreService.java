package isi.tn.wordcup.services;

import java.util.List;

import isi.tn.wordcup.entities.Arbitre;
import isi.tn.wordcup.payload.response.MessageResponse;

public interface IArbitreService {
	public MessageResponse save(Arbitre arbitre);
    public MessageResponse update(Arbitre arbitre);
    public MessageResponse delete(Long id);
    public List<Arbitre> findAll();
    public Arbitre findById(Long id);
}
