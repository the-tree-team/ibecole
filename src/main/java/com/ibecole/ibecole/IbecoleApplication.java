package com.ibecole.ibecole;

import com.ibecole.ibecole.commun.qualifier.MatGeneration;
import com.ibecole.ibecole.convertor.PersonneRequestToEleveConverter;
import com.ibecole.ibecole.entity.business.Eleve;
import com.ibecole.ibecole.entity.business.Niveau;
import com.ibecole.ibecole.entity.business.Parent;
import com.ibecole.ibecole.entity.business.Personne;
import com.ibecole.ibecole.model.request.PersonneRequest;
import com.ibecole.ibecole.service.business.NiveauService;
import com.ibecole.ibecole.service.business.PersonneService;
import com.ibecole.ibecole.service.business.matGenerate.MatriculeGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

@SpringBootApplication
public class IbecoleApplication implements CommandLineRunner{

//	private final PersonneService personneService;
//	private final ConversionService conversionService;
	private final NiveauService niveauService;


	@Autowired
	public IbecoleApplication(/*PersonneService personneService, ConversionService conversionService,*/NiveauService niveauService) {
//		this.personneService = personneService;
//		this.conversionService = conversionService;
		this.niveauService =  niveauService;
	}

	public static void main(String[] args) {
		SpringApplication.run(IbecoleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*Page<Eleve> list = null;
		list.map(new PersonneRequestToEleveConverter());*/
		PersonneRequest personneRequest = new PersonneRequest();

		Niveau niveau = new Niveau();
		niveau.setCode("TEST");
		niveau.setLibelle("TEST1");
		niveauService.save(niveau);

//		personneRequest.setType("Parent");
//		personneRequest.setNom("IDIRENE");
//		personneRequest.setPrenom("Mehdi");
//		personneRequest.setDateNaissance(LocalDate.now());
//		personneRequest.setSexe("Homme");
//		personneRequest.setLieuNaissance("Belouezdad");
//		personneRequest.setTelephone("+213 551 89 68 95");
//		personneRequest.setEmail("mehdi.bouzidi.92@gmail.com");
//		personneRequest.setActive(true);
//		personneRequest.setAdresse("Bab Ezzouar");
//
//		Parent eleve = (Parent) personneService.save(personneRequest);
		/*Parent eleve2 = (Parent) personneService.findById(1,"Parent");
		System.out.println("==================");
		System.out.println(eleve2.getNom());*/
		/*System.out.println(eleve2.getMatricule());*/
/*		personneService.delete(1,"Parent");*/


	}
}
