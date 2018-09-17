package labs.rr.io.elearning.repository;

import org.springframework.data.repository.CrudRepository;

import labs.rr.io.elearning.entity.Account;
import labs.rr.io.elearning.exception.CreateException;

/**
 * Interface para acesso ao banco de dados da conta.
 * 
 * @author regis.rocha
 *
 */
public interface AccountRepository extends CrudRepository<Account, String> {

	/**
	 * Persiste nova conta
	 * 
	 * @param account - Account
	 * 
	 * @return Account
	 */
	Account create(Account account) throws CreateException;

}
