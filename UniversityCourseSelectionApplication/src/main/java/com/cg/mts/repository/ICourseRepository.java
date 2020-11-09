package com.cg.mts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mts.entities.Course;


public interface ICourseRepository extends JpaRepository<Course, Integer>{

}
