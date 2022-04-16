package isi.tn.wordcup.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.tn.wordcup.entities.Groupe;
import isi.tn.wordcup.payload.response.MessageResponse;
import isi.tn.wordcup.repositories.GroupeRepository;

@Service
public class ImpGroupeService implements IGroupeService{
	@Autowired
	GroupeRepository groupeRepository;

    @Transactional
	@Override
	public MessageResponse save(Groupe groupe) {
        groupeRepository.save(groupe);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}

    @Transactional
	@Override
	public MessageResponse update(Groupe groupe) {
        boolean existe = groupeRepository.existsById(groupe.getId());
        if (!existe){
            return new MessageResponse(false,"Echec !","Cette groupe existe déja !");
        }
        groupeRepository.save(groupe);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}

    @Transactional
	@Override
	public MessageResponse delete(Long id) {
		Groupe groupe = findById(id);
        if (groupe==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        groupeRepository.delete(groupe);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
	}

    @Transactional
	@Override
	public List<Groupe> findAll() {
        return groupeRepository.findAll();
	}

    @Transactional
	@Override
	public Groupe findById(Long id) {
		Groupe domaine = groupeRepository.findById(id).orElse(null);
        return domaine;
	}

}
