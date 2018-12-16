package com.ibecole.ibecole.convertor;


import com.ibecole.ibecole.commun.enumerate.Sexe;
import com.ibecole.ibecole.entity.business.Eleve;
import com.ibecole.ibecole.entity.business.Groupe;
import com.ibecole.ibecole.model.request.GroupeRequest;
import com.ibecole.ibecole.model.request.PersonneRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

public class GroupeRequestToGroupeConverter implements Converter<GroupeRequest, Groupe> {




    @Nullable
    @Override
    public Groupe convert(GroupeRequest groupeRequest) {
        System.out.println("=========================================");
        Groupe groupe = new Groupe();
        groupe.setCode(groupeRequest.getCode());
        groupe.setNiveau(groupeRequest.getNiveau());
        groupe.setFormation(groupeRequest.getFormation());
        groupe.setPeriodeList(groupeRequest.getPeriodeList());
        groupe.setNombeMaxEleve(groupeRequest.getNombeMaxEleve());
        groupe.setPeriodeActuelle(groupeRequest.getPeriodeActuelle());
        groupe.setEleveAppartenanceGroupeList(groupeRequest.getEleveAppartenanceGroupeList());



        if(null != groupeRequest.getId())
            groupe.setId(groupeRequest.getId());

        return groupe;
    }
}
