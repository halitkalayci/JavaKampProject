package interfaces;

import entities.Customer;

public class BaseCustomerManager implements CustomerService {

	@Override
	public void save(Customer customer) {
		System.out.println("Customer succesfully added to database.");
	}

}
