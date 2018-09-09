package com.ibm.spring.boot.rest;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.spring.boot.model.Contacts;

@RestController
@RequestMapping("/Users/")
public class MyRestService {
	
	private final String GET_ALL_QUERY = "SELECT ID,NAME,MOBILE,MOBILE_2,HOME,OFFICE,EMAIL,HOME_ADDRESS,OFFICE_ADDRESS,CRTTMST FROM CONTACTS";
	private final String INSERT_CONTACT = "INSERT INTO CONTACTS (NAME,MOBILE,MOBILE_2,HOME,OFFICE,EMAIL,HOME_ADDRESS,OFFICE_ADDRESS) VALUES (?,?,?,?,?,?,?,?);";
	//private final String UPDATE_CONTCT = "UPDATE CONTACTS";
	
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
    
    @PostMapping(path="/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
	public @ResponseBody String getById(@RequestBody Contacts contact) {
		System.out.println("Got "+contact.getName());
		int count = jdbcTemplate.update(INSERT_CONTACT, new Object[] { contact.getName(),contact.getMobile(),contact.getMobile_2(),contact.getHome(),contact.getOffice(),
												contact.getEmail(),contact.getHomeAddress(),contact.getOfficeAddress()});
		if(count >0) {
			return "Contact Updated Successfully";
		}else {
			return "Contact not Updated !!";
		}
	}
    
    @PostMapping(path="/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
	public @ResponseBody String updateContacts(@RequestBody Contacts contact) {
		System.out.println("Got "+contact.getName());
		int count = jdbcTemplate.update(INSERT_CONTACT, new Object[] { contact.getName(),contact.getMobile(),contact.getMobile_2(),contact.getHome(),contact.getOffice(),
												contact.getEmail(),contact.getHomeAddress(),contact.getOfficeAddress()});
		if(count >0) {
			return "Contact Updated Successfully";
		}else {
			return "Contact not Updated !!";
		}
	}

}
