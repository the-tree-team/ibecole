package com.ibecole.ibecole.service.business;

import com.ibecole.ibecole.entity.business.Contient;
import com.ibecole.ibecole.entity.business.Formation;
import com.ibecole.ibecole.repository.business.ContientRepository;
import com.ibecole.ibecole.repository.business.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContientService {

    private final ContientRepository contientRepository;

    @Autowired
    public ContientService(ContientRepository contientRepository) {
        this.contientRepository= contientRepository;
    }


    public Contient save(Contient contient){
        return contientRepository.save(contient);
    }

    public boolean delete(Integer id){
        contientRepository.deleteById(id);
        return true;
    }

    public Contient findById(Integer id){
        /* "getOne()" is Lazy - "findOne" is Eager */
        return contientRepository.getOne(id);
    }

    public List<Contient> findAll(){
        return contientRepository.findAll();
    }

}
