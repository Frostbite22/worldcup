package isi.tn.wordcup.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.tn.wordcup.entities.Equipe;
import isi.tn.wordcup.entities.Joueur;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Long>{

	Optional<Joueur> findByNom(String nom);

	Boolean existsByNom(String nom);
}
