package isi.tn.wordcup.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import isi.tn.wordcup.entities.ERole;
import isi.tn.wordcup.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
	
	Optional<Role> findByName(ERole name);
    Boolean existsByName(ERole name);
    
}
