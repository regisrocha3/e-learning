package labs.rr.io.elearning.services;

import labs.rr.io.elearning.entity.Account;
import labs.rr.io.elearning.exception.CreateException;
import labs.rr.io.elearning.exception.ValidationException;

/**
 * Account services
 * 
 * @author regis.rocha
 *
 */
public interface AccountServices {

	/**
	 * Cria nova conta
	 * 
	 * @param account - Account 
	 * 
	 * @return Account
	 * 
	 * @throws CreateException
	 * @throws ValidationException
	 */
	Account create(Account account) throws CreateException, ValidationException;
	
}
