package com.example.niti.backend.niti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;


import com.example.niti.backend.niti.model.AccountDetailsModel;
import com.example.niti.backend.niti.model.DataSessionModel;
import com.example.niti.backend.niti.model.PostModelRecieved;




@Service 
public class AllServiceImpl implements AllService {
	
	@Value("${external.api.url}")
	private String postApiBaseUrl ;  
	
	@Autowired
	private RestTemplate restTemplate ;
	
	
	@Override
	public PostModelRecieved getConsent(String id) {
		HttpHeaders headers = new HttpHeaders() ; 
		  
		headers.add("x-client-id", "255d0b6c-492d-44cf-8581-e9494c7b0914");
		headers.add("x-client-secret", "9c2fc756-3d17-46d6-b28d-be4d71953e83");
		HttpEntity<Object> httpEntity = new HttpEntity<>(headers) ;
		ResponseEntity<PostModelRecieved> re = restTemplate.exchange("https://fiu-uat.setu.co/consents/" + id , HttpMethod.GET, httpEntity, PostModelRecieved.class) ;
		PostModelRecieved pmr = re.getBody() ;
	
		return pmr ;
	}

	@Override
	public DataSessionModel createDataSession() {
			DataSessionModel DSM = null ;
			HttpHeaders headers = new HttpHeaders() ; 
			  
			headers.add("x-client-id", "255d0b6c-492d-44cf-8581-e9494c7b0914");
			headers.add("x-client-secret", "9c2fc756-3d17-46d6-b28d-be4d71953e83");
			HttpEntity<Object> httpEntity = new HttpEntity<>(headers) ;
			ResponseEntity<DataSessionModel> re = restTemplate.exchange("https://fiu-uat.setu.co/sessions/", HttpMethod.POST, httpEntity, DataSessionModel.class  ) ;
			ResponseEntity<DataSessionModel> newDsmEntity = restTemplate.postForEntity("https://fiu-uat.setu.co/sessions/",httpEntity, DataSessionModel.class ) ;
			if(newDsmEntity.getStatusCode() == HttpStatus.CREATED) {
				DSM = newDsmEntity.getBody() ;
			}
			
			
			
			return re.getBody() ;
			}
	
	
	@Override
	public String getData(String id) {
		HttpHeaders headers = new HttpHeaders() ; 
		  
		headers.add("x-client-id", "255d0b6c-492d-44cf-8581-e9494c7b0914");
		headers.add("x-client-secret", "9c2fc756-3d17-46d6-b28d-be4d71953e83");
		HttpEntity<Object> httpEntity = new HttpEntity<>(headers) ;
		ResponseEntity<AccountDetailsModel> re = restTemplate.exchange("https://fiu-uat.setu.co/consents/sessions/" + id , HttpMethod.GET, httpEntity, AccountDetailsModel.class  ) ;
		AccountDetailsModel adm = re.getBody() ;
		
		System.out.println(adm.toString());
		
		return adm.toString() ;
		
	}
	

	
	

}
