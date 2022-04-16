package isi.tn.wordcup.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.tn.wordcup.entities.Tournoir;
import isi.tn.wordcup.payload.response.MessageResponse;
import isi.tn.wordcup.repositories.TournoirRepository;

@Service
public class ImpTournoirService implements ITournoirService{
	@Autowired
	TournoirRepository tournoirRepository;
	
    @Transactional
	@Override
	public MessageResponse save(Tournoir tournoir) {
    	boolean existe = tournoirRepository.existsByNom(tournoir.getNom());
        if (existe){
            return new MessageResponse(false,"Echec !","Cette tournoir existe déja !");
        }
        tournoirRepository.save(tournoir);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}

    @Transactional
	@Override
	public MessageResponse update(Tournoir tournoir) {
    	 boolean existe = tournoirRepository.existsById(tournoir.getId());
         if (!existe){
             boolean existe1 = tournoirRepository.existsByNom(tournoir.getNom());
             return new MessageResponse(false,"Echec !","Cette domaine existe déja !");
         }
         tournoirRepository.save(tournoir);
         return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}

    @Transactional
	@Override
	public MessageResponse delete(Long id) {
    	Tournoir tournoir = findById(id);
        if (tournoir==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        tournoirRepository.delete(tournoir);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
	}

    @Transactional
	@Override
	public List<Tournoir> findAll() {
        return tournoirRepository.findAll();
	}

    @Transactional
	@Override
	public Tournoir findById(Long id) {
    	Tournoir tournoir = tournoirRepository.findById(id).orElse(null);
        return tournoir;
	}

}
