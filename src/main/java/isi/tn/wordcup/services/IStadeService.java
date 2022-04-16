package isi.tn.wordcup.services;

import java.util.List;

import isi.tn.wordcup.entities.Stade;
import isi.tn.wordcup.payload.response.MessageResponse;

public interface IStadeService {

	public MessageResponse save(Stade stade);
    public MessageResponse update(Stade stade);
    public MessageResponse delete(Long id);
    public List<Stade> findAll();
    public Stade findById(Long id);
}
