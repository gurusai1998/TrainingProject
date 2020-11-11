package com.cg.mts.controller;

import java.time.LocalDate;
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

import com.cg.mts.entities.Admission;
import com.cg.mts.exceptions.AdmissionNotGrantedException;
import com.cg.mts.service.AdmissionService;

@RestController
public class AdmissionController {

	@Autowired
	public AdmissionService admServ;

	@PostMapping("/addingadmissiondetails")
	public ResponseEntity<Admission> addingAdmissionDetails(@RequestBody Admission admission) throws AdmissionNotGrantedException
	{
		Admission result=admServ.addAdmission(admission);
		return new ResponseEntity<Admission>(result,HttpStatus.OK);
	}
	@PutMapping("/updatingadmissiondetails")
	public ResponseEntity<Admission> updatingAdmissionDetails(@RequestBody Admission admission) throws AdmissionNotGrantedException
	{
		Admission result=admServ.updateAdmission(admission);
		return new ResponseEntity<Admission>(result,HttpStatus.OK);
	}
	@DeleteMapping("/cancellingadmission/{id}")
	public void cancellingAdmission(@PathVariable int admissionId) throws AdmissionNotGrantedException
	{
		admServ.cancelAdmission(admissionId);
		//return new ResponseEntity<Admission>(result.get(),HttpStatus.OK);
	}
	@GetMapping("/showalladmissiondetailsbycourseid/{id}")
	public Admission showAllAdmissionsByCourseId(@PathVariable int id)
	{
		Admission result=admServ.showAllAdmissionsByCourseId(id);
		return result;
	}
	@GetMapping("/showalladmissiondetailsbydate/{date}") //doubt!
	public Admission showAllAdmissionsByDate(@PathVariable LocalDate date)
	{
		return admServ.showAllAdmissionsByDate(date);
	}
}
