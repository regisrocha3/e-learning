package labs.rr.io.elearning.services.ws;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import labs.rr.io.elearning.request.AccountRequest;
import labs.rr.io.elearning.response.AccountResponse;
import labs.rr.io.elearning.services.AccountServices;

/**
 * 
 * @author regis.rocha
 *
 */
@RestController("/api/account")
public class AccountServicesWs {
	
	/**
	 * LOG
	 */
	private static final Logger LOG = Logger.getLogger(AccountServicesWs.class);
	
	/**
	 * @Inject
	 */
	@Autowired
	private AccountServices accountServices;

	/**
	 * Servico para realizar a criacao da conta
	 * 
	 * @param AccountRequest
	 * 
	 * @return ResponseEntity<AccountResponse>
	 * 
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<AccountResponse> create(@RequestBody final AccountRequest accountRequest) {
		LOG.info("create account: " + accountRequest);
		
		final ResponseEntity<AccountResponse> res = new ResponseEntity<>();
		
		try {
			this.accountServices.create(AccountHelper.convertToEntity(accountRequest));
		}
		
		return res;
	}
}
