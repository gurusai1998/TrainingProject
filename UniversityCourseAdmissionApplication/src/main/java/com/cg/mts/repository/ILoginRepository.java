package com.cg.mts.repository;

public interface ILoginRepository {
	
	//public boolean verifyApplicantCredentials(String username,String pwd);
	//public boolean verifyAdmissionCommiteeMemberCredentials(String username,String pwd);
	//public boolean verifyUniversityStaffMemberCredentials(String username,String pwd);
	public boolean verifyUniversityStaffMemberCredentials(int staffId, String password);
	public boolean verifyApplicantCredentials(String applicantId, String mobileNumber);
	public boolean verifyAdmissionCommiteeMemberCredentials(int adminId, String adminContact);
}
