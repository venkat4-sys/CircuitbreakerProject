package com.ait.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ait.dto.Studentinfo;

@Service
public class StudentServiceInfo {
	
	private String GET_STUDENT_INFO_URL="http://localhost:8080/get/{id}";
	
	public Studentinfo getStudentInfo(Integer id) {
		
		WebClient webclient = WebClient.create();
		Studentinfo details = webclient.get()
		         .uri(GET_STUDENT_INFO_URL,id)
		         .retrieve()
		         .bodyToMono(Studentinfo.class)
		         .block();
		
		return details;
		
		
		
	}
	

}
