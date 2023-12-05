package com.casestudy.mentorservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.casestudy.mentorservice.dto.MentorDto;
import com.casestudy.mentorservice.entity.Mentor;
import com.casestudy.mentorservice.mapper.MentorMapper;
import com.casestudy.mentorservice.repo.MentorRepo;
import com.casestudy.mentorservice.service.MentorService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MentorServiceImpl implements MentorService{
	
	
	private MentorRepo mentorRepo;
	
	@Override
	public MentorDto saveMentor(MentorDto mentorDto) {
		Mentor mentor = MentorMapper.mapToMentor(mentorDto);
		Mentor savedMentor = mentorRepo.save(mentor);
		MentorDto savedMentorDto = MentorMapper.mapToMentorDto(savedMentor);
		return savedMentorDto;
	}

	@Override
	public MentorDto getMentorById(Long mentorId) {
		Mentor mentor = mentorRepo.findById(mentorId).get();
		MentorDto mentorDto = MentorMapper.mapToMentorDto(mentor);
		return mentorDto;
	}

	@Override
	public List<MentorDto> getAllMentors() {
		List<Mentor> allMentors = mentorRepo.findAll();
		List<MentorDto> mentorList = new ArrayList(); 
		for (Mentor mentor : allMentors) {
			mentorList.add(MentorMapper.mapToMentorDto(mentor));
		}
		return mentorList;
	}

	@Override
	public MentorDto updateMentor(MentorDto mentorDto) {
		Mentor mentorExist = mentorRepo.findById(mentorDto.getMentorId()).get();
		mentorExist.setMentorName(mentorDto.getMentorName());
		mentorExist.setMentorEmail(mentorDto.getMentorEmail());
		mentorExist.setMentorExperties(mentorDto.getMentorExperties());
		Mentor updateMentor = mentorRepo.save(mentorExist);
		return MentorMapper.mapToMentorDto(updateMentor);
	}

	@Override
	public void deleteMentor(Long mentorId) {
		mentorRepo.deleteById(mentorId);
	}

	

	
	
}
