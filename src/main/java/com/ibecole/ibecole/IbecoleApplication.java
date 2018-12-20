package com.ibecole.ibecole;

import com.ibecole.ibecole.entity.business.Eleve;
import com.ibecole.ibecole.entity.business.TypeSanction;
import com.ibecole.ibecole.model.request.AbsenceRequest;
import com.ibecole.ibecole.model.request.PersonneRequest;
import com.ibecole.ibecole.service.business.AbsenceService;
import com.ibecole.ibecole.service.business.PersonneService;
import com.ibecole.ibecole.service.business.TypeSanctionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.convert.ConversionService;

import java.time.LocalDate;

@SpringBootApplication
public class IbecoleApplication implements CommandLineRunner{

	private final AbsenceService absenceService;
	private final ConversionService conversionService;
	private final PersonneService personneService;
	private final TypeSanctionService typeSanctionService;

	public IbecoleApplication(AbsenceService absenceService, ConversionService conversionService, PersonneService personneService, TypeSanctionService typeSanctionService) {
		this.absenceService = absenceService;
		this.conversionService = conversionService;
		this.personneService = personneService;
		this.typeSanctionService = typeSanctionService;
	}

/*
	@Autowired
	public IbecoleApplication(PersonneService personneService, ConversionService conversionService,NiveauService niveauService) {
		this.personneService = personneService;
		this.conversionService = conversionService;
		this.niveauService =  niveauService;
	}
*/

	public static void main(String[] args) {
		SpringApplication.run(IbecoleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	PersonneRequest personneRequest = new PersonneRequest();

		TypeSanction typeSanction = new TypeSanction();
		typeSanction.setCode("SANC-001");
		typeSanction.setLibelle("BLAME");
		typeSanctionService.save(typeSanction);

		/*Niveau niveau = new Niveau();
		niveau.setCode("TEST");
		niveau.setLibelle("TEST1");
		niveauService.save(niveau);*/

		personneRequest.setType("Eleve");
		personneRequest.setNom("IDIRENE");
		personneRequest.setPrenom("Mehdi");
		personneRequest.setDateNaissance(LocalDate.now());
		personneRequest.setSexe("Homme");
		personneRequest.setLieuNaissance("Belouezdad");
		personneRequest.setTelephone("+213 551 89 68 95");
		personneRequest.setEmail("mehdi.bouzidi.92@gmail.com");
		personneRequest.setActive(true);
		personneRequest.setAdresse("Bab Ezzouar");

		Eleve eleve = (Eleve) personneService.save(personneRequest);

		AbsenceRequest absenceRequest = new AbsenceRequest();

		absenceRequest.setDateAbsence(LocalDate.now());
		absenceRequest.setCodeJustificatif("JUSTI-001");
		absenceRequest.setLibelleJustificatif("Maladie");

		absenceRequest.setIdEleve(eleve.getId());
/*		absenceService.save(absenceRequest);*/



	}
}
