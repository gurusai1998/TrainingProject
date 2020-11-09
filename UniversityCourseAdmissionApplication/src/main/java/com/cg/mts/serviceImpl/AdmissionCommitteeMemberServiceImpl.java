package com.cg.mts.serviceImpl;

import java.util.List;

import com.cg.mts.entities.Admission;
import com.cg.mts.entities.AdmissionCommiteeMember;
import com.cg.mts.entities.Applicant;
import com.cg.mts.repository.IAdmissionCommiteeMemberRepository;
import com.cg.mts.repositoryImpl.AdmissionCommiteeMemberRepositoryImpl;
import com.cg.mts.service.IAdmissionCommiteeMemberService;

public class AdmissionCommitteeMemberServiceImpl implements IAdmissionCommiteeMemberService {
	
	IAdmissionCommiteeMemberRepository acmr =new AdmissionCommiteeMemberRepositoryImpl();

	
	public AdmissionCommiteeMember addCommiteeMember(AdmissionCommiteeMember member) {

		return acmr.addCommiteeMember(member);
	}

	public AdmissionCommiteeMember updateCommiteeMember(AdmissionCommiteeMember member) {
		// TODO Auto-generated method stub
		return acmr.updateCommiteeMember(member);
	}

	public AdmissionCommiteeMember viewCommiteeMember(int adminId) {
		// TODO Auto-generated method stub
		return acmr.viewCommiteeMember(adminId);
	}

	public void removeCommiteeMember(int adminId) {
		acmr.removeCommiteeMember(adminId);
		
	}

	public List<AdmissionCommiteeMember> viewAllCommiteeMembers() {
		// TODO Auto-generated method stub
		return acmr.viewAllCommiteeMembers();
	}

	public void provideAdmissionResult(Applicant applicant, Admission admission) {//doubt
		// TODO Auto-generated method stub
		
	}
}