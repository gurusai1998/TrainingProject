package com.cg.mts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.mts.entities.AdmissionCommiteeMember;
import com.cg.mts.repository.AdmissionCommiteeMemberRepository;
import com.cg.mts.service.AdmissionCommitteeMemberService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=AdmissionCommitteeMemberService.class)
public class AdmissionCommiteeMemberTest {
	@Autowired
	private AdmissionCommitteeMemberService acmServ;
	@MockBean
	private AdmissionCommiteeMemberRepository acmRepo;

	@Test
	public void testAddAdmissionCommitteeMemberDetails() {
		AdmissionCommiteeMember acm=new AdmissionCommiteeMember();
		acm.setAdminId(12345);
		acm.setAdminName("madhu");
		acm.setAdminContact("69457125");
		when(acmRepo.save(acm)).thenReturn(acm);
		assertEquals(acm, acmServ.addCommiteeMember(acm));
	}


	@Test
	public void testUpdateAdmissionCommitteeMemberDetails() {
		AdmissionCommiteeMember acm=new AdmissionCommiteeMember();
		acm.setAdminId(12346);
		acm.setAdminName("kinnera");
		acm.setAdminContact("6945712");
		when(acmRepo.save(acm)).thenReturn(acm);
		assertEquals(acm, acmServ.updateCommiteeMember(acm));
	}


	@Test
	public void testDeleteAdmissionCommitteeMember() {
		AdmissionCommiteeMember acm=new AdmissionCommiteeMember();
		int id = acm.getAdminId();
		acmServ.removeCommiteeMember(id);
	}


//	@Test
//	public void testviewCommiteeMember(){  //doubt
//		List<AdmissionCommiteeMember> acm=new AdmissionCommiteeMember();
//		int id = ((AdmissionCommiteeMember) acm).getAdminId();
//		//List<AdmissionCommiteeMember> acmList=new ArrayList<AdmissionCommiteeMember>();
//		Mockito.when(acmServ.viewCommiteeMember(id)).thenReturn(acm);
//		assertEquals(acm, acmServ.viewCommiteeMember(id));	
//	}


	@Test
	public void testviewAllCommiteeMembers(){  //doubt
		AdmissionCommiteeMember acm=new AdmissionCommiteeMember(12342,"syamala","674521");
		AdmissionCommiteeMember acm1=new AdmissionCommiteeMember(12344,"sravani","674531");

		List<AdmissionCommiteeMember> acmList=new ArrayList<AdmissionCommiteeMember>();
		acmList.add(acm);
		acmList.add(acm1);
		Mockito.when(acmRepo.findAll()).thenReturn(acmList);
		assertEquals(acmList.size(), acmServ.viewAllCommiteeMembers().size());	
	}

}