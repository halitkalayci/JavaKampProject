package entities;

import java.util.Date;

// TO DO : Classý çýplak býrakma!
public class Customer {
	 private int customerId;
     private String firstName;
     private String lastName;
     private String tckn;
     private Date dateOfBirth;
     public Customer() {
     }
	public Customer(int customerId, String firstName, String lastName, String tckn, Date dateOfBirth) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.tckn = tckn;
		this.dateOfBirth = dateOfBirth;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTckn() {
		return tckn;
	}
	public void setTckn(String tckn) {
		this.tckn = tckn;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
     

}
