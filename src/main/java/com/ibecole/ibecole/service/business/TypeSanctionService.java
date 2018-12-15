package com.ibecole.ibecole.service.business;

import com.ibecole.ibecole.entity.business.TypeSanction;
import com.ibecole.ibecole.repository.business.TypeSanctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeSanctionService {

    private final TypeSanctionRepository typeSanctionRepository;

    @Autowired
    public TypeSanctionService(TypeSanctionRepository typeSanctionRepository) {
        this.typeSanctionRepository = typeSanctionRepository;
    }


    public TypeSanction save(TypeSanction typeSanction){
        return typeSanctionRepository.save(typeSanction);
    }

    public boolean delete(Integer id){
        typeSanctionRepository.deleteById(id);
        return true;
    }

    public TypeSanction findById(Integer id){
        /* "getOne()" is Lazy - "findOne" is Eager */
        return typeSanctionRepository.getOne(id);
    }

    public List<TypeSanction> findAll(){
        return typeSanctionRepository.findAll();
    }
}
