package com.ibecole.ibecole;

import com.ibecole.ibecole.convertor.PersonneRequestToEleveConverter;
import com.ibecole.ibecole.entity.business.Eleve;
import com.ibecole.ibecole.model.request.PersonneRequest;
import com.ibecole.ibecole.service.business.PersonneService;
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

	@Autowired
	private PersonneService personneService;
	@Autowired
	private ConversionService conversionService;

	public static void main(String[] args) {
		SpringApplication.run(IbecoleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*Page<Eleve> list = null;
		list.map(new PersonneRequestToEleveConverter());*/
		PersonneRequest personneRequest = new PersonneRequest();

		personneRequest.setType("Eleve");
		personneRequest.setNom("IDIRENE");
		personneRequest.setPrenom("Mehdi");
		personneRequest.setDateNaissance(LocalDate.now());
		personneRequest.setSexe("Homme");
		personneRequest.setLieuNaissance("Belouezdad");
		personneRequest.setTelephone("+213 551 89 68 95");
		personneRequest.setEmail("mehdi.bouzidi.92@gmail.com");
		personneRequest.setActive(true);
		personneRequest.setMatricule("ELV-000015");
		personneRequest.setAdresse("Bab Ezzouar");

		Eleve eleve = (Eleve) personneService.save(personneRequest);
		System.out.println("==================");
		System.out.println(eleve.getId());
		System.out.println(eleve.getMatricule());

	}
}
