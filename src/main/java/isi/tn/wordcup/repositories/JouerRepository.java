package isi.tn.wordcup.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.tn.wordcup.entities.Equipe;
import isi.tn.wordcup.entities.Jouer;

@Repository
public interface JouerRepository extends JpaRepository<Jouer, Long>{

	Optional<Jouer> findByNom(String nom);

	Boolean existsByNom(String nom);
}
