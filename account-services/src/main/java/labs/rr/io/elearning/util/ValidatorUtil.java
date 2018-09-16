package labs.rr.io.elearning.util;

import org.apache.commons.lang3.StringUtils;

import labs.rr.io.elearning.exception.ValidationException;

public final class ValidatorUtil {

	public static boolean isObjectNull(final Object object) throws ValidationException {
		if (object == null) {
			throw new ValidationException("Objeto esta nulo");
		}
		
		return true;
	}
	
	public static boolean isEmpty(final String object) throws ValidationException {
		isObjectNull(object);
		
		if (StringUtils.isBlank(object)) {
			throw new ValidationException("Objeto esta vazio");
		}
		
		return true;
	}
	
	public static boolean isObjectNull(final Object object, final String message) throws ValidationException {
		if (object == null) {
			throw new ValidationException(message);
		}
		
		return true;
	}
	
	public static boolean isEmpty(final String object, final String message) throws ValidationException {
		isObjectNull(object, message);
		
		if (StringUtils.isBlank(object)) {
			throw new ValidationException(message);
		}
		
		return true;
	}
}
