package isi.tn.wordcup.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.tn.wordcup.entities.Jouer;
import isi.tn.wordcup.payload.response.MessageResponse;
import isi.tn.wordcup.repositories.JouerRepository;

@Service
public class ImpJouerService implements IJouerService{
	@Autowired
	JouerRepository jouerRepository;

    @Transactional
	@Override
	public MessageResponse save(Jouer jouer) {
        boolean existe = jouerRepository.existsByNom(jouer.getNom());
        if (existe){
            return new MessageResponse(false,"Echec !","Cette jouer existe déja !");
        }
        jouerRepository.save(jouer);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}

    @Transactional
	@Override
	public MessageResponse update(Jouer jouer) {
        boolean existe = jouerRepository.existsById(jouer.getId());
        if (!existe){
            boolean existe1 = jouerRepository.existsByNom(jouer.getNom());
            return new MessageResponse(false,"Echec !","Cette jouer existe déja !");
        }
        jouerRepository.save(jouer);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}

    @Transactional
	@Override
	public MessageResponse delete(Long id) {
        Jouer jouer = findById(id);
        if (jouer==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        jouerRepository.delete(jouer);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
	}

    @Transactional
	@Override
	public List<Jouer> findAll() {
        return jouerRepository.findAll();
	}

    @Transactional
	@Override
	public Jouer findById(Long id) {
        Jouer domaine = jouerRepository.findById(id).orElse(null);
        return domaine;
	}

}
