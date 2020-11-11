package com.cg.mts.main;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.mts.entities.Admission;
import com.cg.mts.entities.AdmissionCommiteeMember;
import com.cg.mts.entities.AdmissionStatus;
import com.cg.mts.entities.Applicant;
import com.cg.mts.serviceImpl.AdmissionCommitteeMemberServiceImpl;
import com.cg.mts.serviceImpl.ApplicantServiceImpl;

public class UniversityCourseSelection {
	
public static void main(String[] args) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("pu");
	EntityManager em=emf.createEntityManager();
	EntityTransaction eTransaction=em.getTransaction();
	AdmissionCommitteeMemberServiceImpl a = new AdmissionCommitteeMemberServiceImpl();
	AdmissionCommiteeMember aCommiteeMember = new AdmissionCommiteeMember();
	Admission admission = new Admission();
	admission.setAdmissionDate(LocalDate.of(1998, 10, 15));
	admission.setAdmissionId(12345);
	admission.setApplicantId(222);
	admission.setCourseId(1222);
	AdmissionStatus admissionStatus = AdmissionStatus.Applied;
	Applicant applicant = new Applicant("205", "Hello", "256845", "B.tech", 56, admission, admissionStatus);
	ApplicantServiceImpl am= new ApplicantServiceImpl();
	am.addApplicant(applicant);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//CourseRepositoryImpl cri = new CourseRepositoryImpl();
	//AdmissionCommiteeMember admissionCommiteeMember = new AdmissionCommiteeMember(123, "Hi", "12345");
	//Admission admission = new Admission(123, 101, 546321, LocalDate.of(2020, Month.OCTOBER, 29),AdmissionStatus.Rejected);
	//Applicant applicant = new Applicant("123", "hello", "9876543210", "B.Tech", 75, admission, AdmissionStatus.Confirmed);
//	Course course = new Course(2564, "M.Tech", "2years", LocalDate.of(2020, 10, 29), LocalDate.of(2022, 10, 28), "200000");
//	UniversityStaffMember universityStaffMember = new UniversityStaffMember(5485, "Hello", "HOD");
	//eTransaction.begin();
//	em.persist(admission);
//	em.persist(admissionCommiteeMember);
//	em.persist(applicant);
//	em.persist(course);
//	em.persist(universityStaffMember);
//	eTransaction.commit();
//	ArrayList list=new ArrayList();
//	list.add(universityStaffMember);
//	cri.addCourse(course);
//	List<Course> list1=cri.viewCourseList();
//	System.out.println(list1);
}
}
