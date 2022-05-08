package isi.tn.wordcup.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.tn.wordcup.entities.Tournoi;

@Repository
public interface TournoiRepository extends JpaRepository<Tournoi, Long>{

	Optional<Tournoi> findByNom(String nom);

	Boolean existsByNom(String nom);
}
