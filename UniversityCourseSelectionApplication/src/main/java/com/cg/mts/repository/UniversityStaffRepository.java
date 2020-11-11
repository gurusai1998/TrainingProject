package com.cg.mts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mts.entities.UniversityStaffMember;

public interface UniversityStaffRepository extends JpaRepository<UniversityStaffMember, Integer>{
	
	public UniversityStaffMember viewstaff(int Id);

}