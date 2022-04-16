package isi.tn.wordcup.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.tn.wordcup.entities.Jouer;
import isi.tn.wordcup.entities.Match;

public interface MatchRepository extends JpaRepository<Match, Long>{

}
