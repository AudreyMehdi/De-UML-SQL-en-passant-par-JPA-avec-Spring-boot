package com.example.exo_relations_jpa.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Competence {
	
	private String libelle;
	private int niveau;
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;


}
