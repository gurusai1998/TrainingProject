package com.cg.mts.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.cg.mts.entities.Admission;
import com.cg.mts.entities.AdmissionCommiteeMember;
import com.cg.mts.entities.AdmissionStatus;
import com.cg.mts.entities.Applicant;
import com.cg.mts.entities.Course;
import com.cg.mts.entities.UniversityStaffMember;

public class MainClassTest {
	Admission admission = new Admission();
	Admission admission1 = new Admission(); 
	Applicant applicant = new Applicant();
	Applicant applicant1 = new Applicant();
	AdmissionCommiteeMember admissionCommiteeMember = new AdmissionCommiteeMember();
	AdmissionCommiteeMember admissionCommiteeMember1 = new AdmissionCommiteeMember();
	UniversityStaffMember universityStaffMember = new UniversityStaffMember();
	UniversityStaffMember universityStaffMember1 = new UniversityStaffMember();
	Course course = new Course();
	Course course1 = new Course();
	List<AdmissionCommiteeMember>admissionCommiteeMemberList=new ArrayList<AdmissionCommiteeMember>();
	List<Course>courseList = new ArrayList<Course>();
	List<UniversityStaffMember>universityStaffMemberList= new ArrayList<UniversityStaffMember>();
	List<Admission>admissionList=new ArrayList<Admission>();
	//For AdmissionCommiteeMember Testing

	public AdmissionCommiteeMember getAdmissionCommiteeMemberDetails()
	{
		admissionCommiteeMember.setAdminId(562); //change value after running test case 
		admissionCommiteeMember.setAdminName("Heui");
		admissionCommiteeMember.setAdminContact("986432");
		return admissionCommiteeMember;
	}
	public AdmissionCommiteeMember getAdmissionCommiteeMemberUpdateDetails() {
		admissionCommiteeMember.setAdminId(557);
		admissionCommiteeMember.setAdminName("Hi World");
		admissionCommiteeMember.setAdminContact("659558985");
		return admissionCommiteeMember;
	}
	public List<AdmissionCommiteeMember> getAdmissionCommiteeMemberList()
	{
		admissionCommiteeMember.setAdminId(659);
		admissionCommiteeMember.setAdminName("world");
		admissionCommiteeMember.setAdminContact("987585856");
		admissionCommiteeMember1.setAdminId(8651);
		admissionCommiteeMember1.setAdminName("world");
		admissionCommiteeMember1.setAdminContact("987585856");
		admissionCommiteeMemberList.add(admissionCommiteeMember);
		admissionCommiteeMemberList.add(admissionCommiteeMember1);
		return admissionCommiteeMemberList;
	}

	//For Course Testing

	public Course getCourseAddDetails()
	{
		course.setCourseId(23); //change the value after running test case
		course.setCourseName("MBA");
		course.setCourseStartDate(LocalDate.of(2020, 10, 30));
		course.setCourseEndDate(LocalDate.of(2022, 10, 29));
		course.setCourseDuration("2 Years");
		course.setCourseFees("200000");
		return course;
	}
	public Course getCourseUpdateDetails()
	{
		course.setCourseId(12);
		course.setCourseName("MBA");
		course.setCourseStartDate(LocalDate.of(2020, 10, 30));
		course.setCourseEndDate(LocalDate.of(2022, 10, 29));
		course.setCourseDuration("2.5 Years");
		course.setCourseFees("6350000");
		return course;
	}
	public List<Course> getAllCourseList()
	{
		course.setCourseId(25);
		course.setCourseName("MBA");
		course.setCourseStartDate(LocalDate.of(2020, 10, 30));
		course.setCourseEndDate(LocalDate.of(2022, 10, 29));
		course.setCourseDuration("2 Years");
		course.setCourseFees("200000");
		course1.setCourseId(84);
		course1.setCourseName("MTECH");
		course1.setCourseStartDate(LocalDate.of(2020, 10, 30));
		course1.setCourseEndDate(LocalDate.of(2022, 10, 29));
		course1.setCourseDuration("2 Years");
		course1.setCourseFees("200000");
		courseList.add(course);
		courseList.add(course1);
		return courseList;
	}

	//For University Staff Member Testing


	public UniversityStaffMember getStaffAddDetails() //change the value after running test case
	{
		universityStaffMember.setStaffId(702);
		universityStaffMember.setRole("Main");
		universityStaffMember.setPassword("HELLO");

		return universityStaffMember;

	}
	public UniversityStaffMember getStaffUpdateDetails()
	{
		universityStaffMember.setStaffId(72);
		universityStaffMember.setRole("Main");
		universityStaffMember.setPassword("GIRIDHAR@123");

		return universityStaffMember;
	}
	public List<UniversityStaffMember> getAllStaffList()
	{
		universityStaffMember.setStaffId(792);
		universityStaffMember.setRole("HOD");
		universityStaffMember.setPassword("123");
		universityStaffMember1.setStaffId(222);
		universityStaffMember1.setRole("Faculty");
		universityStaffMember1.setPassword("456");
		universityStaffMemberList.add(universityStaffMember);
		universityStaffMemberList.add(universityStaffMember1);
		return universityStaffMemberList;

	}
	public Course getCourseRemoveDetails()
	{
		return course;
	}

	//For Admission Testing

	public Admission getAdmissionAdded()  //change the value after running test case
	{
		admission.setAdmissionId(1);
		admission.setCourseId(00001);
		admission.setApplicantId(22222222);
		admission.setAdmissionDate(LocalDate.of(2020, 10, 30));
		admission.setStatus(AdmissionStatus.Applied);
		return admission;
	}
	public Admission getAdmissionUpdated()
	{

		admission.setAdmissionId(2);
		admission.setCourseId(00001);
		admission.setApplicantId(2222211);
		admission.setAdmissionDate(LocalDate.of(2020, 10, 30));
		admission.setStatus(AdmissionStatus.Rejected);
		return admission;
	}
	public Admission getAdmissionCancelled()
	{
		return admission;
	}
	public List<Admission> getAdmissionsByDate()
	{
		admission.setAdmissionDate(LocalDate.of(2020, 10, 30));
		admissionList.add(admission);
		return admissionList ;
	}
	public List<Admission> getAdmissionsByApplicant()
	{
		admission.setApplicantId(2222211);
		admissionList.add(admission);
		return admissionList ;
	}
}
