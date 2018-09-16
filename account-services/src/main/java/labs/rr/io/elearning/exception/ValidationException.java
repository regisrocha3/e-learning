package labs.rr.io.elearning.exception;

public class ValidationException extends RuntimeException {
	
	/**
	 * serial version
	 */
	private static final long serialVersionUID = -3034901509898360350L;

	/**
	 * @param message - String
	 */
	public ValidationException(String message) {
		super(message);
	}
	
	/**
	 * 
	 * @param message
	 * @param cause
	 */
	public ValidationException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
