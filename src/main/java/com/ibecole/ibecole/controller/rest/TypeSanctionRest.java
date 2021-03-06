package com.ibecole.ibecole.controller.rest;

import com.ibecole.ibecole.controller.rest.resources.RestConstants;
import com.ibecole.ibecole.entity.business.TypeSanction;
import com.ibecole.ibecole.service.business.TypeSanctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(RestConstants.TYPE_SANCTION_V1)
@CrossOrigin
public class TypeSanctionRest {

    private TypeSanctionService typeSanctionService;

    @Autowired
    public TypeSanctionRest(TypeSanctionService typeSanctionService) {
        this.typeSanctionService = typeSanctionService;
    }

    //Find ALL
    @RequestMapping(path ="", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<TypeSanction> getAllTypeSanction (Pageable pageable) {

        Page<TypeSanction> typeSanctionPage = typeSanctionService.pageableFindAll(pageable);

        return typeSanctionPage;
    }

    // Find By ID
    @RequestMapping(path = "/{typesanctionid}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<TypeSanction> getTypeSanctionById(
            @PathVariable Integer typeSanctionId) {

        TypeSanction typeSanction = typeSanctionService.findById(typeSanctionId);

        return new ResponseEntity<>(typeSanction, HttpStatus.OK);
    }

    //ADD
    @RequestMapping(path="add", method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<TypeSanction> createTypeSanction(
    @RequestBody TypeSanction typeSanction
    ){
        typeSanctionService.save(typeSanction);
        return new ResponseEntity<>(typeSanction, HttpStatus.CREATED);
    }

    //UPDATE
    @RequestMapping(path="edit", method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<TypeSanction> updateTypeSanction(
            @RequestBody TypeSanction typeSanction
    ){
        typeSanctionService.save(typeSanction);
        return new ResponseEntity<>(typeSanction, HttpStatus.CREATED);
    }

    //DELETE
    @RequestMapping(path = "/{typesanctionid}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteReservation(
            @PathVariable("typesanctionid") Integer typeSanctionId) {
        System.out.println("TYPE SANCTION ID:" + typeSanctionId);
            typeSanctionService.delete(typeSanctionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

  /*  @RequestMapping(value = "/{typesanctionid}",
            method = RequestMethod.DELETE)
    public @ResponseBody void deleteAuthorizationServer(
            @PathVariable("typesanctionid") Integer typeSanctionId){
        System.out.println("TYPE SANCTION ID:"+ typeSanctionId);
    }*/
}
