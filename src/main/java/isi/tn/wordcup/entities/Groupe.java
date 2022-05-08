package isi.tn.wordcup.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "groupes")
public class Groupe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nom;
	@OneToMany(mappedBy="groupe")
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private Collection<Equipe> equipes;
	
	
	public Groupe() {
	}


	public Groupe(Long id, @NotBlank String nom, Collection<Equipe> equipes) {
		super();
		this.id = id;
		this.nom = nom;
		this.equipes = equipes;
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


	public Collection<Equipe> getEquipes() {
		return equipes;
	}


	public void setEquipes(Collection<Equipe> equipes) {
		this.equipes = equipes;
	}
	
	
}
