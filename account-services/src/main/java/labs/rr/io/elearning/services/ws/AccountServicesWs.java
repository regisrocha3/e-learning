package labs.rr.io.elearning.services.ws;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import labs.rr.io.elearning.data.Response;
import labs.rr.io.elearning.entity.Account;
import labs.rr.io.elearning.exception.ValidationException;
import labs.rr.io.elearning.helper.AccountHelper;
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
	public ResponseEntity<Response<AccountResponse>> create(@RequestBody final AccountRequest accountRequest) {
		LOG.info("create account: " + accountRequest);
		
		try {
			final Account acc = this.accountServices.create(AccountHelper.convertToEntity(accountRequest));
			
			return ResponseEntity.status(HttpStatus.CREATED).body(new Response<AccountResponse>()
					.addBusinessMessage(AccountHelper.convertToResponse(acc))
					.addBusinessCode(HttpStatus.CREATED.value()));
			
		} catch (ValidationException e) {
			LOG.warn(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response<AccountResponse>()
					.addBusinessMessage(e.getMessage()).addBusinessCode(HttpStatus.BAD_REQUEST.value()));
			
		} catch (Exception e) {
			LOG.error("",e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new Response<AccountResponse>().createErrorResponse()
					.addBusinessCode(HttpStatus.INTERNAL_SERVER_ERROR.value()));
		}
	}
}
