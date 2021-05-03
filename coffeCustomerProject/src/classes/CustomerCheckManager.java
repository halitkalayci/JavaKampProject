package classes;

import entities.Customer;
import interfaces.CustomerCheckService;

public class CustomerCheckManager implements CustomerCheckService{

	@Override
	public boolean CheckPerson(Customer customer) {
		return true;
	}

}
