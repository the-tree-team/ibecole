package com.ibecole.ibecole.service.business;

import com.ibecole.ibecole.entity.business.AnneeScolaire;
import com.ibecole.ibecole.entity.business.Unitee;
import com.ibecole.ibecole.repository.business.AnneeScolaireRepository;
import com.ibecole.ibecole.repository.business.UniteeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnneeScolaireService {

    private final AnneeScolaireRepository anneeScolaireRepository;

    @Autowired
    public AnneeScolaireService(AnneeScolaireRepository anneeScolaireRepository) {
        this.anneeScolaireRepository = anneeScolaireRepository;
    }


    public AnneeScolaire save(AnneeScolaire anneeScolaire){
        return anneeScolaireRepository.save(anneeScolaire);
    }

    public boolean delete(Integer id){
        anneeScolaireRepository.deleteById(id);
        return true;
    }

    public AnneeScolaire findById(Integer id){
        /* "getOne()" is Lazy - "findOne" is Eager */
        return anneeScolaireRepository.getOne(id);
    }

    public List<AnneeScolaire> findAll(){
        return anneeScolaireRepository.findAll();
    }

}
