package isi.tn.wordcup.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.tn.wordcup.entities.Joueur;
import isi.tn.wordcup.entities.Stade;

@Repository
public interface StadeRepository extends JpaRepository<Stade, Long>{

	Optional<Stade> findByNom(String nom);

	Boolean existsByNom(String nom);
}
