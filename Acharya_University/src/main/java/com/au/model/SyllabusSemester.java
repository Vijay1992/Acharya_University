package com.au.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_au_syllabus_semester")
public class SyllabusSemester {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int syllabus_sem_id;
	@NotNull
	private Integer year_id;
	@NotNull
	private Integer sem_id;
	@NotNull
	private Integer course_id;

	public int getSyllabus_sem_id() {
		return syllabus_sem_id;
	}

	public void setSyllabus_sem_id(int syllabus_sem_id) {
		this.syllabus_sem_id = syllabus_sem_id;
	}

	public Integer getYear_id() {
		return year_id;
	}

	public void setYear_id(Integer year_id) {
		this.year_id = year_id;
	}

	public Integer getSem_id() {
		return sem_id;
	}

	public void setSem_id(Integer sem_id) {
		this.sem_id = sem_id;
	}

	public Integer getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}

}
