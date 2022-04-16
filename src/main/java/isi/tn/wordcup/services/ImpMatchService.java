package isi.tn.wordcup.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.tn.wordcup.entities.Match;
import isi.tn.wordcup.payload.response.MessageResponse;
import isi.tn.wordcup.repositories.MatchRepository;

@Service
public class ImpMatchService implements IMatchService{
	@Autowired
	MatchRepository matchRepository;

    @Transactional
	@Override
	public MessageResponse save(Match match) {
        matchRepository.save(match);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}

    @Transactional
	@Override
	public MessageResponse update(Match match) {
        boolean existe = matchRepository.existsById(match.getId());
        if (!existe){
            return new MessageResponse(false,"Echec !","Cette match existe déja !");
        }
        matchRepository.save(match);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}

    @Transactional
	@Override
	public MessageResponse delete(Long id) {
    	Match match = findById(id);
        if (match==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        matchRepository.delete(match);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
	}

    @Transactional
	@Override
	public List<Match> findAll() {
        return matchRepository.findAll();
	}

    @Transactional
	@Override
	public Match findById(Long id) {
    	Match match = matchRepository.findById(id).orElse(null);
        return match;
	}

}
