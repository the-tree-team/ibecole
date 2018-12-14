package com.ibecole.ibecole.service.business.matGenerate;
import com.ibecole.ibecole.commun.qualifier.MatGeneration;
import com.ibecole.ibecole.model.request.PersonneRequest;
import org.springframework.stereotype.Component;


/**
 * Created by TOSHIBA on 12/12/2018.
 */
@MatGeneration(MatGeneration.typeMat.PARENT)
@Component
public class ParentMat implements MatriculeGenerate {


    public String Generate(PersonneRequest personneRequest) {
        return "PAR-"+Math.random();
    }
}
