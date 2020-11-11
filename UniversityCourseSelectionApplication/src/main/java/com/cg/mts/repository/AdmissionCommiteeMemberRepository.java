package com.cg.mts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mts.entities.Admission;
import com.cg.mts.entities.AdmissionCommiteeMember;

public interface AdmissionCommiteeMemberRepository extends JpaRepository<AdmissionCommiteeMember, Integer>{
	public List<AdmissionCommiteeMember> findById(int adminId);

}
