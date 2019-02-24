package nl.pratik.rest.spring.model;

public class Student {
	
	private String firstName;
	private String lastname;
	
	public Student(String firstName, String lastname) {
		super();
		this.firstName = firstName;
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastname=" + lastname + "]";
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	

}
