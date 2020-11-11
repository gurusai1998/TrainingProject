package com.cg.mts.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mts.entities.Admission;

public interface AdmissionRepository extends JpaRepository<Admission, Integer>{
	public Admission findById(int Id);

	public Admission findAllByDate(LocalDate admissionDate);

}
