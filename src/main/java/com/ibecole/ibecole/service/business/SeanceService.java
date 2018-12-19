package com.ibecole.ibecole.service.business;

import com.ibecole.ibecole.entity.business.Seance;
import com.ibecole.ibecole.repository.business.SeanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeanceService {


    private final SeanceRepository seanceRepository;

    public SeanceService(SeanceRepository seanceRepository) {
        this.seanceRepository = seanceRepository;
    }

    public Seance save(Seance seance){
        return seanceRepository.save(seance);
    }

    public boolean delete(Integer id){
            seanceRepository.deleteById(id);
        return true;
    }

    public Seance findById(Integer id){
        return seanceRepository.findById(id).isPresent()? seanceRepository.findById(id).get() : null;
    }
    public List<Seance> findAll(){
        return seanceRepository.findAll();
    }

}