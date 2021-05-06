package eCommerceSimulation.business.abstracts;

import eCommerceSimulation.entities.concretes.User;

public interface UserValidationService {
    boolean validate(User user);
}
