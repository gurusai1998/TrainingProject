package com.cg.mts.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.mts.entities.AdmissionCommiteeMember;
import com.cg.mts.service.AdmissionCommitteeMemberService;


@RestController
public class AdmissionCommiteeMemberController {


	@Autowired
	public AdmissionCommitteeMemberService acmServ;

	@PostMapping("/addingadmissioncommitteememberdetails")
	public ResponseEntity<AdmissionCommiteeMember> addingadmissionCommiteeMemberdetails(@RequestBody AdmissionCommiteeMember member) 
	{
		AdmissionCommiteeMember result=acmServ.addCommiteeMember(member);
		return new ResponseEntity<AdmissionCommiteeMember>(result,HttpStatus.OK);
	}
	@PutMapping("/updatingadmissioncommitteememberdetails")
	public ResponseEntity<AdmissionCommiteeMember> updatingadmissioncommitteememberDetails(@RequestBody AdmissionCommiteeMember member)
	{
		AdmissionCommiteeMember result=acmServ.updateCommiteeMember(member);
		return new ResponseEntity<AdmissionCommiteeMember>(result,HttpStatus.OK);
	}
	@DeleteMapping("/cancellingadmissioncommitteememberdetails/{id}")
	public void cancellingadmissioncommitteememberdetails(@PathVariable int adminId)
	{
		acmServ.removeCommiteeMember(adminId);
	}
	@GetMapping("/viewadmissioncommitteememberdetailsbyadminId/{id}")
	public ResponseEntity<AdmissionCommiteeMember> viewadmissioncommiteeMemberdetails(@PathVariable int adminId)
	{
		List<AdmissionCommiteeMember> result=acmServ.viewCommiteeMember(adminId);
		return new ResponseEntity<AdmissionCommiteeMember>(HttpStatus.OK);
	}
	@GetMapping("/viewalladmissioncommiteememberdetails")
	public List<AdmissionCommiteeMember> viewAllCommiteeMembers()
	{
		return acmServ.viewAllCommiteeMembers();
	}
}