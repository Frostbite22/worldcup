package isi.tn.wordcup.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.tn.wordcup.entities.Tournoi;
import isi.tn.wordcup.payload.response.MessageResponse;
import isi.tn.wordcup.repositories.TournoiRepository;

@Service
public class ImpTournoiService implements ITournoiService{
	@Autowired
	TournoiRepository tournoiRepository;
	
    @Transactional
	@Override
	public MessageResponse save(Tournoi tournoi) {
    	boolean existe = tournoiRepository.existsByNom(tournoi.getNom());
        if (existe){
            return new MessageResponse(false,"Echec !","Cette tournoi existe déja !");
        }
        tournoiRepository.save(tournoi);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}

    @Transactional
	@Override
	public MessageResponse update(Tournoi tournoi) {
    	 boolean existe = tournoiRepository.existsById(tournoi.getId());
         if (!existe){
             boolean existe1 = tournoiRepository.existsByNom(tournoi.getNom());
             return new MessageResponse(false,"Echec !","Cette tournoi existe déja !");
         }
         tournoiRepository.save(tournoi);
         return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}

    @Transactional
	@Override
	public MessageResponse delete(Long id) {
    	Tournoi tournoi = findById(id);
        if (tournoi==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        tournoiRepository.delete(tournoi);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
	}

    @Transactional
	@Override
	public List<Tournoi> findAll() {
        return tournoiRepository.findAll();
	}

    @Transactional
	@Override
	public Tournoi findById(Long id) {
    	Tournoi tournoir = tournoiRepository.findById(id).orElse(null);
        return tournoir;
	}

}
