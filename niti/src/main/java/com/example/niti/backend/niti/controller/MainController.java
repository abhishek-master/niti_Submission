package com.example.niti.backend.niti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.niti.backend.niti.model.DataSessionModel;
import com.example.niti.backend.niti.model.PostModelRecieved;
import com.example.niti.backend.niti.service.AllService;

@RestController
@RequestMapping("/api/v1")
public class MainController {

	@Autowired
	private AllService allService ;	
	
	
	
	@GetMapping("/getConsents")
	public PostModelRecieved getConsent () {
		
		PostModelRecieved pmr = allService.getConsent("408d9495-fe84-4dce-8054-47bf54d2c658"); 
		return pmr ; 
	}
	
	
	
	  @PostMapping 
	  public DataSessionModel createDataSession () {
	   DataSessionModel dsm = allService.createDataSession() ;
	   return dsm ;
	  
	  
	  
	  }
	 
	
	
	
	
	
	/*
	 * @PostMapping("/posts") public String getConsent(@RequestBody ) { return null
	 * }
	 */
	
	@GetMapping("/getData")
	public void getBankDetails(String consentId ) {
		
	}
	
}
