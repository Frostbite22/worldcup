package isi.tn.wordcup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import isi.tn.wordcup.entities.Match;

public interface MatchRepository extends JpaRepository<Match, Long>{

}
