package com.ibecole.ibecole.repository.business;

import com.ibecole.ibecole.entity.business.Enseigner;
import com.ibecole.ibecole.entity.business.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignerRepository extends JpaRepository<Enseigner, Integer>{
}
