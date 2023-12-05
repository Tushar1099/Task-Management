package com.casestudy.formservice.Impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.casestudy.formservice.dto.FormDto;
import com.casestudy.formservice.entity.Form;
import com.casestudy.formservice.repo.FormRepo;
import com.casestudy.formservice.service.FormService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FormServiceImpl implements FormService{

	private ModelMapper modelMapper;
	
	private FormRepo formRepo;
	
	@Override
	public FormDto createForm(FormDto formDto) {
		Form form = modelMapper.map(formDto, Form.class);
		Form savedFrom = formRepo.save(form);
		FormDto savedFormDto = modelMapper.map(savedFrom, FormDto.class);
		return savedFormDto;
	}

	@Override
	public FormDto getByFormId(Long formId) {
		Optional<Form> foundForm = formRepo.findById(formId);
		return modelMapper.map(foundForm, FormDto.class);
	}

	@Override
	public FormDto getByUserId(Long userId) {
		Optional<Form> foundUser = formRepo.findById(userId);
		return modelMapper.map(foundUser, FormDto.class);
	}

	@Override
	public List<FormDto> getAllForms()  {
		List<Form> allForms = formRepo.findAll();
		List<FormDto> allFormsDto = new ArrayList<>();
		for (Form forms : allForms) {
			allFormsDto.add(modelMapper.map(forms, FormDto.class));
			
		}
		
		return allFormsDto;
	}

	@Override
	public byte[] createExcel() throws IOException {
		List<FormDto> forms = getAllForms();
		
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Sheet1");//created the sheet 

		
		Row headerRow = sheet.createRow(0);// creating row with the given indexed row number
		
		Cell headerCell1 = headerRow.createCell(0);
		headerCell1.setCellValue("formId");
		Cell headerCell2 = headerRow.createCell(1);
		headerCell2.setCellValue("userId");
		Cell headerCell3 = headerRow.createCell(2);
		headerCell3.setCellValue("userName");
		Cell headerCell4 = headerRow.createCell(3);
		headerCell4.setCellValue("userGithub");
		Cell headerCell5 = headerRow.createCell(4);
		headerCell5.setCellValue("title");
		Cell headerCell6 = headerRow.createCell(5);
		headerCell6.setCellValue("heading");
		Cell headerCell7 = headerRow.createCell(6);
		headerCell7.setCellValue("startTime");
		Cell headerCell8 = headerRow.createCell(7);
		headerCell8.setCellValue("endTime");

		for(int i=0;i<forms.size();i++) {
			FormDto dto = forms.get(i);
			Row dataRow = sheet.createRow(i+1);
			
			Cell dataCell0 = dataRow.createCell(0);
			dataCell0.setCellValue(dto.getFormId());
			
			Cell dataCell1 = dataRow.createCell(1);
			dataCell1.setCellValue(dto.getUserId());
			
			Cell dataCell2 = dataRow.createCell(2);
			dataCell2.setCellValue(dto.getUserName());
			
			Cell dataCell3 = dataRow.createCell(3);
			dataCell3.setCellValue(dto.getUserGithub());
			
			Cell dataCell4 = dataRow.createCell(4);
			dataCell4.setCellValue(dto.getTitle());
			
			Cell dataCell5 = dataRow.createCell(5);
			dataCell5.setCellValue(dto.getHeading());
			
			Cell dataCell6 = dataRow.createCell(6);
			dataCell6.setCellValue(dto.getStartTime().toString());
			
			Cell dataCell7 = dataRow.createCell(7);
			dataCell7.setCellValue(dto.getEndTime().toString());
			
			
		}
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		workbook.write(outputStream);
		workbook.close();
		byte[] excelContent = outputStream.toByteArray();
		return excelContent;
	}

}
