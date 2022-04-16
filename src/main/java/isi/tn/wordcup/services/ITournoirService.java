package isi.tn.wordcup.services;

import java.util.List;

import isi.tn.wordcup.entities.Tournoir;
import isi.tn.wordcup.payload.response.MessageResponse;

public interface ITournoirService {

	public MessageResponse save(Tournoir tournoir);
    public MessageResponse update(Tournoir tournoir);
    public MessageResponse delete(Long id);
    public List<Tournoir> findAll();
    public Tournoir findById(Long id);
}
