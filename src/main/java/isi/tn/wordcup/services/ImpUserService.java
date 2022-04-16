package isi.tn.wordcup.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.tn.wordcup.entities.User;
import isi.tn.wordcup.payload.response.MessageResponse;
import isi.tn.wordcup.repositories.UserRepository;


@Service
public class ImpUserService implements IUserService {
	@Autowired
	UserRepository userRepository;

    @Transactional
	@Override
	public MessageResponse save(User user) {
        boolean existe = userRepository.existsByUsername(user.getUsername());
        boolean existe2 = userRepository.existsByEmail(user.getEmail());
        if (existe){
            return new MessageResponse(false,"Echec !","Cette user existe déja !");
        }
        if (existe2){
            return new MessageResponse(false,"Echec !","Cette email existe déja !");
        }
        userRepository.save(user);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}

    @Transactional
	@Override
	public MessageResponse update(User user) {
    	boolean existe = userRepository.existsById(user.getId());
        if (!existe){
            boolean existe1 = userRepository.existsByUsername(user.getUsername());
            boolean existe2 = userRepository.existsByEmail(user.getEmail());
            return new MessageResponse(false,"Echec !","Cette utilisateur existe déja !");
        }
        userRepository.save(user);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");
	}

    @Transactional
	@Override
	public MessageResponse delete(Long id) {
        User utilisateur = findById(id);
        if (utilisateur==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        userRepository.delete(utilisateur);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");
	}

    @Transactional
	@Override
	public List<User> findAll() {
        return userRepository.findAll();
	}

    @Transactional
	@Override
	public User findById(Long id) {
        User utilisateur = userRepository.findById(id).orElse(null);
        return utilisateur;
	}


}