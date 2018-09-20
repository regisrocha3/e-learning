package labs.rr.io.elearning.repository;

import labs.rr.io.elearning.entity.Account;
import labs.rr.io.elearning.exception.CreateException;
import labs.rr.io.elearning.exception.FindException;

/**
 * Interface para acesso ao banco de dados da conta.
 * 
 * @author regis.rocha
 *
 */
public interface AccountRepository {

	/**
	 * Persiste nova conta
	 * 
	 * @param account - Account
	 * 
	 * @return Account
	 */
	Account create(Account account) throws CreateException;

	
	/**
	 * Consulta conta pelo Email
	 * 
	 * @param email - String
	 * 
	 * @return Account
	 * 
	 * @throws FindException
	 */
	Account findById(String email) throws FindException;

}
