package com.ibecole.ibecole.repository.business;

import com.ibecole.ibecole.entity.business.Groupe;
import com.ibecole.ibecole.entity.business.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeanceRepository extends JpaRepository<Seance, Integer> {
}
