package nl.pratik.rest.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.pratik.rest.spring.exception.DataNotFoundException;
import nl.pratik.rest.spring.model.Student;

//http://localhost:8080/SpringRestApplication/api/
@RestController
@RequestMapping("/api")
public class StudentRestController {
	private List<Student> studentList;
	
	@PostConstruct
	public void populateData() {
		studentList = new ArrayList<Student>();		
		studentList.add(new Student("Pratik", "Mehta"));
		studentList.add(new Student("Manvi", "Mehta"));
		studentList.add(new Student("Nishank", "Mehta"));
		studentList.add(new Student("Abhishikha", "Mehta"));
	}
	
	//http://localhost:8080/SpringRestApplication/api/students
	@GetMapping("/students")
	public List<Student> getStudents() {
		System.out.println("/api/students");		
		return studentList;
	}
	
	//http://localhost:8080/SpringRestApplication/api/students/{id}
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		System.out.println("/api/students/{id}");		
		if(studentId >= studentList.size() || studentId <0) {
			throw new DataNotFoundException("Student Id not found -" + studentId);
		}else {
			return studentList.get(studentId); 
		}		
	}
	
	

}
