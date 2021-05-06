package eCommerceSimulation.business.concretes;

import eCommerceSimulation.business.abstracts.EmailService;
import eCommerceSimulation.business.abstracts.UserService;
import eCommerceSimulation.business.abstracts.UserValidationService;
import eCommerceSimulation.core.AuthService;
import eCommerceSimulation.core.utils.BusinessRules;
import eCommerceSimulation.entities.concretes.User;

public class AuthManager implements AuthService{

	UserService userService;
	UserValidationService userValidationService;
	EmailService emailService;
	
	
	public AuthManager(UserService userService, UserValidationService userValidationService, EmailService emailService) {
		super();
		this.userService = userService;
		this.userValidationService = userValidationService;
		this.emailService = emailService;
	}

	@Override
	public void register(int id, String email,String password,String firstName,String lastName) {
		User userToRegister = new User(id,email,password,firstName,lastName,false);
		
		if(!userValidationService.validate(userToRegister)) {
			System.out.println("Validasyon işlemi başarısız. Lütfen tüm alanları doğru girdiğinizden emin olunuz.");
			return;
		}
		
		if(!BusinessRules.run(checkIfUserExists(email))) {
			System.out.println("Kayıt olma işlemi başarısız. Bu email ile bir başka üye mevcut.");
			return;
		}
		
		System.out.println("Başarıyla kayıt olundu. Üyeliğinizi doğrulamak için lütfen e-posta adresinizi kontrol ediniz.");
		emailService.send("Deneme doğrulama mesajıdır. Doğrulamak için kodlama.io/dogrula?id=xyz&token=abc adresine gidin.", userToRegister.getEmail());
		userService.add(userToRegister);
	}

	@Override
	public void login(String email, String password) {
		if(!BusinessRules.run(checkIfAllFieldsFilled(email, password))) {
			System.out.println("Giriş başarısız. Inputlar doğru doldurulmadı.");
			return;
		}
		
		User userToLogin = userService.getByEmailAndPassword(email, password);
		
		if(userToLogin == null) {
			System.out.println("Giriş başarısız. E-posta adresiniz veya şifreniz yanlış.");
			return;
		}
		
		if(!checkIfUserVerified(userToLogin)) {
			System.out.println("Giriş başarısız. Üyeliğinizi doğrulamadınız.");
			return;
		}
		System.out.println("Giriş başarılı. Hoşgeldiniz : " + userToLogin.getFirstName() + " " + userToLogin.getLastName());
	}
	
	
	private boolean checkIfUserExists(String email) {
		return userService.getByEmail(email) == null;
	}
	private boolean checkIfUserVerified(User user) {
		return user.isVerified();
	}
	private boolean checkIfAllFieldsFilled(String email,String password) {
		if(email.length()<=0 || password.length() <=0) {
			return false;
		}
		return true;
	}
	

	
}
