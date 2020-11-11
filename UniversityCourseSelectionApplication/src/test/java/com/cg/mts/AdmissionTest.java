package com.cg.mts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.cg.mts.entities.Admission;
import com.cg.mts.entities.AdmissionStatus;
import com.cg.mts.exceptions.AdmissionNotGrantedException;
import com.cg.mts.repository.AdmissionRepository;
import com.cg.mts.service.AdmissionService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=AdmissionService.class)
public class AdmissionTest {
	@Autowired
	private AdmissionService admServ;
	@MockBean
	private AdmissionRepository admRepo;

	@Test
	public void testAddAdmissionDetails() throws AdmissionNotGrantedException{
		Admission adm=new Admission();
		adm.setAdmissionId(123456);
		adm.setAdmissionDate(LocalDate.now());
		adm.setApplicantId(565);
		adm.setCourseId(101);
		adm.setStatus(AdmissionStatus.Pending);
		when(admRepo.save(adm)).thenReturn(adm);
		assertEquals(adm, admServ.addAdmission(adm));
	}
	
	@Test
	public void testUpdateAdmissionDetails() throws AdmissionNotGrantedException{
		Admission adm=new Admission();
		adm.setAdmissionId(1234);
		adm.setAdmissionDate(LocalDate.of(2020, 05, 06));
		adm.setApplicantId(565);
		adm.setCourseId(56);
		adm.setStatus(AdmissionStatus.Confirmed);
		when(admRepo.save(adm)).thenReturn(adm);
		assertEquals(adm, admServ.updateAdmission(adm));
	}
	
	@Test
	public void testDeleteAdmission() throws AdmissionNotGrantedException {
		Admission adm=new Admission();
		int id = adm.getAdmissionId();
		admServ.cancelAdmission(id);
	}

	@Test
	public void testShowAllAdmissionsByCourseId(){  //doubt
		Admission adm = new Admission();
		int id = adm.getCourseId();
		//List<Admission> admList=new ArrayList<Admission>();
		Mockito.when(admRepo.findById(id)).thenReturn(adm);
		assertEquals(adm, admServ.showAllAdmissionsByCourseId(id));	
	}
	
	@Test
	public void testShowAllAdmissionsByDate(){  //doubt
		Admission adm = new Admission();
		LocalDate date = adm.getAdmissionDate();
		//List<Admission> admList=new ArrayList<Admission>();
		Mockito.when(admRepo.findAllByDate(date)).thenReturn(adm);
		assertEquals(adm, admServ.showAllAdmissionsByDate(date));	
	}
	
}
