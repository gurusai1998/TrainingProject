package com.cg.mts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Course;
import com.cg.mts.exceptions.CourseNotFoundException;
import com.cg.mts.repository.CourseRepository;
@Service
public class CourseService{
	@Autowired
	CourseRepository crRep;

	public Course addCourse(Course course) {
		return crRep.save(course);
	}

	public void removeCourse(int courseId) throws CourseNotFoundException {
		crRep.deleteById(courseId);
	}

	public Course updateCourse(Course course) throws CourseNotFoundException {
		return crRep.save(course);
	}

	public Course viewCourse(int courseid) throws CourseNotFoundException {//doubt!
		return crRep.findById(courseid).orElse(null);
	}

	public List<Course> viewAllCourses() {
		// TODO Auto-generated method stub
		return crRep.findAll();
	}

}
