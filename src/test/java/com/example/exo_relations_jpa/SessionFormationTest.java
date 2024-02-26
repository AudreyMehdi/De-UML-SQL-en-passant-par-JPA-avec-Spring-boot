package com.example.exo_relations_jpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.exo_relations_jpa.models.SessionFormation;
import com.example.exo_relations_jpa.repository.SessionFormationRepository;

@SpringBootTest
public class SessionFormationTest {
	
	@Autowired
	private SessionFormationRepository sessionFormationRepo;
	
	@BeforeEach
	void nettoyage() {
		sessionFormationRepo.deleteAll();
	}

	@Test
	void testSessionFormation() {
	SessionFormation cda = new SessionFormation();	
	
	cda.setLibelle("cda");
	
	sessionFormationRepo.save(cda);
	}
	
	
}
