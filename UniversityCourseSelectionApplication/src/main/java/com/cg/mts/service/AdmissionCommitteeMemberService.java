package com.cg.mts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.entities.AdmissionCommiteeMember;
import com.cg.mts.repository.AdmissionCommiteeMemberRepository;

@Service
public class AdmissionCommitteeMemberService{
	@Autowired
	AdmissionCommiteeMemberRepository acmr;

	public AdmissionCommiteeMember addCommiteeMember(AdmissionCommiteeMember member) {

		return acmr.save(member);
	}

	public AdmissionCommiteeMember updateCommiteeMember(AdmissionCommiteeMember member) {
		if(acmr.findById(member.getAdminId())!=null) {
			return acmr.save(member);
		}
		else {
			return null;
		}
	}

	public List<AdmissionCommiteeMember> viewCommiteeMember(int adminId) {
		return (List<AdmissionCommiteeMember>)acmr.findById(adminId);
	}

	public void removeCommiteeMember(int adminId) {
		acmr.deleteById(adminId);

	}

	public List<AdmissionCommiteeMember> viewAllCommiteeMembers() {
		return acmr.findAll();
	}

//	public void provideAdmissionResult(Applicant applicant, Admission admission) {
//		acmr.
//	}
}