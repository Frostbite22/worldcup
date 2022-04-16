package isi.tn.wordcup.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.tn.wordcup.entities.Stade;
import isi.tn.wordcup.payload.response.MessageResponse;
import isi.tn.wordcup.repositories.StadeRepository;

@Service
public class ImpStadeService implements IStadeService{
	@Autowired
	StadeRepository stadeRepository;

    @Transactional
	@Override
	public MessageResponse save(Stade stade) {
        boolean existe = stadeRepository.existsByNom(stade.getNom());
        if (existe){
            return new MessageResponse(false,"Echec !","Cette stade existe déja !");
        }
        stadeRepository.save(stade);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}

    @Transactional
	@Override
	public MessageResponse update(Stade stade) {
    	boolean existe = stadeRepository.existsById(stade.getId());
        if (!existe){
            boolean existe1 = stadeRepository.existsByNom(stade.getNom());
            return new MessageResponse(false,"Echec !","Cette stade existe déja !");
        }
        stadeRepository.save(stade);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}

    @Transactional
	@Override
	public MessageResponse delete(Long id) {
        Stade stade = findById(id);
        if (stade==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        stadeRepository.delete(stade);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
	}

    @Transactional
	@Override
	public List<Stade> findAll() {
        return stadeRepository.findAll();
	}

    @Transactional
	@Override
	public Stade findById(Long id) {
        Stade stade = stadeRepository.findById(id).orElse(null);
        return stade;
	}

}
