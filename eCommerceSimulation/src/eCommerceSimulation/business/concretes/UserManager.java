package eCommerceSimulation.business.concretes;

import java.util.List;

import eCommerceSimulation.business.abstracts.UserService;
import eCommerceSimulation.dataAccess.abstracts.UserDao;
import eCommerceSimulation.entities.concretes.User;

public class UserManager implements UserService{

	private UserDao userDao;
 

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}


	@Override
	public void add(User user) {
		userDao.add(user);
	}


	@Override
	public void remove(User user) {
		userDao.remove(user);
	}


	@Override
	public void update(User user) {
		userDao.update(user);
	}


	@Override
	public User get(int id) {
		return userDao.get(id);
	}


	@Override
	public User getByEmail(String email) {
		return userDao.getByEmail(email);
	}


	@Override
	public User getByEmailAndPassword(String email, String password) {
		return userDao.getByEmailAndPassword(email, password);
	}


	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}


	@Override
	public void verifyUser(User user) {
		System.out.println("Kullanýcý baþarýyla doðrulandý..");
		user.setVerified(true);
	}
 
}
