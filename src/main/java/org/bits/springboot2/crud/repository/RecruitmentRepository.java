package org.bits.springboot2.crud.repository;

import org.bits.springboot2.crud.model.Recruitment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruitmentRepository extends JpaRepository<Recruitment, Long>{

}
