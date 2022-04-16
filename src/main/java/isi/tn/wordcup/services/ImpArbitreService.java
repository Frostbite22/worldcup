package isi.tn.wordcup.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.tn.wordcup.entities.Arbitre;
import isi.tn.wordcup.payload.response.MessageResponse;
import isi.tn.wordcup.repositories.ArbitreRepository;

@Service
public class ImpArbitreService implements IArbitreService{
    @Autowired
    ArbitreRepository arbitreRepository;
    
    @Transactional
	@Override
	public MessageResponse save(Arbitre arbitre) {
		boolean existe = arbitreRepository.existsByNom(arbitre.getNom());
        if (existe){
            return new MessageResponse(false,"Echec !","Cette arbitre existe déja !");
        }
        arbitreRepository.save(arbitre);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}

    @Transactional
	@Override
	public MessageResponse update(Arbitre arbitre) {
		boolean existe = arbitreRepository.existsById(arbitre.getId());
        if (!existe){
            boolean existe1 = arbitreRepository.existsByNom(arbitre.getNom());
            return new MessageResponse(false,"Echec !","Cette arbitre existe déja !");
        }
        arbitreRepository.save(arbitre);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}

    @Transactional
	@Override
	public MessageResponse delete(Long id) {
    	Arbitre arbitre = findById(id);
        if (arbitre==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        arbitreRepository.delete(arbitre);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
	}

    @Transactional
	@Override
	public List<Arbitre> findAll() {
        return arbitreRepository.findAll();
	}

    @Transactional
	@Override
	public Arbitre findById(Long id) {
        Arbitre domaine = arbitreRepository.findById(id).orElse(null);
        return domaine;
	}

}
