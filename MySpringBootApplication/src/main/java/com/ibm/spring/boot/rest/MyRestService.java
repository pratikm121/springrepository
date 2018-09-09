package com.ibm.spring.boot.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.spring.boot.model.Contacts;

@RestController
@RequestMapping("/Users/")
public class MyRestService {
	
	private final String GET_ALL_QUERY = "SELECT ID,NAME,MOBILE,MOBILE_2,HOME,OFFICE,EMAIL,HOME_ADDRESS,OFFICE_ADDRESS,CRTTMST FROM CONTACTS";
	
	@Autowired
	JdbcTemplate jdbcTemplate;   
	
    @GetMapping(path="/all")
	public @ResponseBody Iterable<Contacts> getAllUsers() {
		System.out.println("Got it");
		Iterable<Contacts> myList = jdbcTemplate.query(GET_ALL_QUERY,
				(rs, rowNum) -> new Contacts(rs.getBigDecimal("ID"), rs.getString("NAME"),
						rs.getString("EMAIL"), rs.getString("HOME_ADDRESS"), rs.getString("OFFICE_ADDRESS"), rs.getTimestamp("CRTTMST"),rs.getBigDecimal("MOBILE"), 
						rs.getBigDecimal("MOBILE_2"), rs.getBigDecimal("HOME"), rs.getBigDecimal("OFFICE")));
	
		for(Contacts contact:myList) {
			System.out.println(contact.toString());
		}
		
		
		return myList;
	}

}
