package isi.tn.wordcup.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.tn.wordcup.entities.Arbitre;
import isi.tn.wordcup.entities.Equipe;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long>{

	Optional<Equipe> findByNom(String nom);

	Boolean existsByNom(String nom);
}
