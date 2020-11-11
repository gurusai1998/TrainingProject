package com.cg.mts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Applicant;
import com.cg.mts.exceptions.ApplicantNotFoundException;
import com.cg.mts.repository.ApplicantRepository;
@Service
public class ApplicantService{
	@Autowired
	ApplicantRepository arRep;

	public Applicant addApplicant(Applicant applicant) {
		// TODO Auto-generated method stub
		return arRep.save(applicant);
	}

	public Applicant updateApplicant(Applicant applicant) throws ApplicantNotFoundException {
		// TODO Auto-generated method stub
		return arRep.save(applicant);
	}

	public void deleteApplicant(int applicantId) throws ApplicantNotFoundException {
	
		arRep.deleteById(applicantId);
	}

	public Applicant viewApplicant(int applicantId) throws ApplicantNotFoundException {
		return arRep.viewApplicant(applicantId);
	}

	public Applicant viewAllApplicantsByCourse(Iterable<Integer> courseId) { //doubt!
		// TODO Auto-generated method stub
		return arRep.viewAllApplicantsByCourse(courseId);
	}

//	public List<Applicant> viewAllApplicantsByStatus(AdmissionStatus status) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
