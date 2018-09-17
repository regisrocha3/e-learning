package labs.rr.io.elearning.exception;

/**
 * Exception when error occur in find action
 * 
 * @author regis.rocha
 *
 */
public class FindException extends Exception {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = 5415832350050405934L;

	/**
	 * Constructor 
	 * 
	 * @param message - String
	 */
	public FindException(final String message) {
		super(message);
	}
	
	/**
	 * Constructor
	 * 
	 * @param message	- String
	 * 
	 * @param cause 	- Throwable
	 */
	public FindException(final String message, final Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * Constructor
	 * 
	 * @param cause - Throwable
	 */
	public FindException(final Throwable cause) {
		super(cause);
	}
}
