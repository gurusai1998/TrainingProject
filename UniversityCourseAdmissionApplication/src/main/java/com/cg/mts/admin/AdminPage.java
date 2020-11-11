package com.cg.mts.admin;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.mts.entities.AdmissionCommiteeMember;
import com.cg.mts.entities.Applicant;
import com.cg.mts.entities.UniversityStaffMember;
import com.cg.mts.service.ILoginService;
import com.cg.mts.serviceImpl.LoginServiceImpl;

public class AdminPage {

	  EntityManagerFactory emf=Persistence.createEntityManagerFactory("pu");
	  EntityManager em=emf.createEntityManager();
	  EntityTransaction tx=em.getTransaction();
	  ILoginService lmp= new LoginServiceImpl();
	public UniversityStaffMember check(UniversityStaffMember usm){
		if(em.find(UniversityStaffMember.class, usm.getStaffId())!=null)
		{
			lmp.verifyUniversityStaffMemberCredentials(usm.getStaffId(),usm.getPassword());
			
		}
		return usm;
	}
	public Applicant check(Applicant ap) {
		
		if(em.find(Applicant.class, ap.getApplicantId())!=null)
		{
			lmp.verifyApplicantCredentials(ap.getApplicantId(),ap.getMobileNumber());
		}
		return ap;
		
	}
	
	public AdmissionCommiteeMember check(AdmissionCommiteeMember acm) {
		
		if(em.find(AdmissionCommiteeMember.class, acm.getAdminId())!=null) {
			
			lmp.verifyAdmissionCommiteeMemberCredentials(acm.getAdminId(),acm.getAdminContact());
		}
		return acm;
	}
	
}

