package com.cg.mts.service;

public interface ILoginService {

	public boolean verifyUniversityStaffMemberCredentials(int staffId, String password);
	public boolean verifyApplicantCredentials(String applicantId, String mobileNumber);
	public boolean verifyAdmissionCommiteeMemberCredentials(int adminId, String adminContact);
//	public boolean loginAsApplicant(String username,String pwd);
//	public boolean loginAsAdmissionCommiteeMember(String username,String pwd);
//	public boolean loginAsUniversityStaffMember(String username,String pwd);
	
}
