package org.bits.springboot2.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recruitments")
public class Recruitment {

	private long id;
	private String recruitmentTechnology;
	private String recruitmentLocation;
	private String department;
	
	public Recruitment() {
		
	}
	
	public Recruitment(String recruitmentTechnology, String recruitmentLocation, String department) {
		this.recruitmentTechnology = recruitmentTechnology;
		this.recruitmentLocation = recruitmentLocation;
		this.department = department;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "id", nullable = false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "technology", nullable = false)
	public String getRecruitmentTechnology() {
		return recruitmentTechnology;
	}

	public void setRecruitmentTechnology(String recruitmentTechnology) {
		this.recruitmentTechnology = recruitmentTechnology;
	}

	@Column(name = "location", nullable = false)
	public String getRecruitmentLocation() {
		return recruitmentLocation;
	}

	public void setRecruitmentLocation(String recruitmentLocation) {
		this.recruitmentLocation = recruitmentLocation;
	}

	@Column(name = "department", nullable = false)
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}


	@Override
	public String toString() {
		return "Recruitment [id=" + id + ", recruitmentTechnology=" + recruitmentTechnology + ", recruitmentLocation=" + recruitmentLocation + ", department=" + department
				+ "]";
	}
	
}
