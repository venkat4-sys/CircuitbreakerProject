package com.ait.service;

import org.springframework.stereotype.Service;

import com.ait.dto.Studentinfo;

@Service
public class StudentService {
	
	public Studentinfo getStudentInfo(Integer id) {
		
		Studentinfo details=new Studentinfo(1,"Raghu","Hyderabad");
		return details;
	}

}
