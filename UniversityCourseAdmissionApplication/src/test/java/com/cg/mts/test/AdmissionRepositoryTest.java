package com.cg.mts.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.cg.mts.entities.Admission;
import com.cg.mts.entities.Applicant;
import com.cg.mts.entities.Course;
import com.cg.mts.exception.AdmissionNotGrantedException;
import com.cg.mts.main.MainClassTest;
import com.cg.mts.repositoryImpl.AdmissionRepositoryImpl;
import com.cg.mts.repositoryImpl.ApplicantRepositoryImpl;
import com.cg.mts.repositoryImpl.CourseRepositoryImpl;

public class AdmissionRepositoryTest {

	MainClassTest mct;
	CourseRepositoryImpl cr;
	Course course;
	ApplicantRepositoryImpl ari;
	Admission adm;
	Applicant appl;
	AdmissionRepositoryImpl admri;

	@Before
	public void Init() {
		cr = new CourseRepositoryImpl();
		course= new Course();
		adm = new Admission();
		appl = new Applicant();
		admri = new AdmissionRepositoryImpl();
		ari = new ApplicantRepositoryImpl();
		mct= new MainClassTest();
	}

	@Test
	public void addAdmission() {
		adm= mct.getAdmissionAdded();
		try {
			assertNotNull(admri.addAdmission(adm));
		} catch (AdmissionNotGrantedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void updateAdmission() {
		adm=mct.getAdmissionUpdated();
		try {
			assertNotNull(admri.updateAdmission(adm));
		} catch (AdmissionNotGrantedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void cancelAdmission() {
		adm=mct.getAdmissionCancelled();
		try {
			assertNotNull(admri.cancelAdmission(1));
		} catch (AdmissionNotGrantedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
