package labs.rr.io.elearning.repository.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import labs.rr.io.elearning.entity.Account;
import labs.rr.io.elearning.exception.CreateException;
import labs.rr.io.elearning.exception.FindException;
import labs.rr.io.elearning.repository.AccountRepository;

/**
 * Repositorio para acesso ao banco de dados da conta.
 * 
 * @author regis.rocha
 *
 */
@Repository
public class AccountRepositoryImpl implements AccountRepository {
	
	/**
	 * LOG
	 */
	private static final Logger LOG = Logger.getLogger(AccountRepositoryImpl.class);

	/**
	 * Persiste nova conta
	 * 
	 * @param account - Account
	 * 
	 * @return Account
	 */
	@Override
	public Account create(final Account account) throws CreateException {
		LOG.info("Creating account: " + account);
		
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * Consulta conta pelo Email
	 * 
	 * @param email - String
	 * 
	 * @return Account
	 * 
	 * @throws FindException
	 */
	@Override
	public Account findById(final String email) throws FindException {
		LOG.info("Finding account by email: " + email);
		
		// TODO Auto-generated method stub
		return null;
	}

}
