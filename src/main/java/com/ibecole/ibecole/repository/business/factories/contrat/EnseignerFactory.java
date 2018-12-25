package com.ibecole.ibecole.repository.business.factories.contrat;


import com.ibecole.ibecole.entity.business.Enseigner;
import com.ibecole.ibecole.entity.business.Matiere;
import com.ibecole.ibecole.entity.business.Professeur;

import java.util.List;

public interface EnseignerFactory {

    public List<Enseigner> matiereProfesseurBuilder(List<Matiere> matiereList, Professeur professeur);
}
