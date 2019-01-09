package com.ibecole.ibecole.controller.rest;

import com.ibecole.ibecole.controller.rest.resources.RestConstants;
import com.ibecole.ibecole.entity.business.Niveau;
import com.ibecole.ibecole.entity.business.TypeSanction;
import com.ibecole.ibecole.service.business.NiveauService;
import com.ibecole.ibecole.service.business.TypeSanctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(RestConstants.NIVEAU_V1)
@CrossOrigin
public class NiveauRest {

    private NiveauService niveauService;

    @Autowired
    public NiveauRest(NiveauService niveauService) {
        this.niveauService = niveauService;
    }

    //Find ALL
    @RequestMapping(path ="", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<Niveau> getAllNiveau (Pageable pageable) {

        Page<Niveau> niveauPage = niveauService.pageableFindAll(pageable);

        return niveauPage;
    }

    // Find By ID
    @RequestMapping(path = "/{niveauid}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Niveau> getNiveauById(
            @PathVariable Integer niveauId) {

        Niveau niveau = niveauService.findById(niveauId);

        return new ResponseEntity<>(niveau, HttpStatus.OK);
    }

    //ADD
    @RequestMapping(path="add", method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Niveau> createNiveau(
    @RequestBody Niveau niveau
    ){
        niveauService.save(niveau);
        return new ResponseEntity<>(niveau, HttpStatus.CREATED);
    }

    //UPDATE
    @RequestMapping(path="edit", method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Niveau> updateTypeSanction(
            @RequestBody Niveau niveau
    ){
        niveauService.save(niveau);
        return new ResponseEntity<>(niveau, HttpStatus.CREATED);
    }

    //DELETE
    @RequestMapping(path = "/{niveauId}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteNiveau(
            @PathVariable("niveauId") Integer niveauId) {
        System.out.println("niveau ID:" + niveauId);
        niveauService.delete(niveauId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
