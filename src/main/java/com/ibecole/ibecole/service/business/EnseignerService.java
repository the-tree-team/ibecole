package com.ibecole.ibecole.service.business;

import com.ibecole.ibecole.entity.business.Enseigner;
import com.ibecole.ibecole.repository.business.EnseignerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnseignerService {

    private final EnseignerRepository enseignerRepository;

    @Autowired
    public EnseignerService(EnseignerRepository enseignerRepository) {
        this.enseignerRepository= enseignerRepository;
    }


    public Enseigner save(Enseigner enseigner){
        return enseignerRepository.save(enseigner);
    }

    public boolean delete(Integer id){
        enseignerRepository.deleteById(id);
        return true;
    }

    public Enseigner findById(Integer id){
        /* "getOne()" is Lazy - "findOne" is Eager */
        return enseignerRepository.getOne(id);
    }

    public List<Enseigner> findAll(){
        return enseignerRepository.findAll();
    }

}
