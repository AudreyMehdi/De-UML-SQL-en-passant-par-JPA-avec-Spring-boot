package com.example.exo_relations_jpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.exo_relations_jpa.models.Apprenant;
import com.example.exo_relations_jpa.models.Competence;
import com.example.exo_relations_jpa.models.DossierAdministratif;
import com.example.exo_relations_jpa.models.SessionFormation;
import com.example.exo_relations_jpa.repository.ApprenantRepository;
import com.example.exo_relations_jpa.repository.CompetenceRepository;
import com.example.exo_relations_jpa.repository.DossierAdministratifRepository;
import com.example.exo_relations_jpa.repository.SessionFormationRepository;

@SpringBootTest
public class LeToutTest {
	
	@Autowired
	private DossierAdministratifRepository dossierAdmistratifRepo;
	@Autowired
	private ApprenantRepository apprenantrepo;
	@Autowired
	private CompetenceRepository competencerepo;
	@Autowired
	private SessionFormationRepository sessionrepo;
	

	@BeforeEach
	void nettoyage() {
		
		
		apprenantrepo.deleteAll();
		competencerepo.deleteAll();
		dossierAdmistratifRepo.deleteAll();
		sessionrepo.deleteAll();
	}
	
	@Test
	void monTestTout() {
		
		Apprenant guy = new Apprenant();
		Apprenant henri = new Apprenant();
	
	    Competence sauter = new Competence();
	    Competence nager = new Competence();
	    
		DossierAdministratif titre = new DossierAdministratif();
		DossierAdministratif examen = new DossierAdministratif();
		
		SessionFormation cda = new SessionFormation();
		
		cda.setLibelle("cda");
		sessionrepo.save(cda);
		
		sauter.setLibelle("sauter");
		sauter.setNiveau(45);
		competencerepo.save(sauter);
		
		nager.setLibelle("nager");
		nager.setNiveau(50);
		competencerepo.save(nager);
		
		guy.setPrenom("Guy");
		guy.setNom("Mehdi");
		guy.addCompetence(sauter);
		guy.setSessionFormation(cda);
		apprenantrepo.save(guy);
		
		henri.setPrenom("Henri");
		henri.setNom("Dupont");
		henri.addCompetence(nager);
		henri.addCompetence(sauter);
		henri.setSessionFormation(cda);
		apprenantrepo.save(henri);
		
		titre.setApprenant(guy);
		titre.setTuteurNom("Tuteur");
		titre.setTuteurEmail("tuteur@mail.com");
		dossierAdmistratifRepo.save(titre);
		
		examen.setApprenant(henri);
		examen.setTuteurNom("Tuteur2");
		examen.setTuteurEmail("tuteur2@mail.com");
		dossierAdmistratifRepo.save(examen);
		
		
		
		
	}
	
}


