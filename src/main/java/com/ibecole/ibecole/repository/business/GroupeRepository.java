package com.ibecole.ibecole.repository.business;

import com.ibecole.ibecole.entity.business.Eleve;
import com.ibecole.ibecole.entity.business.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupeRepository extends JpaRepository<Groupe, Integer> {
}
