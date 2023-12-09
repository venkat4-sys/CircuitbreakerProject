package com.ait.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ait.dto.Studentinfo;
import com.ait.service.StudentService;

@RestController
public class StudentRestController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getStudentDetails(@PathVariable Integer id){
		Studentinfo studentInfo = studentService.getStudentInfo(id);
		
		return new ResponseEntity<>(studentInfo, HttpStatus.OK);
	}
	
	

}
