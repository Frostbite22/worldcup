package isi.tn.wordcup.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import isi.tn.wordcup.entities.Role;
import isi.tn.wordcup.payload.response.MessageResponse;
import isi.tn.wordcup.repositories.RoleRepository;

@Service
public class RoleServiceImpl implements IRoleService{

    @Autowired
    RoleRepository roleRepository;

    @Transactional
	@Override
	public MessageResponse save(Role role) {
        boolean existe = roleRepository.existsByName(role.getName());
        if (existe){
            return new MessageResponse(false,"Echec !","Cette nom existe déja !");
        }
        roleRepository.save(role);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");

	}

    @Transactional
	@Override
	public MessageResponse update(Role role) {
        boolean existe = roleRepository.existsById(role.getId());
        if (!existe){
            boolean existe1 = roleRepository.existsByName(role.getName());
            return new MessageResponse(false,"Echec !","Cette role existe déja !");
        }
        roleRepository.save(role);
        return new MessageResponse(true,"Succès","Opération réalisée avec succès.");

	}

    @Transactional
	@Override
	public MessageResponse delete(Long id) {
        Role role = findById(id);
        if (role==null){
            return new MessageResponse(false,"Echec","Cet enregistrement n'existe pas !");
        }
        roleRepository.delete(role);
        return new MessageResponse(true,"Succès", "L'enregistrement à été supprimé avec succès.");

	}

    @Transactional
	@Override
	public List<Role> findAll() {
        return roleRepository.findAll();
	}

    @Transactional
	@Override
	public Role findById(Long id) {
        Role role = roleRepository.findById(id).orElse(null);
        return role;
	}

}
