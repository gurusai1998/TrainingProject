package com.cg.mts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.Course;
import com.cg.mts.entities.UniversityStaffMember;
import com.cg.mts.exceptions.CourseNotFoundException;
import com.cg.mts.repository.ICourseRepository;
import com.cg.mts.repository.IUniversityStaffRepository;
@Service
public class UniversityStaffServiceImpl{
	@Autowired
	IUniversityStaffRepository usrRep;
	ICourseRepository crRep;
	

	public UniversityStaffMember addStaff(UniversityStaffMember user) {
		// TODO Auto-generated method stub
		return usrRep.save(user);
	}

	public UniversityStaffMember updateStaff(UniversityStaffMember user) {
		// TODO Auto-generated method stub
		return usrRep.save(user);
	}

	public Optional<UniversityStaffMember> viewStaff(int staffid) {
		return usrRep.findById(staffid);
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
