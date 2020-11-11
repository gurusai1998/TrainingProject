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

import com.cg.mts.entities.Course;
import com.cg.mts.entities.UniversityStaffMember;
import com.cg.mts.exceptions.CourseNotFoundException;
import com.cg.mts.service.UniversityStaffService;


@RestController
public class UniversityStaffMemberController {

	@Autowired
	public UniversityStaffService ussi;

	@PostMapping("/addingstaffdetails")
	public ResponseEntity<UniversityStaffMember> addStaff(@RequestBody UniversityStaffMember user) 
	{
		UniversityStaffMember result=ussi.addStaff(user);
		return new ResponseEntity<UniversityStaffMember>(result,HttpStatus.OK);
	}

	@PutMapping("/updatingstaffdetails")
	public ResponseEntity<UniversityStaffMember> updateStaff(@RequestBody UniversityStaffMember user) 
	{
		UniversityStaffMember result=ussi.updateStaff(user);
		return new ResponseEntity<UniversityStaffMember>(result,HttpStatus.OK);
	}

	@GetMapping("/showallstaffdetailsbycourseid/{id}")
	public UniversityStaffMember viewStaff(@PathVariable int id)
	{
		UniversityStaffMember result=ussi.viewStaff(id);
		return result;
	}

	@DeleteMapping("/removestaffdetails")
	public void removeStaff(@RequestBody int staffid) 
	{		
		ussi.removeStaff(staffid);
	}

	@GetMapping("")
	public List<UniversityStaffMember> findAll() {
		return ussi.viewAllStaffs();
	}

	@PostMapping("/addingcoursedetails")
	public ResponseEntity<Course> addCourse(@RequestBody Course course) 
	{
		Course result=ussi.addCourse(course);
		return new ResponseEntity<Course>(result,HttpStatus.OK);
	}

	@DeleteMapping("/removecoursedetails")
	public void removeCourse(@RequestBody int course) throws CourseNotFoundException 
	{		
		ussi.removeCourse(course);
	}

	@PostMapping("/updatingcoursedetails")
	public ResponseEntity<Course> updateCourse(@RequestBody Course course) throws CourseNotFoundException 
	{
		Course result=ussi.updateCourse(course);
		return new ResponseEntity<Course>(result,HttpStatus.OK);
	}		

}