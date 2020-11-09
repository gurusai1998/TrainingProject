package com.cg.mts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Applicant;
import com.cg.mts.exceptions.ApplicantNotFoundException;
import com.cg.mts.repository.IApplicantRepository;
@Service
public class ApplicantServiceImpl{
	@Autowired
	IApplicantRepository arRep;

	public Applicant addApplicant(Applicant applicant) {
		// TODO Auto-generated method stub
		return arRep.save(applicant);
	}

	public Applicant updateApplicant(Applicant applicant) throws ApplicantNotFoundException {
		// TODO Auto-generated method stub
		return arRep.save(applicant);
	}

	public void deleteApplicant(Applicant applicant) throws ApplicantNotFoundException {
		int id = applicant.getApplicantId();
		arRep.deleteById(id);
	}

	public Optional<Applicant> viewApplicant(int applicantId) throws ApplicantNotFoundException {
		return arRep.findById(applicantId);
	}

	public List<Applicant> viewAllApplicantsByCourse(Iterable<Integer> courseId) { //doubt!
		// TODO Auto-generated method stub
		return arRep.findAllById(courseId);
	}

//	public List<Applicant> viewAllApplicantsByStatus(AdmissionStatus status) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
