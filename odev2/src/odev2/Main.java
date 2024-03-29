package odev2;

public class Main {

	public static void main(String[] args) {
		UserManager userManager = new UserManager();
		User user = new User();
		user.setId(1);
		user.setAvatarPath("www.resimyolu.com");
		user.setName("Halit Enes");
		user.setSurname("Kalayc�");
		userManager.Add(user);
		userManager.Remove(user);
		
		InstructorManager instructorManager = new InstructorManager();
		Instructor instructor = new Instructor();
		instructor.setId(1);
		instructor.setAvatarPath("www.resimyolu.com");
		instructor.setBiography("MCT PMP VE ITIL.... :D :D");
		instructor.setCourses(new String[]{"java","c#"});
		instructor.setName("Engin");
		instructor.setSurname("Demiro�");
		instructorManager.Add(instructor);
		instructorManager.Create(instructor, "Java");
		instructorManager.Remove(instructor);

		StudentManager studentManager = new StudentManager();
		Student student = new Student();
		student.setId(1);
		student.setAvatarPath("www.resimyolu.com");
		student.setCertificates(new String[] {"C#","Java"});
		student.setComments(new String[] {"M�thi�!","S�per!"});
		student.setName("Halit Enes");
		student.setSurname("Kalayc�");
		studentManager.Add(student);
		studentManager.RegisterToCourse("Java", student);
		studentManager.Remove(student);
	}

}
