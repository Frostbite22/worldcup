package isi.tn.wordcup.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.tn.wordcup.entities.Equipe;
import isi.tn.wordcup.payload.response.MessageResponse;
import isi.tn.wordcup.repositories.EquipeRepository;

@Service
public class ImpEquipeService implements IEquipeService{
	@Autowired
	EquipeRepository equipeRepository;

    @Transactional
	@Override
	public MessageResponse save(Equipe equipe) {
        boolean existe = equipeRepository.existsByNom(equipe.getNom());
        if (existe){
            return new MessageResponse(false,"Echec !","Cette equipe existe déja !");
        }
        equipeRepository.save(equipe);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}

    @Transactional
	@Override
	public MessageResponse update(Equipe equipe) {
		boolean existe = equipeRepository.existsById(equipe.getId());
        if (!existe){
            boolean existe1 = equipeRepository.existsByNom(equipe.getNom());
            return new MessageResponse(false,"Echec !","Cette equipe existe déja !");
        }
        equipeRepository.save(equipe);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}

    @Transactional
	@Override
	public MessageResponse delete(Long id) {
		Equipe equipe = findById(id);
        if (equipe==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        equipeRepository.delete(equipe);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
	}

    @Transactional
	@Override
	public List<Equipe> findAll() {
        return equipeRepository.findAll();
	}

    @Transactional
	@Override
	public Equipe findById(Long id) {
        Equipe equipe = equipeRepository.findById(id).orElse(null);
        return equipe;
	}

}
