package com.ibecole.ibecole.repository.business.factories.impl;

import com.ibecole.ibecole.entity.business.Enseigner;
import com.ibecole.ibecole.entity.business.Matiere;
import com.ibecole.ibecole.entity.business.Professeur;
import com.ibecole.ibecole.repository.business.factories.contrat.EnseignerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class EnseignerFactoryImpl implements EnseignerFactory {

    @Override
    public List<Enseigner> matiereProfesseurBuilder(List<Matiere> matiereList, Professeur professeur) {
        return matiereList.stream().map(item -> new Enseigner(item, professeur)).collect(Collectors.toList());
    }
}
