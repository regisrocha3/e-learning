package labs.rr.io.elearning.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	 * @Inject
	 */
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Persiste nova conta
	 * 
	 * @param account - Account
	 * 
	 * @return Account
	 */
	@Override
	public Account create(final Account account) throws CreateException {
		try {
			return this.entityManager.merge(account);
			
		} catch (Exception e) {
			throw new CreateException(e);
		}
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
		try {
			return this.entityManager.createNamedQuery("Account.findById", Account.class).setParameter("email", email)
					.getSingleResult();
			
		} catch (Exception e) {
			throw new FindException(e);
		}
	}
}
