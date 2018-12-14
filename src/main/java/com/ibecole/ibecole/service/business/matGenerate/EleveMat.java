package com.ibecole.ibecole.service.business.matGenerate;

import com.ibecole.ibecole.commun.qualifier.MatGeneration;
import com.ibecole.ibecole.model.request.PersonneRequest;
import org.springframework.stereotype.Component;


/**
 * Created by TOSHIBA on 12/12/2018.
 */
@MatGeneration(value = MatGeneration.typeMat.ELEVE)
@Component
public class EleveMat implements MatriculeGenerate {
    @Override
    public String Generate(PersonneRequest personneRequest) {
        return "ELEVE-"+personneRequest.hashCode();
    }
}
