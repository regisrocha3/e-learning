package labs.rr.io.elearning.services.ws;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
	 * 
	 */
	@PostMapping
	public void create() {
		LOG.info("create");
	}
	
}
