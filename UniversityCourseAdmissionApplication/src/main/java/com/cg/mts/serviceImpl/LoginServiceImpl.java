package com.cg.mts.serviceImpl;

import com.cg.mts.repository.ILoginRepository;
import com.cg.mts.repositoryImpl.LoginRepositoryImpl;
import com.cg.mts.service.ILoginService;

public class LoginServiceImpl implements ILoginService {
	
	ILoginRepository lrRep= new LoginRepositoryImpl();

	public boolean verifyUniversityStaffMemberCredentials(int staffId, String password) {
		// TODO Auto-generated method stub
		return lrRep.verifyUniversityStaffMemberCredentials(staffId, password);


	}

	public boolean verifyApplicantCredentials(String applicantId, String mobileNumber) {
		return lrRep.verifyApplicantCredentials(applicantId, mobileNumber);
	}

	public boolean verifyAdmissionCommiteeMemberCredentials(int adminId, String adminContact) {
		return lrRep.verifyAdmissionCommiteeMemberCredentials(adminId, adminContact);
	}

//	public boolean loginAsApplicant(String username, String pwd) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	public boolean loginAsAdmissionCommiteeMember(String username, String pwd) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	public boolean loginAsUniversityStaffMember(String username, String pwd) {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
