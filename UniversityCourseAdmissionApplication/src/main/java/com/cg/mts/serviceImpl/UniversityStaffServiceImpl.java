package com.cg.mts.serviceImpl;

import java.util.List;

import com.cg.mts.entities.Course;
import com.cg.mts.entities.UniversityStaffMember;
import com.cg.mts.exception.CourseNotFoundException;
import com.cg.mts.repository.IUniversityStaffRepository;
import com.cg.mts.repositoryImpl.UniversityStaffRepositoryImpl;
import com.cg.mts.service.IUniversityStaffService;

public class UniversityStaffServiceImpl implements IUniversityStaffService{
	
	UniversityStaffRepositoryImpl usrRep= new UniversityStaffRepositoryImpl();
	

	public UniversityStaffMember addStaff(UniversityStaffMember user) {
		// TODO Auto-generated method stub
		return usrRep.addStaff(user);
	}

	public UniversityStaffMember updateStaff(UniversityStaffMember user) {
		// TODO Auto-generated method stub
		return usrRep.updateStaff(user);
	}

	public UniversityStaffMember viewStaff(int staffid) {
		// TODO Auto-generated method stub
		return usrRep.viewStaff(staffid);
	}

	public void removeStaff(int staffid) {
		// TODO Auto-generated method stub
		usrRep.removeStaff(staffid);
	}

	public List<UniversityStaffMember> viewAllStaffs() {
		// TODO Auto-generated method stub
		return usrRep.viewAllStaffs();
	}

	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		return usrRep.addCourse(course);
	}

	public Course removeCourse(int courseId) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		return usrRep.removeCourse(courseId);
	}

	public Course updateCourse(Course course) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		return usrRep.updateCourse(course);
	}

}
