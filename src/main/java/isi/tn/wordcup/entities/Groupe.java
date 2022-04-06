package isi.tn.wordcup.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "groupes")
public class Groupe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private int numero;
	@OneToMany(mappedBy="groupe")
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private Collection<Equipe> equipes;
	
	
	public Groupe() {
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public Collection<Equipe> getEquipes() {
		return equipes;
	}


	public void setEquipes(Collection<Equipe> equipes) {
		this.equipes = equipes;
	}
	
	
}
