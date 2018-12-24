package com.ibecole.ibecole.controller.rest;

import com.ibecole.ibecole.controller.rest.resources.RestConstants;
import com.ibecole.ibecole.entity.business.Sanction;
import com.ibecole.ibecole.service.business.SanctionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(RestConstants.SANCTION_V1)
@CrossOrigin
public class SanctionRest {

    SanctionService sanctionService;

    public SanctionRest(SanctionService sanctionService) {
        this.sanctionService = sanctionService;
    }

    //Find ALL
    @RequestMapping(path ="", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<Sanction> getAllTypeSanction (Pageable pageable) {

        Page<Sanction> typeSanctionPage = sanctionService.pageableFindAll(pageable);

        return typeSanctionPage;
    }

    // Find By ID
    @RequestMapping(path = "/{sanctionid}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Sanction> getSanctionById(
            @PathVariable Integer sanctionId) {

        Sanction sanction = sanctionService.findById(sanctionId);
        return new ResponseEntity<>(sanction, HttpStatus.OK);
    }

    //ADD
    @RequestMapping(path="add", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Sanction> createSanction(
            @RequestBody Sanction sanction
    ){
        sanctionService.save(sanction);
        return new ResponseEntity<>(sanction, HttpStatus.CREATED);
    }

    //UPDATE
    @RequestMapping(path="edit", method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Sanction> updateSanction(
            @RequestBody Sanction sanction
    ){
        sanctionService.save(sanction);
        return new ResponseEntity<>(sanction, HttpStatus.CREATED);
    }

    //DELETE
    @RequestMapping(path = "/{sanctionid}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteReservation(
            @PathVariable("sanctionid") Integer sanctionId) {
        System.out.println("SANCTION ID:" + sanctionId);
        sanctionService.delete(sanctionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
