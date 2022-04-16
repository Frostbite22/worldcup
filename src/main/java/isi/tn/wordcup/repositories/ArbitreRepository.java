package isi.tn.wordcup.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.tn.wordcup.entities.Arbitre;
import isi.tn.wordcup.entities.User;

@Repository
public interface ArbitreRepository extends JpaRepository<Arbitre,Long>{
	
	Optional<Arbitre> findByNom(String nom);

	Boolean existsByNom(String nom);
}
