package com.cg.mts.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Course;
import com.cg.mts.entities.UniversityStaffMember;
import com.cg.mts.exceptions.CourseNotFoundException;
import com.cg.mts.repository.CourseRepository;
import com.cg.mts.repository.UniversityStaffRepository;
@Service
public class UniversityStaffService{
	@Autowired
	UniversityStaffRepository usrRep;
	CourseRepository crRep;
	

	public UniversityStaffMember addStaff(UniversityStaffMember user) {
		// TODO Auto-generated method stub
		return usrRep.save(user);
	}

	public UniversityStaffMember updateStaff(UniversityStaffMember user) {
		// TODO Auto-generated method stub
		return usrRep.save(user);
	}

	public UniversityStaffMember viewStaff(int staffid) {
		return usrRep.viewstaff(staffid);
	}

	public void removeStaff(int staffid) {
		usrRep.deleteById(staffid);
	}

	public List<UniversityStaffMember> viewAllStaffs() {
		return usrRep.findAll();
	}

	public Course addCourse(Course course) {
		return crRep.save(course);
	}

	public void removeCourse(int courseId) throws CourseNotFoundException {
		crRep.deleteById(courseId);
	}

	public Course updateCourse(Course course) throws CourseNotFoundException {
		return crRep.save(course);
	}

}