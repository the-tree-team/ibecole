package com.ibecole.ibecole.service.business;

import com.ibecole.ibecole.entity.business.Justificatif;
import com.ibecole.ibecole.repository.business.JustificatifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JustificatifService {

    private final JustificatifRepository justificatifRepository;

    @Autowired
    public JustificatifService(JustificatifRepository justificatifRepository) {
        this.justificatifRepository = justificatifRepository;
    }

    public Justificatif save(Justificatif justificatif){
        return justificatifRepository.save(justificatif);
    }

    public boolean delete(Integer id){
        justificatifRepository.deleteById(id);
        return true;
    }

    public Justificatif findById(Integer id){
        /* "getOne()" is Lazy - "findOne" is Eager */
        return justificatifRepository.getOne(id);
    }

    public List<Justificatif> findAll(){
        return justificatifRepository.findAll();
    }

}
