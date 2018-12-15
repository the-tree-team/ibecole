package com.ibecole.ibecole.service.business;

import com.ibecole.ibecole.entity.business.Examen;
import com.ibecole.ibecole.repository.business.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamenService {

    private final ExamenRepository examenRepository;

    @Autowired
    public ExamenService(ExamenRepository examenRepository) {
        this.examenRepository = examenRepository;
    }


    public Examen save(Examen examen){
        return examenRepository.save(examen);
    }

    public boolean delete(Integer id){
        examenRepository.deleteById(id);
        return true;
    }

    public Examen findById(Integer id){
        /* "getOne()" is Lazy - "findOne" is Eager */
        return examenRepository.getOne(id);
    }

    public List<Examen> findAll(){
        return examenRepository.findAll();
    }

}
