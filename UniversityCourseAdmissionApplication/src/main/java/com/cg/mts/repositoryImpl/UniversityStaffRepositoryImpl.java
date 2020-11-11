package com.cg.mts.repositoryImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.mts.entities.Course;
import com.cg.mts.entities.UniversityStaffMember;
import com.cg.mts.repository.IUniversityStaffRepository;

public class UniversityStaffRepositoryImpl implements IUniversityStaffRepository{
	
	private static EntityManagerFactory emf=Persistence.createEntityManagerFactory("pu");
	private static EntityManager em=emf.createEntityManager();
	
	UniversityStaffMember usm= new UniversityStaffMember();

	public UniversityStaffMember addStaff(UniversityStaffMember user) {
		// TODO Auto-generated method stub
		if(user!=null) {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		}
		return user;
	}

	public UniversityStaffMember updateStaff(UniversityStaffMember user) {
		// TODO Auto-generated method stub
		UniversityStaffMember u=em.find(UniversityStaffMember.class,user.getStaffId());
		if(u!=null)
		{
			em.getTransaction().begin();
			em.remove(u);
			em.merge(user);
			em.getTransaction().commit();
		}
		else
			System.out.println("Details not found");
		return u;
	}

	public UniversityStaffMember viewStaff(int staffid) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.find(UniversityStaffMember.class, staffid);
		em.getTransaction().commit();
		return usm;
	}

	public void removeStaff(int staffid) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.remove(staffid);
		em.getTransaction().commit();
		
	}

	public List<UniversityStaffMember> viewAllStaffs() {

		// TODO Auto-generated method stub
		String jpql ="select c from UniversityStaffMember c";
		Query query=em.createQuery(jpql);
		List<UniversityStaffMember>UList=query.getResultList();
		return UList;
	}

	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		if(course!=null) {
			em.getTransaction().begin();
			em.persist(course);
			em.getTransaction().commit();
		}
		return course;
	}

	public Course removeCourse(int courseId) { //doubt
		// TODO Auto-generated method stub
		Course c=em.find(Course.class, courseId);
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
		return c;
	}

	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		Course c=em.find(Course.class,course.getCourseId());
		if(c!=null)
		{
			em.getTransaction().begin();
			em.remove(c);
			em.merge(course);
			em.getTransaction().commit();
		}
		else
			System.out.println("Details not found");
		return c;
	}

}
