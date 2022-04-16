package isi.tn.wordcup.services;

import java.util.List;

import isi.tn.wordcup.entities.Match;
import isi.tn.wordcup.payload.response.MessageResponse;

public interface IMatchService {

	public MessageResponse save(Match match);
    public MessageResponse update(Match match);
    public MessageResponse delete(Long id);
    public List<Match> findAll();
    public Match findById(Long id);
}
