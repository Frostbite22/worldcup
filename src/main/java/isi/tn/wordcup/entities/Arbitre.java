package isi.tn.wordcup.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "arbitres")
public class Arbitre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max = 50)
	private String nom;
	@NotBlank
	@Size(max = 50)
	private String prenom;
	@ManyToOne
	private Match match;
	
	public Arbitre() {
	}

	public Arbitre(Long id, @NotBlank @Size(max = 50) String nom, @NotBlank @Size(max = 50) String prenom
			, Match match) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.match = match;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}
	
}
