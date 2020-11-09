package com.cg.mts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Login;
import com.cg.mts.repository.ILoginRepository;
@Service
public class LoginServiceImpl{ //doubt!
	@Autowired
	ILoginRepository lrRep;

	public boolean verifyUniversityStaffMemberCredentials(int staffId, String password) {
		return lrRep.existsById(staffId);
	}

	public boolean verifyApplicantCredentials(int applicantId, String mobileNumber) {
		return lrRep.existsById(applicantId);
	}

	public boolean verifyAdmissionCommiteeMemberCredentials(int adminId, String adminContact) {
		return lrRep.existsById(adminId);
	}

	public Login logout(Login login) {
		return login;
	}
}
