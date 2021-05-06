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
			System.out.println("Validasyon iþlemi baþarýsýz. Lütfen tüm alanlarý doðru girdiðinizden emin olunuz.");
			return;
		}
		
		if(!BusinessRules.run(checkIfUserExists(email))) {
			System.out.println("Kayýt olma iþlemi baþarýsýz. Bu email ile bir baþka üye mevcut.");
			return;
		}
		
		System.out.println("Baþarýyla kayýt olundu. Üyeliðinizi doðrulamak için lütfen e-posta adresinizi kontrol ediniz.");
		emailService.send("Deneme doðrulama mesajýdýr. Doðrulamak için kodlama.io/dogrula?id=xyz&token=abc adresine gidin.", userToRegister.getEmail());
		userService.add(userToRegister);
	}

	@Override
	public void login(String email, String password) {
		if(!BusinessRules.run(checkIfAllFieldsFilled(email, password))) {
			System.out.println("Giriþ baþarýsýz. Inputlar doðru doldurulmadý.");
			return;
		}
		
		User userToLogin = userService.getByEmailAndPassword(email, password);
		
		if(userToLogin == null) {
			System.out.println("Giriþ baþarýsýz. E-posta adresiniz veya þifreniz yanlýþ.");
			return;
		}
		
		if(!checkIfUserVerified(userToLogin)) {
			System.out.println("Giriþ baþarýsýz. Üyeliðinizi doðrulamamýþsýnýz.");
			return;
		}
		System.out.println("Giriþ baþarýlý. Hoþgeldiniz " + userToLogin.getFirstName() + " " + userToLogin.getLastName());
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
