package com.cg.mts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Admission;
import com.cg.mts.exceptions.AdmissionNotGrantedException;
import com.cg.mts.repository.IAdmissionRepository;
@Service
    public class AdmissionServiceImpl {
	@Autowired
	IAdmissionRepository admRep;

	public Admission addAdmission(Admission admission) throws AdmissionNotGrantedException {
		Admission adm=admRep.save(admission);
		return adm;
	}

	public Admission updateAdmission(Admission admission) throws AdmissionNotGrantedException {
		
		return admRep.save(admission);
	}

	public void cancelAdmission(int admissionId) throws AdmissionNotGrantedException {
		
		admRep.deleteById(admissionId);
	}

	public Optional<Admission> showAllAdmissionsByCourseId(int courseId) {
		// TODO Auto-generated method stub
		return admRep.findById(courseId);
	}

	public List<Admission> showAllAdmissionsByDate(Iterable<Integer> admissionDate) { // Doubt!
		return admRep.findAllById(admissionDate);
	}

}
