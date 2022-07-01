package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class JiokycController {
	@Autowired
	JiokycService ser;
	@Autowired
	RestTemplate restTemp;
	@PostMapping(value="/jio_customer_kyc")
	public String add(@RequestBody Jiokyc a) {
		String url="http://localhost:8080/get_details_Adhar_number/";
		String k=a.getAdhar_number();
		ResponseEntity<Jiokyc> l=restTemp.exchange(url+k, HttpMethod.GET, null, Jiokyc.class);
		Jiokyc j=l.getBody();
		a.setAddress(j.getAddress());
		a.setAdhar_number(j.getAdhar_number());
		a.setDob(j.getDob());
		a.setFather_name(j.getFather_name());
		a.setGender(j.getGender());
		a.setName(j.getName());
		return ser.add(a);
		}
	@Autowired
	RestTemplate restTemplist;
	@PostMapping(value="/jio_customer_kyc_list")
	public String addlist(@RequestBody List<Jiokyc> j) {
		String url1="http://localhost:8080/get_details/";
		j.forEach(x->{
			String k=x.getAdhar_number();
			ResponseEntity<List<Jio>>l=restTemplist.exchange(url1+k, HttpMethod.GET, null,new ParameterizedTypeReference<List<Jio>>(){});
			List<Jio> users=l.getBody();
		});
		return ser.addlist(j);
		
		
	}
}
