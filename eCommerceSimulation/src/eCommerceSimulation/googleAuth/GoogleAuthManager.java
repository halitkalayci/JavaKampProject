package eCommerceSimulation.googleAuth;

public class GoogleAuthManager {
     public void register(String email,String password) {
    	 //Google kodları, geri dönüşler vs gerçek kodlara göre ele alınabilir. Şimdilik her şartta kayıt alındı döndürelim.
    	 System.out.println("Google ile kayıt alındı :" + email);
     }
     public void login(String email,String password) {
    	 System.out.println("Google ile giriş yapıldı : " + email);
     }
}
