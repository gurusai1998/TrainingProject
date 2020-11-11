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
import com.cg.mts.exceptions.CourseNotFoundException;
import com.cg.mts.service.CourseService;

@RestController
public class CourseController {
	@Autowired
	public CourseService couSer;

	@PostMapping("/addingcoursedetails")
	public ResponseEntity<Course> addingCourseDetails(@RequestBody Course course) throws CourseNotFoundException
	{
		Course result=couSer.addCourse(course);
		return new ResponseEntity<Course>(result,HttpStatus.OK);
	}
	@PutMapping("/updatingcoursedetails")
	public ResponseEntity<Course> updatingCourseDetails(@RequestBody Course course) throws CourseNotFoundException 
	{
		Course result=couSer.updateCourse(course);
		return new ResponseEntity<Course>(result,HttpStatus.OK);
	}
	@DeleteMapping("/cancellingcourse/{id}")
	public void cancellingCourse(@PathVariable int courseId) throws CourseNotFoundException
	{
		couSer.removeCourse(courseId);
		//return new ResponseEntity<Course>(result.get(),HttpStatus.OK);
	}
	@GetMapping("/showalladmissiondetailsbycourseid/{id}")
	public Course showAllCourseByCourseId(@PathVariable int id) throws CourseNotFoundException
	{
		Course result=couSer.viewCourse(id);
		return result;
	}
	@GetMapping("/showallcoursetailsbydate/{id}") //doubt!S
	public List<Course> showAllCourses()
	{
		return couSer.viewAllCourses();
	}
}