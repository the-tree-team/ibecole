package com.ibecole.ibecole.service.business;

import com.ibecole.ibecole.entity.business.Absence;
import com.ibecole.ibecole.repository.business.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbsenceService {

    private final AbsenceRepository absenceRepository;

    /* On Utilise l'Injection des Dépendances "Constructor" au lieu de "Field" parceque "Field DI" a quelques problèmes */
    @Autowired
    public AbsenceService(AbsenceRepository absenceRepository) {
        this.absenceRepository = absenceRepository;
    }

    public Absence save(Absence absence){
        return absenceRepository.save(absence);
    }

    public boolean delete(Integer id){
        absenceRepository.deleteById(id);
        return true;
    }

    public Absence findById(Integer id){
        /* "getOne()" is Lazy - "findOne" is Eager */
        return absenceRepository.getOne(id);
    }

    public List<Absence> findAll(){
        return absenceRepository.findAll();
    }
}
