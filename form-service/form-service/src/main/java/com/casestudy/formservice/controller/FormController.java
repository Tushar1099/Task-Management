package com.casestudy.formservice.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.formservice.dto.FormDto;
import com.casestudy.formservice.service.FormService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/form")
@CrossOrigin("http://localhost:3000")
public class FormController {

	@Autowired
	private FormService formService;

	@GetMapping("/excel")
	public ResponseEntity<byte[]> createExcel() throws IOException {

		byte[] excelContent = formService.createExcel();
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=records.xlsx");
		return ResponseEntity.ok().headers(headers).body(excelContent);
	}

	@PostMapping
	public ResponseEntity<FormDto> createForm(@RequestBody FormDto formDto) {
		FormDto savedForm = formService.createForm(formDto);
		return new ResponseEntity<>(savedForm, HttpStatus.CREATED);
	}

	@GetMapping("/getByFormId/{id}")
	public ResponseEntity<FormDto> getFormByFormId(@PathVariable("id") Long formId) {
		FormDto foundForm = formService.getByFormId(formId);
		return new ResponseEntity<>(foundForm, HttpStatus.OK);
	}

	@GetMapping("/getByUserId/{id}")
	public ResponseEntity<FormDto> getFormByUserId(@PathVariable("id") Long userId) {
		FormDto foundUser = formService.getByUserId(userId);
		return new ResponseEntity<>(foundUser, HttpStatus.OK);
	}

	@GetMapping("/getAllForms")
	public ResponseEntity<List<FormDto>> getAllForms() {
		List<FormDto> allForms = formService.getAllForms();
		return new ResponseEntity<>(allForms, HttpStatus.OK);
	}
}
