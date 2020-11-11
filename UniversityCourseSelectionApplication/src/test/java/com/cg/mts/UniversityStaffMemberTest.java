package com.cg.mts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.mts.entities.Course;
import com.cg.mts.entities.UniversityStaffMember;
import com.cg.mts.repository.CourseRepository;
import com.cg.mts.repository.UniversityStaffRepository;
import com.cg.mts.service.CourseService;
import com.cg.mts.service.UniversityStaffService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=UniversityStaffService.class)
public class UniversityStaffMemberTest {

	@Autowired
	private UniversityStaffService universitystaffservice;
	private CourseService courseservice;
	@MockBean
	private UniversityStaffRepository universitystaffrepository;
	private CourseRepository courserepository;


	UniversityStaffMember usm=new UniversityStaffMember();
	Course course=new Course();

	@Test
	public void testaddingstaffdetails() {

		usm.setStaffId(123);
		usm.setPassword("staff@123");
		usm.setRole("hod");
		when(universitystaffrepository.save(usm)).thenReturn(usm);
		assertEquals(usm, universitystaffservice.addStaff(usm));
	}

	@Test
	public void testupdatingstaffdetails() {
		usm.setStaffId(123);
		usm.setPassword("staff@123");
		usm.setRole("hod");
		when(universitystaffrepository.save(usm)).thenReturn(usm);
		assertEquals(usm, universitystaffservice.updateStaff(usm));
	}

	@Test
	public void testdeletingstaffdetails() {
		int id=usm.getStaffId();
		universitystaffservice.removeStaff(id);
	}
	@Test
	public void testviewstaffbyid() {
		int id = usm.getStaffId();
		Mockito.when(universitystaffrepository.viewstaff(id)).thenReturn(usm);
		assertEquals(usm,universitystaffservice.viewStaff(id));
	}
	@Test
	public void testviewallstaff() {
		List<UniversityStaffMember> lusm=new ArrayList<UniversityStaffMember>();
		Mockito.when(universitystaffrepository.findAll()).thenReturn(lusm);
		assertEquals(lusm,universitystaffservice.viewAllStaffs());
	}

	//	@Test
	//	public void testaddingcourse() throws CourseNotFoundException {
	//		course.setCourseId(123);
	//		course.setCourseName("btech");
	//		course.setCourseFees("25k");
	//		course.setCourseDuration("2 years");
	//		course.setCourseStartDate(LocalDate.of(2020, 05, 06));
	//		course.setCourseEndDate(LocalDate.of(2022, 05, 06));
	//		when(courserepository.save(course)).thenReturn(course);
	//		assertEquals(course, universitystaffservice.addCourse(course));
	//	}
	//
	//	@Test
	//	public void testupdatingcourse() throws CourseNotFoundException {
	//		course.setCourseId(123);
	//		course.setCourseName("btech");
	//		course.setCourseFees("25k");
	//		course.setCourseDuration("2 years");
	//		course.setCourseStartDate(LocalDate.of(2020, 05, 06));
	//		course.setCourseEndDate(LocalDate.of(2022, 05, 06));
	//		when(courserepository.save(course)).thenReturn(course);
	//		assertEquals(course, universitystaffservice.updateCourse(course));
	//	}
	//	@Test
	//	public void testDeleteCourse() throws CourseNotFoundException {
	//		Course cou = new Course();
	//		int id = cou.getCourseId();
	//		courseservice.removeCourse(id);
	//	}



}