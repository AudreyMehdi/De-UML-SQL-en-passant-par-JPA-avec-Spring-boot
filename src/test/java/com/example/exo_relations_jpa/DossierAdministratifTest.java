package com.example.exo_relations_jpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.exo_relations_jpa.models.Apprenant;
import com.example.exo_relations_jpa.models.Competence;
import com.example.exo_relations_jpa.models.DossierAdministratif;
import com.example.exo_relations_jpa.repository.ApprenantRepository;
import com.example.exo_relations_jpa.repository.CompetenceRepository;
import com.example.exo_relations_jpa.repository.DossierAdministratifRepository;

@SpringBootTest
public class DossierAdministratifTest {
	
	@Autowired
	private DossierAdministratifRepository dossierAdmistratifRepo;
	@Autowired
	private ApprenantRepository apprenantrepo;
	@Autowired
	private CompetenceRepository competencerepo;
	
	@BeforeEach
	void nettoyage() {
		dossierAdmistratifRepo.deleteAll();
	}
	
	@Test
	void testDossierAdministraif() {
		
	    Apprenant bernard = new Apprenant();
	    Competence courir = new Competence();
		DossierAdministratif examen = new DossierAdministratif();
		
		courir.setLibelle("courir");
		courir.setNiveau(45);
		
		competencerepo.save(courir);
		
		bernard.setPrenom("bernard");
		bernard.setNom("Duchain");
		bernard.addCompetence(courir);
		
		apprenantrepo.save(bernard);
		
		examen.setApprenant(bernard);
		examen.setTuteurNom("Jean");
		examen.setTuteurEmail("jean@mail.com");
		
		dossierAdmistratifRepo.save(examen);
		
		}
	}
