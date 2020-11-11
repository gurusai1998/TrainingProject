package com.cg.mts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.cg.mts.entities.Course;
import com.cg.mts.exceptions.CourseNotFoundException;
import com.cg.mts.repository.CourseRepository;
import com.cg.mts.service.CourseService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CourseService.class)
public class CourseTest {
	@Autowired
	private CourseService couServ;
	@MockBean
	private CourseRepository couRepo;

	@Test
	public void testAddCourseDetails() throws CourseNotFoundException {
		Course cou = new Course();
		cou.setCourseId(123456);
		// cou.setCourseDate(LocalDate.now());
		cou.setCourseId(565);
		cou.setCourseId(101);
		// cou.setStatus(CourseStatus.Pending);
		when(couRepo.save(cou)).thenReturn(cou);
		assertEquals(cou, couServ.addCourse(cou));
	}

	@Test
	public void testUpdateCourseDetails() throws CourseNotFoundException {
		Course cou = new Course();
		cou.setCourseId(1234);
		// cou.setCourseDate(LocalDate.of(2020, 05, 06));
		// cou.setCoursetId(565);
		cou.setCourseId(56);
		// cou.setStatus(CourseStatus.Confirmed);
		when(couRepo.save(cou)).thenReturn(cou);
		assertEquals(cou, couServ.updateCourse(cou));
	}

	@Test
	public void testDeleteCourse() throws CourseNotFoundException {
		Course cou = new Course();
		int id = cou.getCourseId();
		couServ.removeCourse(id);
	}
	
	  @Test 
	  public void testShowAllCourseByCourseId() throws CourseNotFoundException { // doubt Course cou = new
			Course cou = new Course(568,"java","20 hrs",LocalDate.now(),LocalDate.now(),"20000");
	  // List<Admission> admList=new ArrayList<Admission>();
	  Mockito.when(couRepo.findById(568)).thenReturn(Optional.of(cou)); 
	  assertEquals(cou,couServ.viewCourse(568)); }
	 
	@Test
	public void testViewAllCourses() { // doubt
		Course cou = new Course(568,"java","20 hrs",LocalDate.now(),LocalDate.now(),"20000");
		Course cou1 = new Course(569,"java1","21 hrs",LocalDate.now(),LocalDate.now(),"21000");
		//String date = cou.getCourseDuration();
		List<Course> couList = new ArrayList<Course>();
		couList.add(cou);
		couList.add(cou1);
		Mockito.when(couRepo.findAll()).thenReturn(couList);
		assertEquals(couList.size(), couServ.viewAllCourses().size());
	}
}