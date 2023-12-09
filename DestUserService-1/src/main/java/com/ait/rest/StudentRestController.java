package com.ait.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ait.dto.Studentinfo;
import com.ait.service.StudentServiceInfo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class StudentRestController {

	@Autowired
	private StudentServiceInfo studentService;
	
	private static final String USER_SERVICE="getStudentInfo";

	@GetMapping("/get/{id}")
	@CircuitBreaker(name=USER_SERVICE,fallbackMethod = "faultStudentInfo")
	public ResponseEntity<?> getStudentInfo(@PathVariable Integer id) {
		Studentinfo studentInfo = studentService.getStudentInfo(id);

		return new ResponseEntity<>(studentInfo, HttpStatus.OK);
	}

	public ResponseEntity<?> faultStudentInfo(Integer id, Exception ex) {
	    return new ResponseEntity<>("SERVICE IS DOWN, PLEASE TRY AFTER SOMETIME !!!",HttpStatus.INTERNAL_SERVER_ERROR);
	            
	}


}
