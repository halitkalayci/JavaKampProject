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
		authService.register(1, "halitenes.kalayci@gmail.com", "123halit1234", "Halit Enes", "Kalaycı"); // Başarılı
		authService.register(2, "bubirepostadeðil..", "þifrevalid", "Halit Enes", "Kalaycı"); // Başarısız eposta invalid
		authService.register(3, "bubireposta@gmail.com", "s", "Halit Enes", "Kalaycı"); // Başarısız şifre invalid
		authService.register(4, "bubireposta@gmail.com", "s", "H", "K"); // Başarısız ad-soyad invalid
		authService.register(5, "halitenes.kalayci@gmail.com", "123halit1234", "Halit Enes", "Kalaycı"); // Başarısız e-posta mevcut


		authService.login("halitenes.kalayci@gmail.com", "123halit1234"); // Başarşsşz üye doşrulama yapmamşş.
		userService.verifyUser(1); // Kullanşcşyş doşrulayalşm.
		authService.login("halitenes.kalayci@gmail.com", "123halit123"); // Başarısız şifre yanlış.
		authService.login("halitenes.kalayci@gmail.com", "123halit1234"); // Başarşlş.
		authService.login("", ""); // Başarşsşz e-posta parola zorunlu

		authService.login("halitenes.kalayci@gmail.com", "123halit1234"); // Başarısız üye doğrulama yapmamış.
		userService.verifyUser(1); // Kullanıcıyı doğrulayalım.
		authService.login("halitenes.kalayci@gmail.com", "123halit123"); // Başarısız şifre yanlış.
		authService.login("halitenes.kalayci@gmail.com", "123halit1234"); // Başarılı.
		authService.login("", ""); // Başarısız e-posta parola zorunlu

		
		AuthService googleAuthService = new GoogleAuthManagerAdapter();
		googleAuthService.register(6, "klyyc7@gmail.com", "123halit1234", "Halit Enes", "Kalaycı");
		googleAuthService.login("klyyc7@gmail.com", "123halit1234");
		
		
	}

}
