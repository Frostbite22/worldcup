package isi.tn.wordcup.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.tn.wordcup.entities.Joueur;
import isi.tn.wordcup.payload.response.MessageResponse;
import isi.tn.wordcup.repositories.JoueurRepository;

@Service
public class ImpJoueurService implements IJoueurService{
	@Autowired
	JoueurRepository joueurRepository;

    @Transactional
	@Override
	public MessageResponse save(Joueur joueur) {
        boolean existe = joueurRepository.existsByNom(joueur.getNom());
        if (existe){
            return new MessageResponse(false,"Echec !","Cette jouer existe déja !");
        }
        joueurRepository.save(joueur);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}

    @Transactional
	@Override
	public MessageResponse update(Joueur joueur) {
        boolean existe = joueurRepository.existsById(joueur.getId());
        if (!existe){
            boolean existe1 = joueurRepository.existsByNom(joueur.getNom());
            return new MessageResponse(false,"Echec !","Cette joueur existe déja !");
        }
        joueurRepository.save(joueur);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}

    @Transactional
	@Override
	public MessageResponse delete(Long id) {
        Joueur joueur = findById(id);
        if (joueur==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        joueurRepository.delete(joueur);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
	}

    @Transactional
	@Override
	public List<Joueur> findAll() {
        return joueurRepository.findAll();
	}

    @Transactional
	@Override
	public Joueur findById(Long id) {
        Joueur joueur = joueurRepository.findById(id).orElse(null);
        return joueur;
	}

}
