package com.cg.mts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mts.entities.UniversityStaffMember;

public interface IUniversityStaffRepository extends JpaRepository<UniversityStaffMember, Integer>{

}