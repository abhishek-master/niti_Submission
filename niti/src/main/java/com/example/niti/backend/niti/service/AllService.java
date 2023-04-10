package com.example.niti.backend.niti.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.niti.backend.niti.model.DataSessionModel;
import com.example.niti.backend.niti.model.PostModelRecieved;

public interface AllService {
	
	public DataSessionModel createDataSession() ;
	
	public PostModelRecieved getConsent(String id);
	
	public String getData(String id) ;
	

}
