package com.cg.mts.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Admission;
import com.cg.mts.exceptions.AdmissionNotGrantedException;
import com.cg.mts.repository.AdmissionRepository;
@Service
    public class AdmissionService {
	@Autowired
	AdmissionRepository admRep;

	public Admission addAdmission(Admission admission) throws AdmissionNotGrantedException {
		return admRep.save(admission);
		
	}

	public Admission updateAdmission(Admission admission) throws AdmissionNotGrantedException {
		
		return admRep.save(admission);
	}

	public void cancelAdmission(int admissionId) throws AdmissionNotGrantedException {
		
		admRep.deleteById(admissionId);
	}

	public Admission showAllAdmissionsByCourseId(int courseId) {
		// TODO Auto-generated method stub
		return admRep.findById(courseId);
	}

	public Admission showAllAdmissionsByDate(LocalDate admissionDate) { // Doubt!
		return admRep.findAllByDate(admissionDate);
	}

}
