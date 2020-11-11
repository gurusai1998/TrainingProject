package com.cg.mts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.entities.Login;
import com.cg.mts.service.LoginService;

@RestController
public class LoginController {
	@Autowired
	public LoginService lsi; 
	
	@PostMapping("/verifystaffdetails")
	public ResponseEntity<Login> verifyUniversityStaffMemberCredentials(int staffId, String password)
	{
		lsi.verifyUniversityStaffMemberCredentials(staffId, password);
		return new ResponseEntity<Login>(HttpStatus.OK);
	}
	
	@PostMapping("/verifyapplicantdetails")
	public ResponseEntity<Login> verifyApplicantCredentials(int applicantId, String mobileNumber)
	{
		lsi.verifyUniversityStaffMemberCredentials(applicantId, mobileNumber);
		return new ResponseEntity<Login>(HttpStatus.OK);
	}
	
	@PostMapping("/verifyadmissioncommiteememberdetails")
	public ResponseEntity<Login> verifyAdmissionCommiteeMemberCredentials(int adminId, String adminContact)
	{
		lsi.verifyUniversityStaffMemberCredentials(adminId, adminContact);
		return new ResponseEntity<Login>(HttpStatus.OK);
	}
}
	
