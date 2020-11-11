package com.cg.mts.repositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.mts.entities.Applicant;
import com.cg.mts.entities.Course;
import com.cg.mts.exception.ApplicantNotFoundException;
import com.cg.mts.exception.CourseNotFoundException;
import com.cg.mts.repository.IApplicantRepository;

public class ApplicantRepositoryImpl implements IApplicantRepository {
	
	private static EntityManagerFactory emf=Persistence.createEntityManagerFactory("pu");
	private static EntityManager em=emf.createEntityManager();
	Applicant app = new Applicant();

	public Applicant addApplicant(Applicant applicant) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.persist(applicant);
		em.getTransaction().commit();
		return applicant;
	}

	public Applicant updateApplicant(Applicant applicant) throws ApplicantNotFoundException {
		// TODO Auto-generated method stub
		Applicant a=em.find(Applicant.class,applicant.getApplicantId());
		if(a!=null)
		{
			em.getTransaction().begin();
			em.remove(a);
			em.merge(applicant);
			em.getTransaction().commit();
		}
		else
			System.out.println("Details not found");
		return a;
	}

	public Applicant deleteApplicant(Applicant applicant) throws ApplicantNotFoundException {//doubt
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.remove(applicant);
		em.getTransaction().commit();
		return applicant;
	}

	public Applicant viewApplicant(int applicantid) throws ApplicantNotFoundException {
		// TODO Auto-generated method stub
		String jpql="select a from Applicant a where a.applicantId=?1";
	    Query query= em.createQuery(jpql);
	    query.setParameter(1,applicantid);
	   Applicant applicant=(Applicant) query.getSingleResult();
	   
	   if(applicant==null)
	   {
		   throw new ApplicantNotFoundException("Not Found");
	   }
	   
		return applicant;
	}

	public List<Applicant> viewAllApplicantsByCourse(int courseid) { // doubt
		// TODO Auto-generated method stub
		if(em.find(Course.class, courseid)!=null)
		{
			String jpql="select a from Applicant a where a.courseId=?1";
			Query query=em.createQuery(jpql);
			query.setParameter(1, courseid);
			List<Applicant> list=query.getResultList();
			return list;
		} else
			try {
				throw new CourseNotFoundException("Not Found");
			} catch (CourseNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}
}