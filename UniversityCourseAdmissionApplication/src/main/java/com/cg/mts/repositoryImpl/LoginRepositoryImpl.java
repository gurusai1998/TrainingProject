package com.cg.mts.repositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.mts.entities.AdmissionCommiteeMember;
import com.cg.mts.entities.Applicant;
import com.cg.mts.entities.UniversityStaffMember;
import com.cg.mts.repository.ILoginRepository;

public class LoginRepositoryImpl implements ILoginRepository {
	
	private static EntityManagerFactory emf=Persistence.createEntityManagerFactory("pu");
	private static EntityManager em=emf.createEntityManager();
	
	UniversityStaffMember usm = new UniversityStaffMember();
	Applicant app= new Applicant();
	AdmissionCommiteeMember acm = new AdmissionCommiteeMember();
	public boolean verifyUniversityStaffMemberCredentials(int staffId, String password) {
		// TODO Auto-generated method stub
		UniversityStaffMember u=em.find(UniversityStaffMember.class, usm.getStaffId());
		
			if(usm.getStaffId()==staffId &&usm.getPassword().equals(password))
			return true;
		else
		{
			System.out.println("Invalid Details");
		}
			return false;
		
	}
	public boolean verifyApplicantCredentials(String applicantId, String mobileNumber) {
		// TODO Auto-generated method stub
		if(app.getApplicantId().equals(applicantId) &&app.getMobileNumber().equals(mobileNumber))
		{
			return true;
		}
	else
	{
		System.out.println("Invalid Details");
	}
		return false;
	}
	public boolean verifyAdmissionCommiteeMemberCredentials(int adminId, String adminContact) {
		// TODO Auto-generated method stub
		if(acm.getAdminId()==adminId &&acm.getAdminContact().equals(adminContact))
		{
			return false;
		}
	else
	{
		System.out.println("Invalid Details");
	}
		return false;
	}

	
//	public boolean verifyApplicantCredentials(String username, String pwd) {
//		// TODO Auto-generated method stub
//		
//		return false;
//	}
//
//	public boolean verifyAdmissionCommiteeMemberCredentials(String username, String pwd) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
////	public boolean verifyUniversityStaffMemberCredentials(String username, String pwd) {
////		// TODO Auto-generated method stub
////		return false;
////	}

}
