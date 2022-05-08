package isi.tn.wordcup.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "equipes",uniqueConstraints = { 
		@UniqueConstraint(columnNames = "nom")
	})
public class Equipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max = 50)
	private String nom;
	private String drapeau;
	@ManyToOne
	private Groupe groupe;
	@OneToMany(mappedBy="equipe")
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private Collection<Jouer> jouers;
	@OneToMany(mappedBy="nomEquipe1")
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private Collection<Match> matchs1;

	@OneToMany(mappedBy="nomEquipe2")
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private Collection<Match> matchs2;
	
	public Equipe() {
	}

	public Equipe(Long id, @NotBlank @Size(max = 50) String nom, String drapeau, Groupe groupe,
			Collection<Jouer> jouers, Collection<Match> matchs1,
			Collection<Match> matchs2) {
		super();
		this.id = id;
		this.nom = nom;
		this.drapeau = drapeau;
		this.groupe = groupe;
		this.jouers = jouers;
		this.matchs1 = matchs1;
		this.matchs2 = matchs2;
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


	public Groupe getGroupe() {
		return groupe;
	}


	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}


	public Collection<Jouer> getJouers() {
		return jouers;
	}


	public void setJouers(Collection<Jouer> jouers) {
		this.jouers = jouers;
	}

	public Collection<Match> getMatchs1() {
		return matchs1;
	}


	public String getDrapeau() {
		return drapeau;
	}


	public void setDrapeau(String drapeau) {
		this.drapeau = drapeau;
	}


	public void setMatchs1(Collection<Match> matchs1) {
		this.matchs1 = matchs1;
	}


	public Collection<Match> getMatchs2() {
		return matchs2;
	}


	public void setMatchs2(Collection<Match> matchs2) {
		this.matchs2 = matchs2;
	}
	
}
