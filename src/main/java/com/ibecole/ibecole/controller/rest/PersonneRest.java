package com.ibecole.ibecole.controller.rest;

import com.ibecole.ibecole.controller.rest.resources.RestConstants;
import com.ibecole.ibecole.entity.business.*;
import com.ibecole.ibecole.model.request.PersonneRequest;
import com.ibecole.ibecole.model.response.PersonneResponse;
import com.ibecole.ibecole.service.business.PersonneService;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(RestConstants.PERSONNE_V1)
@CrossOrigin
public class PersonneRest {

    private PersonneService personneService;
    private ConversionService conversionService;

    public PersonneRest(PersonneService personneService, ConversionService conversionService) {
        this.personneService = personneService;
        this.conversionService = conversionService;
    }
/*
    //ADD
    @RequestMapping(path="add", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PersonneResponse> createSanction(
            @RequestBody PersonneRequest personneRequest
    ){
        System.out.println("REST: PERSONNE-Request: "+personneRequest.getNom() + " "+ personneRequest.getPrenom());
        PersonneResponse personneResponse;
        switch (personneRequest.getType()){
            case "Eleve":{
                Eleve eleve=(Eleve) personneService.save(personneRequest);
                System.out.println("REST: ELEVE: "+eleve.getNom() + " "+ eleve.getPrenom());
                personneResponse = conversionService.convert(eleve, PersonneResponse.class);
                System.out.println("REST: PERSONNE-Response: "+personneResponse.getNom() + " "+ personneResponse.getPrenom());
                break;
            }
            case "Parent":{
                Parent parent=(Parent) personneService.save(personneRequest);
                personneResponse = conversionService.convert(parent, PersonneResponse.class);
                break;
            }
            case "Professeur":{
                Professeur professeur=(Professeur) personneService.save(personneRequest);
                personneResponse = conversionService.convert(professeur, PersonneResponse.class);
                break;
            }
            default: return null;

        }
        return new ResponseEntity<>(personneResponse, HttpStatus.CREATED);

    } */
    @RequestMapping(path="add", method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,headers = "content-type=multipart/form-data")
    public ResponseEntity<PersonneResponse> createSanction(
            @RequestParam MultipartFile file
    ){
        if (file != null) {
            System.out.println(file.getOriginalFilename());
        }
        return null;

    }
}
