package com.example.exo_relations_jpa.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class DossierAdministratif {
	
	private String tuteurNom;
	private String tuteurEmail;
	
	@OneToOne
	private Apprenant apprenant;
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;


}
