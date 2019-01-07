package com.ibecole.ibecole.controller.rest;

import com.ibecole.ibecole.controller.rest.resources.RestConstants;
import com.ibecole.ibecole.entity.business.Eleve;
import com.ibecole.ibecole.entity.business.Parent;
import com.ibecole.ibecole.entity.business.Professeur;
import com.ibecole.ibecole.entity.business.TypeSanction;
import com.ibecole.ibecole.model.request.PersonneRequest;
import com.ibecole.ibecole.model.response.PersonneResponse;
import com.ibecole.ibecole.service.business.PersonneService;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    //Find ALL Eleves
    @RequestMapping(path ="/eleves", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<PersonneResponse> getAllEleves (Pageable pageable) {

        Page<Eleve> elevePage = personneService.findAllEleve(pageable);
        List<PersonneResponse> responseList = elevePage.stream()
                .map(item -> conversionService.convert(item, PersonneResponse.class))
                .collect(Collectors.toList());
        Page<PersonneResponse> personneResponsePage = new PageImpl<PersonneResponse>(responseList);
        return personneResponsePage;
    }
    //Find ALL Parents
    @RequestMapping(path ="/parents", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<PersonneResponse> getAllParents (Pageable pageable) {

        Page<Parent> parentPage = personneService.findAllParent(pageable);
        List<PersonneResponse> responseList = parentPage.stream()
                .map(item -> conversionService.convert(item, PersonneResponse.class))
                .collect(Collectors.toList());

        Page<PersonneResponse> personneResponsePage = new PageImpl<PersonneResponse>(responseList);
        return personneResponsePage;
    }
    //Find ALL Professeurs
    @RequestMapping(path ="/professeurs", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<PersonneResponse> getAllProfesseurs (Pageable pageable) {

        Page<Professeur> professeurPage= personneService.findAllProfesseur(pageable);
        List<PersonneResponse> responseList = professeurPage.stream()
                .map(item -> conversionService.convert(item, PersonneResponse.class))
                .collect(Collectors.toList());
        Page<PersonneResponse> personneResponsePage = new PageImpl<PersonneResponse>(responseList);
        return personneResponsePage;
    }
    @RequestMapping(path="add", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<PersonneResponse> createSanction(
            @RequestPart("file") MultipartFile file,
            @RequestPart("personne") PersonneRequest personneRequest
    ){
        personneRequest.setPhoto(file);
        if (file!= null) {
            System.out.println(file.getOriginalFilename());
        }
        if(personneRequest != null){
            System.out.println(personneRequest.getNom());
        }

        personneService.save(personneRequest);
        return null;

    }
}
