package com.cg.mts.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.cg.mts.entities.AdmissionCommiteeMember;
import com.cg.mts.main.MainClassTest;
import com.cg.mts.repositoryImpl.AdmissionCommiteeMemberRepositoryImpl;

public class AdmissionCommitteMemberRepositoryTest {
	
	MainClassTest mct;
	AdmissionCommiteeMemberRepositoryImpl acmr;
	AdmissionCommiteeMember acm;
	@Before
	public void Init() {
		 acm = new AdmissionCommiteeMember();
		 acmr= new AdmissionCommiteeMemberRepositoryImpl();
		 mct= new MainClassTest();
	}

	@Test
	public void addCommitteMember() {
		acm= mct.getAdmissionCommiteeMemberDetails();
		assertNotNull(acmr.addCommiteeMember(acm));
	}
	@Test
	public void updateCommitteMember() {
		acm=mct.getAdmissionCommiteeMemberUpdateDetails();
		assertNotNull(acmr.updateCommiteeMember(acm));
	}
	@Test
	public void viewAllAdmissionCommitteMembers() {
		
		assertNotNull(acmr.viewAllCommiteeMembers());
	
	}

}
