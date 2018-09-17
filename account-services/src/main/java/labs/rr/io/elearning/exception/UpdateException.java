
package labs.rr.io.elearning.exception;

/**
 * Exception will be throw when error occur in update action.
 * 
 * @author regis.rocha
 *
 */
public class UpdateException extends Exception {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = -8979851783587616854L;

	/**
	 * Constructor 
	 * 
	 * @param message - String
	 */
	public UpdateException(final String message) {
		super(message);
	}
	
	/**
	 * Constructor
	 * 
	 * @param message	- String
	 * 
	 * @param cause 	- Throwable
	 */
	public UpdateException(final String message, final Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * Constructor
	 * 
	 * @param cause - Throwable
	 */
	public UpdateException(final Throwable cause) {
		super(cause);
	}
	
}
