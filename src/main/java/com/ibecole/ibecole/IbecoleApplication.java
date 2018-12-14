package com.ibecole.ibecole;

import com.ibecole.ibecole.commun.qualifier.MatGeneration;
import com.ibecole.ibecole.service.business.matGenerate.MatriculeGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IbecoleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(IbecoleApplication.class, args);
	}
		@Autowired
		private @MatGeneration(MatGeneration.typeMat.PARENT) MatriculeGenerate matriculeGenerate;

		@Override
		public void run(String... strings) throws Exception {
			System.out.println( "dans le main de merde  putain de  ta race marche");
			System.out.println(matriculeGenerate.Generate());
		}

}
