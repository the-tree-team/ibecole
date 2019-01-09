package com.ibecole.ibecole.service.business;

import com.ibecole.ibecole.entity.business.Niveau;
import com.ibecole.ibecole.entity.business.Sanction;
import com.ibecole.ibecole.repository.business.NiveauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NiveauService {

    private final NiveauRepository niveauRepository;

    @Autowired
    public NiveauService(NiveauRepository niveauRepository) {
        this.niveauRepository = niveauRepository;
    }


    public Niveau save(Niveau niveau){
        return niveauRepository.save(niveau);
    }

    public boolean delete(Integer id){
        niveauRepository.deleteById(id);
        return true;
    }

    public Niveau findById(Integer id){
        /* "getOne()" is Lazy - "findOne" is Eager */
        return niveauRepository.getOne(id);
    }

    public List<Niveau> findAll(){
        return niveauRepository.findAll();
    }
    public Page<Niveau> pageableFindAll(Pageable pageable){
        return niveauRepository.findAll(pageable);
    }
}
