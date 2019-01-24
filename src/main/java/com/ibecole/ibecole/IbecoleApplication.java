package com.ibecole.ibecole;

import com.ibecole.ibecole.entity.business.*;
import com.ibecole.ibecole.model.request.AbsenceRequest;
import com.ibecole.ibecole.model.request.PersonneRequest;
import com.ibecole.ibecole.repository.admin.RoleRepository;
import com.ibecole.ibecole.repository.admin.UserRepository;
import com.ibecole.ibecole.service.business.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootApplication
public class IbecoleApplication implements CommandLineRunner{

	private final AbsenceService absenceService;
	private final ConversionService conversionService;
	private final PersonneService personneService;
	private final TypeSanctionService typeSanctionService;
	private final SanctionService sanctionService;
	private final MatiereService matiereService;
	private final RoleRepository roleRepository;
	private final UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;


	public IbecoleApplication(AbsenceService absenceService, ConversionService conversionService, PersonneService personneService, TypeSanctionService typeSanctionService, SanctionService sanctionService, MatiereService matiereService, RoleRepository roleRepository, UserRepository userRepository) {
		this.absenceService = absenceService;
		this.conversionService = conversionService;
		this.personneService = personneService;
		this.typeSanctionService = typeSanctionService;
		this.sanctionService = sanctionService;
		this.matiereService = matiereService;
		this.roleRepository = roleRepository;
		this.userRepository = userRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(IbecoleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		PersonneRequest personneRequest = new PersonneRequest();

		TypeSanction typeSanction1 = new TypeSanction();
		typeSanction1.setCode("SANC-001");
		typeSanction1.setLibelle("BLAME");
		typeSanctionService.save(typeSanction1);
		TypeSanction typeSanction = new TypeSanction();
		typeSanction.setCode("SANC-002");
		typeSanction.setLibelle("AVERTISSEMENT");
		typeSanction = typeSanctionService.save(typeSanction);

		Sanction sanction = new Sanction();
		sanction.setMotif("Retard");
		sanction.setCommentaire("Un retard de 2h dans la séance d'Histoire-Géo");
		sanction.setType(typeSanction);
		sanctionService.save(sanction);
		sanction = new Sanction();
		sanction.setMotif("Manque de Respect");
		sanction.setCommentaire("L'étudiant a manqué de respect au professeur de Français");
		sanction.setType(typeSanction1);
		sanctionService.save(sanction);

		personneRequest.setType("Professeur");
		personneRequest.setNom("IDIRENE");
		personneRequest.setPrenom("Mehdi");
		personneRequest.setDateNaissance(LocalDate.now());
		personneRequest.setSexe("Homme");
		personneRequest.setLieuNaissance("Belouezdad");
		personneRequest.setTelephone("+213 551 89 68 95");
		personneRequest.setEmail("mehdi.bouzidi.92@gmail.com");
		personneRequest.setActive(true);
		personneRequest.setAdresse("Bab Ezzouar");

		Professeur eleve = (Professeur) personneService.save(personneRequest);

		AbsenceRequest absenceRequest = new AbsenceRequest();

		absenceRequest.setDateAbsence(LocalDate.now());
		absenceRequest.setCodeJustificatif("JUSTI-001");
		absenceRequest.setLibelleJustificatif("Maladie");

		absenceRequest.setIdEleve(eleve.getId());
/*		absenceService.save(absenceRequest);*/
		Matiere matiere = new Matiere();
		matiere.setCode("MATH-001");
		matiere.setLibelle("Mathématique");
		matiere.setCouleur("#0F4162");
		matiere.setInFormation(new ArrayList<>());
		matiere.setEnseigner(new ArrayList<>());
		matiereService.save(matiere);
		matiere = new Matiere();
		matiere.setInFormation(new ArrayList<>());
		matiere.setEnseigner(new ArrayList<>());
		matiere.setCode("PHY-002");
		matiere.setLibelle("Physique");
		matiere.setCouleur("#EEDD82");
		matiereService.save(matiere);


	}
}
