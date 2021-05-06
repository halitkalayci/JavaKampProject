package eCommerceSimulation;

import eCommerceSimulation.business.abstracts.UserService;
import eCommerceSimulation.business.concretes.AuthManager;
import eCommerceSimulation.business.concretes.EmailManager;
import eCommerceSimulation.business.concretes.UserManager;
import eCommerceSimulation.business.concretes.UserValidationManager;
import eCommerceSimulation.core.AuthService;
import eCommerceSimulation.core.GoogleAuthManagerAdapter;
import eCommerceSimulation.dataAccess.concretes.InMemoryUserDao;

public class Main {

	public static void main(String[] args) {
		
		
		UserService userService = new UserManager(new InMemoryUserDao());
		AuthService authService = new AuthManager(userService, new UserValidationManager(), new EmailManager());
		authService.register(1, "halitenes.kalayci@gmail.com", "123halit1234", "Halit Enes", "Kalaycý"); // Baþarýlý
		authService.register(2, "bubirepostadeðil..", "þifrevalid", "Halit Enes", "Kalaycý"); // Baþarýsýz eposta invalid
		authService.register(3, "bubireposta@gmail.com", "s", "Halit Enes", "Kalaycý"); // Baþarýsýz þifre invalid
		authService.register(4, "bubireposta@gmail.com", "s", "H", "K"); // Baþarýsýz ad-soyad invalid
		authService.register(5, "halitenes.kalayci@gmail.com", "123halit1234", "Halit Enes", "Kalaycý"); // Baþarýsýz e-posta mevcut

		authService.login("halitenes.kalayci@gmail.com", "123halit1234"); // Baþarýsýz üye doðrulama yapmamýþ.
		userService.verifyUser(1); // Kullanýcýyý doðrulayalým.
		authService.login("halitenes.kalayci@gmail.com", "123halit123"); // Baþarýsýz þifre yanlýþ.
		authService.login("halitenes.kalayci@gmail.com", "123halit1234"); // Baþarýlý.
		authService.login("", ""); // Baþarýsýz e-posta parola zorunlu
		
		AuthService googleAuthService = new GoogleAuthManagerAdapter();
		googleAuthService.register(6, "klyyc7@gmail.com", "123halit1234", "Halit Enes", "Kalaycý");
		googleAuthService.login("klyyc7@gmail.com", "123halit1234");
		
		
	}

}
