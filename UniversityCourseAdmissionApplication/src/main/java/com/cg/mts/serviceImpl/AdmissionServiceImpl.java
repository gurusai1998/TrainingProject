package com.cg.mts.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import com.cg.mts.entities.Admission;
import com.cg.mts.exception.AdmissionNotGrantedException;
import com.cg.mts.repository.IAdmissionRepository;
import com.cg.mts.repositoryImpl.AdmissionRepositoryImpl;
import com.cg.mts.service.IAdmissionService;

    public class AdmissionServiceImpl implements IAdmissionService {
	AdmissionRepositoryImpl admRep = new AdmissionRepositoryImpl();

	public Admission addAdmission(Admission admission) throws AdmissionNotGrantedException {
		Admission adm=admRep.addAdmission(admission);
		return adm;
	}

	public Admission updateAdmission(Admission admission) throws AdmissionNotGrantedException {
		
		return admRep.updateAdmission(admission);
	}

	public Admission cancelAdmission(int admissionId) throws AdmissionNotGrantedException {
		
		return admRep.cancelAdmission(admissionId);
	}

	public List<Admission> showAllAdmissionsByCourseId(int courseId) {
		// TODO Auto-generated method stub
		return admRep.showAllAdmissionsByCourseId(courseId);
	}

	public List<Admission> showAllAdmissionsByDate(LocalDate admissionDate) {
		// TODO Auto-generated method stub
		return admRep.showAllAdmissionsByDate(admissionDate);
	}

}
