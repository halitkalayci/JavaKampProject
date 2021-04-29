package odev2;

public class UserManager {
  public void Add(User user) {
	  System.out.println("Kullanýcý eklendi : " + user.getName());
  }
  public void Remove(User user) {
	  System.out.println("Kullanýcý silindi : " + user.getName());
  }
}
