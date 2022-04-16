package isi.tn.wordcup.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.tn.wordcup.entities.Stade;
import isi.tn.wordcup.entities.Tournoir;

@Repository
public interface TournoirRepository extends JpaRepository<Tournoir, Long>{

	Optional<Tournoir> findByNom(String nom);

	Boolean existsByNom(String nom);
}
