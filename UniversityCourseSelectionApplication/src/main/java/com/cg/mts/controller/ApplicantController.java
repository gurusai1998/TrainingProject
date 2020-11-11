package com.cg.mts.controller;

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

import com.cg.mts.entities.Applicant;
import com.cg.mts.exceptions.ApplicantNotFoundException;
import com.cg.mts.service.ApplicantService;

@RestController
public class ApplicantController {

	@Autowired
	public ApplicantService aps;

	@PostMapping("/addingapplicant")
	public ResponseEntity<Applicant> addingApplicant(@RequestBody Applicant applicant) 
	{
		Applicant res=aps.addApplicant(applicant);
		return new ResponseEntity<Applicant>(res,HttpStatus.OK);
	}
	@PutMapping("/updatingapplicant")
	public ResponseEntity<Applicant> updatingApplicant(@RequestBody Applicant applicant) throws ApplicantNotFoundException
	{
		Applicant res=aps.updateApplicant(applicant);
		return new ResponseEntity<Applicant>(res,HttpStatus.OK);
	}
	@DeleteMapping("/cancellingapplicant/{id}")
	public void cancellingApplicant(@PathVariable int applicantId) throws ApplicantNotFoundException
	{
		aps.deleteApplicant(applicantId);
	}
	@GetMapping("/viewapplicantiyapplicantid/{id}")
	public ResponseEntity<Applicant> viewApplicant(@PathVariable int applicantId) throws ApplicantNotFoundException
	{
		Applicant res=aps.viewApplicant(applicantId);
		return new ResponseEntity<Applicant>(HttpStatus.OK);
	}
	@GetMapping("/viewalladmissioncommiteememberdetails")
	public Applicant viewAllApplicantsByCourse(@PathVariable Iterable<Integer> courseId)
	{
		return aps.viewAllApplicantsByCourse(courseId);
	}
}