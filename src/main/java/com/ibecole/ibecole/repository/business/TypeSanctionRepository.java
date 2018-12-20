package com.ibecole.ibecole.repository.business;

import com.ibecole.ibecole.entity.business.TypeSanction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeSanctionRepository extends JpaRepository<TypeSanction, Integer> {

    Page<TypeSanction> findAll(Pageable pageable);
}
