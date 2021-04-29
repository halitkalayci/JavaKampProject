package odev2;

public class InstructorManager extends UserManager{
	  public void Add(Instructor instructor) {
		  System.out.println("Instructor için iþ kodlarý çalýþtý : " + instructor.getName());
		  super.Add(instructor);
	  }
	  public void Remove(Instructor instructor) {
		  System.out.println("Instructor için iþ kodlarý çalýþtý : " + instructor.getName());
		  super.Remove(instructor);
	  }
}
