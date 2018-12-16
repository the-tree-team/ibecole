package com.ibecole.ibecole.repository.business;

import com.ibecole.ibecole.entity.business.Formation;
import com.ibecole.ibecole.entity.business.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormationRepository extends JpaRepository<Formation, Integer>{
}
