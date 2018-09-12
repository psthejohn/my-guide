package com.stackroute.foodieapi.rs.service;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.stackroute.foodieapi.service.zomato.model.cities.Cities;

@RunWith(PowerMockRunner.class)
@PrepareForTest(CitiesResourceTest.class)
public class CitiesResourceTest {
	
	RestTemplate restTemplate=null;
	HttpHeaders headers=null;
	String theURL;
	
	@Before
	public void before() {
		 restTemplate = PowerMockito.mock(RestTemplate.class);
		 headers=PowerMockito.mock(HttpHeaders.class);
		 headers.add(("user-key"), "19033159114c0a22991ed9372507ea68");
		 theURL="https://developers.zomato.com/api/v2.1/cities\" + \"?q=\"";
	}

	@Test
	public final void testGetAllCities() {
		PowerMockito.when(headers.getContentType()).thenReturn(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>("parameters",
				headers);
		ResponseEntity<Cities> response =null;
	 
		    PowerMockito.when(restTemplate.exchange(
		    		theURL, HttpMethod.GET, entity, Cities.class
		         )).thenReturn(response);
		        		 
		        		 
		        		 
		        		 
		        		 
		        		 
		        		 
		        		 
		        		 
		        		 

}
	
}
