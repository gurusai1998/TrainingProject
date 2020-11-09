package com.cg.mts.entities;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Admission {

@Id
//@GeneratedValue(strategy=GenerationType.AUTO)
private int admissionId;
private int courseId;
private int applicantId;
private LocalDate admissionDate;
private AdmissionStatus status;
public int getAdmissionId() {
	return admissionId;
}
public void setAdmissionId(int admissionId) {
	this.admissionId = admissionId;
}
public int getCourseId() {
	return courseId;
}
public void setCourseId(int courseId) {
	this.courseId = courseId;
}
public int getApplicantId() {
	return applicantId;
}
public void setApplicantId(int applicantId) {
	this.applicantId = applicantId;
}
public LocalDate getAdmissionDate() {
	return admissionDate;
}
public AdmissionStatus getStatus() {
	return status;
}
public void setStatus(AdmissionStatus status) {
	this.status = status;
}
public void setAdmissionDate(LocalDate admissionDate) {
	this.admissionDate = admissionDate;
}
public Admission(int admissionId, int courseId, int applicantId, LocalDate admissionDate, AdmissionStatus status) {
	super();
	this.admissionId = admissionId;
	this.courseId = courseId;
	this.applicantId = applicantId;
	this.admissionDate = admissionDate;
	this.status = status;
}
public Admission() {
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Admission [admissionId=" + admissionId + ", courseId=" + courseId + ", applicantId=" + applicantId
			+ ", admissionDate=" + admissionDate + ", status=" + status + "]";
}

}
