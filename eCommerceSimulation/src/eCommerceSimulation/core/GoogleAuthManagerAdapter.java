package eCommerceSimulation.core;
import eCommerceSimulation.googleAuth.GoogleAuthManager;

public class GoogleAuthManagerAdapter implements AuthService {

	@Override
	public void register(int id, String email,String password,String firstName,String lastName) {
		GoogleAuthManager googleAuthManager = new GoogleAuthManager();
		googleAuthManager.register(email,password);
	}

	@Override
	public void login(String email, String password) {
		GoogleAuthManager googleAuthManager = new GoogleAuthManager();
		googleAuthManager.login(email,password);
	}

}
