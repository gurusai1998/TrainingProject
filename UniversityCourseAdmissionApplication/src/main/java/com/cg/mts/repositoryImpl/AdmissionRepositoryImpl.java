package com.cg.mts.repositoryImpl;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.mts.entities.Admission;
import com.cg.mts.entities.Course;
import com.cg.mts.exception.AdmissionNotGrantedException;
import com.cg.mts.exception.CourseNotFoundException;
import com.cg.mts.repository.IAdmissionRepository;

public class AdmissionRepositoryImpl implements IAdmissionRepository{
	
	private static EntityManagerFactory emf=Persistence.createEntityManagerFactory("pu");
	private static EntityManager em=emf.createEntityManager();
	

	public Admission addAdmission(Admission admission) throws AdmissionNotGrantedException {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.persist(admission);
		em.getTransaction().commit();
		return admission;
	}

	public Admission updateAdmission(Admission admission) throws AdmissionNotGrantedException {
		// TODO Auto-generated method stub
		Admission a=em.find(Admission.class,admission.getAdmissionId());
		if(a!=null)
		{
			em.getTransaction().begin();
			em.remove(a);
			em.merge(admission);
			em.getTransaction().commit();
		}
		return a;
	}

	public Admission cancelAdmission(int admissionid) throws AdmissionNotGrantedException {
		Admission a=em.find(Admission.class,admissionid);
		if(a!=null)
		{
		em.getTransaction().begin();
		em.remove(a);
		em.getTransaction().commit();
		}
		return a;
	}

	public List<Admission> showAllAdmissionsByCourseId(int courseid) { //ShowCoursesById
		if(em.find(Course.class, courseid)!=null)
		{
			String jpql="select a from Admission a where a.courseId=?1"; 
			Query query=em.createQuery(jpql);
			query.setParameter(1, courseid);
			List<Admission> list=query.getResultList();
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

	public List<Admission> showAllAdmissionsByDate(LocalDate admissiondate) {
		if(em.find(Admission.class, admissiondate)!=null)
		{
			String jpql="select a from Admission a where a.admissionDate=?1";
			Query query=em.createQuery(jpql);
			query.setParameter(1, admissiondate);
			List<Admission> list=query.getResultList();
			return list;
		} 
		else
			try {
				throw new CourseNotFoundException("Not Found");
			} catch (CourseNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}

	public List<Admission> showAllAdmissionsByApplicant(int applicantid) {
		if(em.find(Admission.class, applicantid)!=null)
		{
			String jpql="select a from Admission a where a.applicantId=?1";
			Query query=em.createQuery(jpql);
			query.setParameter(1, applicantid);
			List<Admission> list=query.getResultList();
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
