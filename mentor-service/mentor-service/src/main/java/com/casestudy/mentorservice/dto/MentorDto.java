package com.casestudy.mentorservice.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MentorDto {
	
	private Long mentorId;
	
	private String mentorName;
	
	private String mentorEmail;
	
	private String mentorExperties;
}
