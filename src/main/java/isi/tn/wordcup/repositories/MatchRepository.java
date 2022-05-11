package isi.tn.wordcup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.tn.wordcup.entities.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long>{

}
