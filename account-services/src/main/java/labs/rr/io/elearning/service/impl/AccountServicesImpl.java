package labs.rr.io.elearning.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import labs.rr.io.elearning.entity.Account;
import labs.rr.io.elearning.exception.CreateException;
import labs.rr.io.elearning.exception.ValidationException;
import labs.rr.io.elearning.helper.AccountHelper;
import labs.rr.io.elearning.repository.AccountRepository;
import labs.rr.io.elearning.services.AccountServices;

/**
 * Account services
 * 
 * @author regis.rocha
 *
 */
@Service
public class AccountServicesImpl implements AccountServices {

	/**
	 * LOG
	 */
	private static final Logger LOG = Logger.getLogger(AccountServicesImpl.class);
	
	/**
	 * @Inject
	 */
	@Autowired
	private AccountRepository accountRepository;
	
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
	@Override
	public Account create(final Account account) throws CreateException, ValidationException {
		LOG.info("Criando conta: " + account);
		
		this.validateForCreate(account);
		
		try {
			final Account accFound = this.accountRepository.findById(account.getEmail());
			
			if (accFound != null) {
				throw new ValidationException("Ja existe uma conta com o email informado: " + accFound.getEmail());
			}
			
			return this.accountRepository.create(account);
		} catch (Exception e) {
			LOG.error("", e);
			throw new CreateException(e);
		}
	}

	
	/**
	 * valida as informacoes obrigatorias para criacao da conta.
	 * 
	 * @param account - Account
	 * 
	 * @throws ValidationException
	 */
	private void validateForCreate(final Account account) throws ValidationException {
		AccountHelper.validateForCreate(account);
	}
}
