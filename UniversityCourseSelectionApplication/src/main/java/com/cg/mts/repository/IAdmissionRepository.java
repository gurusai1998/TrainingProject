package com.cg.mts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mts.entities.Admission;

public interface IAdmissionRepository extends JpaRepository<Admission, Integer>{

}
