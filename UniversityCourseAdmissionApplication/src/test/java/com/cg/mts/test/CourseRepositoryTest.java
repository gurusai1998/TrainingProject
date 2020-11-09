package com.cg.mts.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.cg.mts.entities.Course;
import com.cg.mts.exception.CourseNotFoundException;
import com.cg.mts.main.MainClassTest;
import com.cg.mts.repositoryImpl.CourseRepositoryImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseRepositoryTest {
	
	MainClassTest mct;
	CourseRepositoryImpl cr;
	Course course;
	
	@Before
	public void Init() {
		 cr = new CourseRepositoryImpl();
		 course= new Course();
		 mct= new MainClassTest();
	}
	
	@Test
	public void addCourse() {
		course= mct.getCourseAddDetails();
		assertNotNull(cr.addCourse(course));
	}
	@Test
	public void updateCourse() {
		course=mct.getCourseUpdateDetails();
		try {
			assertNotNull(cr.updateCourse(course));
		} catch (CourseNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void viewCourse() {
		
		try {
			assertNotNull(cr.viewCourse(3));
		} catch (CourseNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	@Test
	public void removeCourse() {
		course=mct.getCourseRemoveDetails();
		
		try {
			assertNotNull(cr.removeCourse(1)); 
		} catch (CourseNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void viewCourseList() {
		
		assertNotNull(cr.viewCourseList());
	
	}
}
