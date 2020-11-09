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

import com.cg.mts.entities.Admission;
import com.cg.mts.exceptions.AdmissionNotGrantedException;
import com.cg.mts.service.AdmissionServiceImpl;

@RestController
public class AdmissionController {
	
	@Autowired
	public AdmissionServiceImpl admServ;
	
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
	@GetMapping("/cancellingadmission/{id}")
	public void cancellingAdmission(@PathVariable int admissionId) throws AdmissionNotGrantedException
	{
		admServ.cancelAdmission(admissionId);
//		return new ResponseEntity<Admission>(result.get(),HttpStatus.OK);
	}
	@GetMapping("/showalladmissiondetailsbycourseid/{id}")
	public Optional<Admission> showAllAdmissionsByCourseId(@PathVariable int id)
	{
		Optional<Admission> result=admServ.showAllAdmissionsByCourseId(id);
		return result;
	}
	@DeleteMapping("/showalladmissiondetailsbydate/{id}") //doubt!S
	public List<Admission> showAllAdmissionsByDate(@PathVariable Iterable<Integer> id)
	{
		return admServ.showAllAdmissionsByDate(id);
	}
}
