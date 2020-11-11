package com.cg.mts.serviceImpl;

import java.util.List;

import com.cg.mts.entities.AdmissionStatus;
import com.cg.mts.entities.Applicant;
import com.cg.mts.entities.Course;
import com.cg.mts.exception.ApplicantNotFoundException;
import com.cg.mts.repository.IApplicantRepository;
import com.cg.mts.repositoryImpl.ApplicantRepositoryImpl;
import com.cg.mts.service.IApplicantService;

public class ApplicantServiceImpl implements IApplicantService {
	
	ApplicantRepositoryImpl arRep = new ApplicantRepositoryImpl();

	public Applicant addApplicant(Applicant applicant) {
		// TODO Auto-generated method stub
		return arRep.addApplicant(applicant);
	}

	public Applicant updateApplicant(Applicant applicant) throws ApplicantNotFoundException {
		// TODO Auto-generated method stub
		return arRep.updateApplicant(applicant);
	}

	public Applicant deleteApplicant(Applicant applicant) throws ApplicantNotFoundException {
		// TODO Auto-generated method stub
		return arRep.deleteApplicant(applicant);
	}

	public Applicant viewApplicant(int applicant) throws ApplicantNotFoundException {
		// TODO Auto-generated method stub
		return arRep.viewApplicant(applicant);
	}

	public List<Applicant> viewAllApplicantsByCourse(int courseId) {
		// TODO Auto-generated method stub
		return arRep.viewAllApplicantsByCourse(courseId);
	}

	public List<Applicant> viewAllApplicantsByStatus(AdmissionStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

}
