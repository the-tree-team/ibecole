package com.ibecole.ibecole.service.business;

import com.ibecole.ibecole.entity.business.Niveau;
import com.ibecole.ibecole.entity.business.Unitee;
import com.ibecole.ibecole.repository.business.NiveauRepository;
import com.ibecole.ibecole.repository.business.UniteeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniteeService {

    private final UniteeRepository uniteeRepository;

    @Autowired
    public UniteeService(UniteeRepository uniteeRepository) {
        this.uniteeRepository = uniteeRepository;
    }


    public Unitee save(Unitee unitee){
        return uniteeRepository.save(unitee);
    }

    public boolean delete(Integer id){
        uniteeRepository.deleteById(id);
        return true;
    }

    public Unitee findById(Integer id){
        /* "getOne()" is Lazy - "findOne" is Eager */
        return uniteeRepository.getOne(id);
    }

    public List<Unitee> findAll(){
        return uniteeRepository.findAll();
    }

}
