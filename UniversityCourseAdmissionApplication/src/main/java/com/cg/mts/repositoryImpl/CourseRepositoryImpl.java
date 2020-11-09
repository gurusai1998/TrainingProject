package com.cg.mts.repositoryImpl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.mts.entities.Admission;
import com.cg.mts.entities.Course;
import com.cg.mts.exception.AdmissionNotGrantedException;
import com.cg.mts.exception.CourseNotFoundException;
import com.cg.mts.repository.ICourseRepository;

public class CourseRepositoryImpl implements ICourseRepository {
	
	private static EntityManagerFactory emf=Persistence.createEntityManagerFactory("pu");
	private static EntityManager em=emf.createEntityManager();

	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
			em.getTransaction().begin();
			em.persist(course);
			em.getTransaction().commit();
			return course;
	}
		

	public Course removeCourse(int courseid) throws CourseNotFoundException {
		Course c=em.find(Course.class,courseid);
		if(c!=null)
		{
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
		}
		return c;
	}

	public Course updateCourse(Course course) throws CourseNotFoundException {
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
			throw new CourseNotFoundException("Details not found");
		return c;
	}

	public Course viewCourse(int courseid) throws CourseNotFoundException {
		// TODO Auto-generated method stub
		if(em.find(Course.class, courseid)!=null)
		{
			String jpql="select c from Course c where c.courseId=?1";
			Query query=em.createQuery(jpql);
			query.setParameter(1, courseid);
			Course course=(Course)query.getSingleResult();
			return course;
		}
		else
			throw new CourseNotFoundException("Not Found");
	}

	public List<Course> viewCourseList() {
		String jpql="select c from Course c";
		Query query=em.createQuery(jpql);
		List<Course> list=query.getResultList();
		return list;
	
	}

}
