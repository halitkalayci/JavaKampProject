package eCommerceSimulation.googleAuth;

public class GoogleAuthManager {
     public void register(String email,String password) {
    	 //Google kodlarý, geri dönüþler vs gerçek kodlara göre ele alýnabilir. Þimdilik her þartta kayýt alýndý döndürelim.
    	 System.out.println("Google ile kayýt alýndý :" + email);
     }
     public void login(String email,String password) {
    	 System.out.println("Google ile giriþ yapýldý : " + email);
     }
}
