package com.cg.mts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mts.entities.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer>{
	public Applicant viewApplicant(int applicantId);
	
	public Applicant viewAllApplicantsByCourse(Iterable<Integer> courseId);

}