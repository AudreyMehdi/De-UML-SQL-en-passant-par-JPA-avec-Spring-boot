package com.example.exo_relations_jpa.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
public class Apprenant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nom;
	private String prenom;

	@ManyToMany
	// @Getter(value = AccessLevel.PRIVATE)
	@Setter(value = AccessLevel.PROTECTED)
	private Set<Competence> competences = new HashSet<Competence>();
	
	@ManyToOne
	private SessionFormation sessionFormation;

	public List<Competence> getCompetences() {
		return Collections.unmodifiableList(new ArrayList<>(competences));
	}

	public void addCompetence(Competence nouvelleCompetence) {
		this.competences.add(nouvelleCompetence);
	}
}
