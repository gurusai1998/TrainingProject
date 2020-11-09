package com.cg.mts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mts.entities.Applicant;

public interface IApplicantRepository extends JpaRepository<Applicant, Integer>{

}
