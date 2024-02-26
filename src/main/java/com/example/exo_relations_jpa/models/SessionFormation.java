package com.example.exo_relations_jpa.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class SessionFormation {
	
	private String libelle;
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

}
