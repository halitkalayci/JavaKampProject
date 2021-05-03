
import java.util.Date;

import adapters.MernisServiceAdapter;
import classes.CustomerCheckManager;
import classes.NeroCustomerManager;
import classes.StarbuckCustomerManager;
import entities.Customer;
import interfaces.BaseCustomerManager;

public class Main {

	public static void main(String[] args) {
		Customer realCustomer = new Customer(1,"Halit Enes","Kalaycý","41192011504",new Date(2000,6,28));
		Customer fakeCustomer = new Customer(2,"Engin","Demiroð","12345678901",new Date(1989,2,11));
		
		BaseCustomerManager neroCustomerManager = new NeroCustomerManager(new CustomerCheckManager());
		neroCustomerManager.save(realCustomer);
		
		BaseCustomerManager starbucksCustomerManager = new StarbuckCustomerManager(new MernisServiceAdapter());
		starbucksCustomerManager.save(realCustomer);
		starbucksCustomerManager.save(fakeCustomer);
	}

}
