package com.casestudy.formservice.dto;

import java.time.LocalTime;

import com.casestudy.formservice.entity.Form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class FormDto {
	
	private Long formId;

	private Long userId;

	private String userName;

	private String userGithub;

	private String title;

	private String heading;

	private String startTime;

	private String endTime;
}
