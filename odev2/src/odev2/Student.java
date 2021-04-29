package odev2;

public class Student extends User {
    private String[] certificates;
    private String[] comments;
	public String[] getCertificates() {
		return certificates;
	}
	public void setCertificates(String[] certificates) {
		this.certificates = certificates;
	}
	public String[] getComments() {
		return comments;
	}
	public void setComments(String[] comments) {
		this.comments = comments;
	}
    
}
