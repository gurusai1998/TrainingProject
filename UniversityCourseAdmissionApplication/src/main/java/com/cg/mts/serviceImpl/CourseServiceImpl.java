package com.cg.mts.serviceImpl;

import java.util.List;

import com.cg.mts.entities.Course;
import com.cg.mts.exception.CourseNotFoundException;
import com.cg.mts.repositoryImpl.CourseRepositoryImpl;
import com.cg.mts.service.ICourseService;

public class CourseServiceImpl implements ICourseService {
	
	CourseRepositoryImpl crRep= new CourseRepositoryImpl();

	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		return crRep.addCourse(course);
	}

	public Course removeCourse(int courseId) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		return crRep.removeCourse(courseId);
	}

	public Course updateCourse(Course course) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		return crRep.updateCourse(course);
	}

	public Course viewCourse(int courseid) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		return crRep.viewCourse(courseid);
	}

	public List<Course> viewAllCourses() {
		// TODO Auto-generated method stub
		return crRep.viewCourseList();
	}

}
