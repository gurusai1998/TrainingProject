package com.cg.mts.repositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.mts.entities.Admission;
import com.cg.mts.entities.AdmissionCommiteeMember;
import com.cg.mts.repository.IAdmissionCommiteeMemberRepository;

public class AdmissionCommiteeMemberRepositoryImpl implements IAdmissionCommiteeMemberRepository {

	private static EntityManagerFactory emf=Persistence.createEntityManagerFactory("pu");
	private static EntityManager em=emf.createEntityManager();
	
	Admission am= new Admission();
	AdmissionCommiteeMember acm=new AdmissionCommiteeMember();
	
	public AdmissionCommiteeMember addCommiteeMember(AdmissionCommiteeMember member) {
		
			em.getTransaction().begin(); //connection establishes between repository and entity
			em.persist(member);
			em.getTransaction().commit();
			return member;
	}
	
	public AdmissionCommiteeMember updateCommiteeMember(AdmissionCommiteeMember member) {
		
		// TODO Auto-generated method stub
		AdmissionCommiteeMember a=em.find(AdmissionCommiteeMember.class,member.getAdminId());
				if(a!=null)
				{
					em.getTransaction().begin();
					em.remove(a);
					em.merge(member);
					em.getTransaction().commit();
				}
				
				else
					System.out.println("Details not found");
				return a;
	}
	
	public AdmissionCommiteeMember viewCommiteeMember(int adminId) {
		em.getTransaction().begin();
		em.find(AdmissionCommiteeMember.class, adminId);
		em.getTransaction().commit();
		return acm;
	}
	
	public void removeCommiteeMember(int adminId) {
		em.getTransaction().begin();
		em.remove(adminId);
		em.getTransaction().commit();
		
	}
	public List<AdmissionCommiteeMember> viewAllCommiteeMembers() {
		String jpql="select a from AdmissionCommiteeMember a";
		Query query=em.createQuery(jpql);
		List<AdmissionCommiteeMember> list=query.getResultList();
		return list;
	}
	
}
