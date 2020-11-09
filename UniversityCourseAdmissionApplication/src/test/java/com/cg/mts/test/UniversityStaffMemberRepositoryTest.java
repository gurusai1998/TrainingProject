package com.cg.mts.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.cg.mts.entities.Course;
import com.cg.mts.entities.UniversityStaffMember;
import com.cg.mts.exception.CourseNotFoundException;
import com.cg.mts.main.MainClassTest;
import com.cg.mts.repositoryImpl.CourseRepositoryImpl;
import com.cg.mts.repositoryImpl.UniversityStaffRepositoryImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UniversityStaffMemberRepositoryTest {
	
	MainClassTest mct;
	UniversityStaffRepositoryImpl usr;
	UniversityStaffMember usm;
	CourseRepositoryImpl cr;
	Course course;
	
	
	@Before
	public void Init() {
		 usr = new UniversityStaffRepositoryImpl();
		 cr = new CourseRepositoryImpl();
		 course= new Course();
		 usm= new UniversityStaffMember();
		 mct= new MainClassTest();
	}
	
	@Test
	public void addStaffMember() {
		usm = mct.getStaffAddDetails();
		assertNotNull(usr.addStaff(usm));
	}
	@Test
	public void updateStaffMember() {
		usm = mct.getStaffUpdateDetails();
		assertNotNull(usr.updateStaff(usm));
	}
	@Test
	public void viewStaff()
	{
		assertNotNull(usr.viewStaff(3232356));
	}
	@Test
	public void viewAllStaffs()
	{
		assertNotNull(usr.viewAllStaffs());
	}
	@Test
	public void addCourse() {
		course= mct.getCourseAddDetails();
		assertNotNull(cr.addCourse(course));
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
	public void updateCourse() {
		course=mct.getCourseUpdateDetails();
		try {
			assertNotNull(cr.updateCourse(course));
		} catch (CourseNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
