package com.ibecole.ibecole.service.business;

import com.ibecole.ibecole.entity.business.Formation;
import com.ibecole.ibecole.entity.business.Matiere;
import com.ibecole.ibecole.repository.business.FormationRepository;
import com.ibecole.ibecole.repository.business.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatiereService {

    private final MatiereRepository matiereRepository;

    @Autowired
    public MatiereService(MatiereRepository matiereRepository) {
        this.matiereRepository= matiereRepository;
    }


    public Matiere save(Matiere matiere){
        return matiereRepository.save(matiere);
    }

    public boolean delete(Integer id){
        matiereRepository.deleteById(id);
        return true;
    }

    public Matiere findById(Integer id){
        /* "getOne()" is Lazy - "findOne" is Eager */
        return matiereRepository.getOne(id);
    }

    public List<Matiere> findAll(){
        return matiereRepository.findAll();
    }
    public Page<Matiere> findAll(Pageable pageable){return matiereRepository.findAll(pageable);}

}
