package com.ibecole.ibecole.service.business;

import com.ibecole.ibecole.entity.business.Sanction;
import com.ibecole.ibecole.repository.business.SanctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SanctionService {

    private final SanctionRepository sanctionRepository;

    @Autowired
    public SanctionService(SanctionRepository sanctionRepository) {
        this.sanctionRepository = sanctionRepository;
    }


    public Sanction save(Sanction sanction){
        return sanctionRepository.save(sanction);
    }

    public boolean delete(Integer id){
        sanctionRepository.deleteById(id);
        return true;
    }

    public Sanction findById(Integer id){
        /* "getOne()" is Lazy - "findOne" is Eager */
        Optional<Sanction> sanctionOptional = sanctionRepository.findById(id);
        return sanctionOptional.isPresent() ? sanctionOptional.get(): null;
    }

    public List<Sanction> findAll(){
        return sanctionRepository.findAll();
    }
    public Page<Sanction> pageableFindAll(Pageable pageable){
        return sanctionRepository.findAll(pageable);
    }

}
