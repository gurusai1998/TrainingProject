package com.cg.mts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.mts.entities.Applicant;
import com.cg.mts.exceptions.ApplicantNotFoundException;
import com.cg.mts.repository.ApplicantRepository;
import com.cg.mts.service.ApplicantService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ApplicantService.class)
public class ApplicantTest {
	
	@Autowired
	private ApplicantService appServ;
	@MockBean
	private ApplicantRepository appRepo;
	
	@Test
	public void testAddAdmissionDetails() throws ApplicantNotFoundException{
		Applicant app=new Applicant();
		app.setApplicantId(111);
		app.setApplicantName("Vinay");
		app.setMobileNumber("9676278899");
		app.setApplicantDegree("B.Tech");
		app.setApplicantGraduationPercent(98);
		when(appRepo.save(app)).thenReturn(app);
		assertEquals(app, appServ.addApplicant(app));
	}
	
	@Test
	public void testUpdateApplicantDetails() throws ApplicantNotFoundException{
		Applicant app=new Applicant();
		app.setApplicantId(112);
		app.setApplicantName("Rakesh");
		app.setMobileNumber("9676279989");
		app.setApplicantDegree("B.Tech");
		app.setApplicantGraduationPercent(95);
		when(appRepo.save(app)).thenReturn(app);
		assertEquals(app, appServ.updateApplicant(app));
	}
	
	public void testDeleteApplicant() throws ApplicantNotFoundException {
		Applicant app=new Applicant();
		int id = app.getApplicantId();
		appServ.deleteApplicant(112);
		}
		
	
	@Test
	public void testShowAllApplicants() throws ApplicantNotFoundException{  //doubt
	Applicant app = new Applicant();
		int id = app.getApplicantId();
		Mockito.when(appRepo.viewApplicant(id)).thenReturn(app);
		assertEquals(app, appServ.viewApplicant(id));	
	}
	
//	@Test
//	public void testviewAllApplicantsByCourse(){  //doubt
//		Applicant app = new Applicant();
//	Course cou=new Course();
//		int id =(<Iterable>Integer)(cou.getCourseId());
//		//List<Admission> admList=new ArrayList<Admission>();
//		Mockito.when(appRepo.viewAllApplicantsByCourse(id)).thenReturn(app));
//		assertEquals(app, appServ.viewApplicant(id));	
//	}
//	
}