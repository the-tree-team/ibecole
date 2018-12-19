package com.ibecole.ibecole.service.business;

import com.ibecole.ibecole.entity.business.Absence;
import com.ibecole.ibecole.entity.business.Eleve;
import com.ibecole.ibecole.entity.business.Seance;
import com.ibecole.ibecole.model.request.AbsenceRequest;
import com.ibecole.ibecole.repository.business.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbsenceService {

    private final AbsenceRepository absenceRepository;
    private final PersonneService personneService;
    private final SeanceService seanceService;
    private final ConversionService conversionService;
    /* On Utilise l'Injection des Dépendances "Constructor" au lieu de "Field" parceque "Field DI" a quelques problèmes */
    @Autowired
    public AbsenceService(AbsenceRepository absenceRepository, PersonneService personneService, SeanceService seanceService, ConversionService conversionService) {
        this.absenceRepository = absenceRepository;
        this.personneService = personneService;
        this.seanceService = seanceService;
        this.conversionService = conversionService;
    }

    public Absence save(AbsenceRequest absenceRequest){
        Absence absence = conversionService.convert(absenceRequest, Absence.class);
        if(absenceRequest.getIdEleve()!=null){
            Eleve eleve = (Eleve) personneService.findById(absenceRequest.getIdEleve(), "Eleve");
            System.out.println("ABSENCE ELEVE :"+ eleve.getId() + "  "+eleve.getNom());
            absence.setEleve(eleve);
        }
        if(absenceRequest.getIdSeance()!=null){
            Seance seance = seanceService.findById(absenceRequest.getIdSeance());
            absence.setSeance(seance);
        }
        return absenceRepository.save(absence);
    }

    public boolean delete(Integer id){
        absenceRepository.deleteById(id);
        return true;
    }

    public Absence findById(Integer id){
        /* "getOne()" is Lazy - "findOne" is Eager */
        return absenceRepository.findById(id).isPresent()? absenceRepository.findById(id).get() : null;
    }

    public List<Absence> findAll(){
        return absenceRepository.findAll();
    }
}
