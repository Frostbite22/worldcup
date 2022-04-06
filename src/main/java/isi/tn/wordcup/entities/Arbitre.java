package isi.tn.wordcup.entities;

import java.util.Date;

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
	private String filiere;
	private String niveau;
	@ManyToOne
	private Match match;
	
	public Arbitre() {
	}

	public Arbitre(Long id, @NotBlank @Size(max = 50) String nom, @NotBlank @Size(max = 50) String prenom,
			String filiere, String niveau, Match match) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.filiere = filiere;
		this.niveau = niveau;
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

	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}
	
	
}
