package eCommerceSimulation.entities.concretes;

import eCommerceSimulation.entities.abstracts.Entity;

public class User implements Entity{
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private boolean verified;
    
    public User() {
	}

	public User(int id, String email, String password, String firstName, String lastName,boolean verified) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.verified=verified;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	
	
    
    
}
