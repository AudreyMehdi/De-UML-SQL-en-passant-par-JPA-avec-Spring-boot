package com.example.exo_relations_jpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.exo_relations_jpa.models.Apprenant;
import com.example.exo_relations_jpa.models.Competence;
import com.example.exo_relations_jpa.repository.ApprenantRepository;
import com.example.exo_relations_jpa.repository.CompetenceRepository;

@SpringBootTest
public class ApprenantTest {
	
	
	@Autowired
	private ApprenantRepository apprenantrepo;
	@Autowired
	private CompetenceRepository competencerepo;
	
	@BeforeEach
	void nettoyage() {
	
		apprenantrepo.deleteAll();
		competencerepo.deleteAll();
	}
	
	@Test
   void testApprenant() {
	   
		Apprenant nemo = new Apprenant();
		Competence nager = new Competence();
		Competence buller = new Competence();
		
		nager.setLibelle("nager");
		nager.setNiveau(10);
		buller.setLibelle("buller");
		buller.setNiveau(3000);
		
		competencerepo.save(nager);
		competencerepo.save(buller);
		
		nemo.setNom("Nemo");
		nemo.setPrenom("Rouge");
		
		nemo.addCompetence(buller);
		nemo.addCompetence(nager);
		
		
	    apprenantrepo.save(nemo);
   }

}
