package com.casestudy.formservice.entity;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "form-data")
public class Form {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long formId;
	
	private Long userId;
	
	private String userName;
	
	private String userGithub;
	
	private String title;
	
	private String heading;
	
	private String startTime;
	
	private String endTime;
	
}
