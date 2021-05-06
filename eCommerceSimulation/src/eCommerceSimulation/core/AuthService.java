package eCommerceSimulation.core;

public interface AuthService {
       void register(int id, String email,String password,String firstName,String lastName);
       void login(String email, String password);
}
