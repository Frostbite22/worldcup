package isi.tn.wordcup.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.tn.wordcup.entities.Equipe;
import isi.tn.wordcup.entities.Groupe;

@Repository
public interface GroupeRepository extends JpaRepository<Groupe, Long>{

}
