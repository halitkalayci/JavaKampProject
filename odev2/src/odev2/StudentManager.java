package odev2;

public class StudentManager extends UserManager {
	public void Add(Student student) {
		  System.out.println("Student i�in i� kodlar� �al��t� : " + student.getName());
		  super.Add(student);
	  }
	  public void Remove(Student student) {
		  System.out.println("Student i�in i� kodlar� �al��t� : " + student.getName());
		  super.Remove(student);
	  }
	  public void RegisterToCourse(String course, Student student) {
		  System.out.println(student.getName() + " isimli ��renci "+ course + " isimli kursa kay�t oldu.");
	  }
}
