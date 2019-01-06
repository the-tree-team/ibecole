package com.ibecole.ibecole.controller.rest;

import com.ibecole.ibecole.controller.rest.resources.RestConstants;
import com.ibecole.ibecole.entity.business.Matiere;
import com.ibecole.ibecole.entity.business.Sanction;
import com.ibecole.ibecole.repository.business.MatiereRepository;
import com.ibecole.ibecole.service.business.MatiereService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestConstants.MATIERE_V1)
@CrossOrigin
public class MatiereRest {

    private MatiereService matiereService;

    public MatiereRest(MatiereService matiereService) {
        this.matiereService = matiereService;
    }

    //Find ALL
    @RequestMapping(path ="", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Page<Matiere> getAllMatiere (Pageable pageable) {

        Page<Matiere> matierePage= matiereService.findAll(pageable);

        return matierePage;
    }
}
