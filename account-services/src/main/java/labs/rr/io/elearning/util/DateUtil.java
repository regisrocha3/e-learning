package labs.rr.io.elearning.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * Utility class to manipulate information about date
 * 
 * @author regis.rocha
 *
 */
public class DateUtil {
	
	/**
	 * Pattern yyyy/MM/dd hh:mm:ss
	 */
	private static final String PATTERN_DATE_TIME = "yyyy/MM/dd kk:mm:ss"; 
	
	/**
	 * Pattern yyyy/MM/dd hh:mm:ss
	 */
	private static final String PATTERN_DATE_TIME_CALENDAR = "yyyy/MM/dd HH:mm:ss"; 
	
	/**
	 * Pattern yyyy/MM/dd
	 */
	private static final String PATTERN_DATE = "yyyy/MM/dd"; 
	
	
	/**
	 * Convert LocalDate date to String yyyy/MM/dd hh:mm:ss
	 * 
	 * @param date - LocalDateTime
	 * 
	 * @return String 
	 */
	public static String convertDateObjectToStringDateAndTime(final Calendar date) {
		if (date == null) {
			return "";
		}
		
		final DateFormat df = new SimpleDateFormat(PATTERN_DATE_TIME_CALENDAR);
		
		return df.format(date.getTime());
	}
	
	/**
	 * Convert LocalDate date to String yyyy/MM/dd
	 * 
	 * @param date - LocalDateTime
	 * 
	 * @return String 
	 */
	public static String convertDateObjectToStringDate(final Calendar date) {
		if (date == null) {
			return "";
		}
		
		final DateFormat df = new SimpleDateFormat(PATTERN_DATE);
		
		return df.format(date);
	}
	
	/**
	 * Convert LocalDate date to String yyyy/MM/dd hh:mm:ss
	 * 
	 * @param date - LocalDateTime
	 * 
	 * @return String 
	 */
	public static String convertDateObjectToStringDateAndTime(final LocalDateTime date) {
		if (date == null) {
			return "";
		}
		
		final DateTimeFormatter df = DateTimeFormatter.ofPattern(PATTERN_DATE_TIME);
		
		return df.format(date);
	}
	
	/**
	 * Convert LocalDate date to String yyyy/MM/dd
	 * 
	 * @param date - LocalDateTime
	 * 
	 * @return String 
	 */
	public static String convertDateObjectToStringDate(final LocalDate date) {
		if (date == null) {
			return "";
		}
		
		final DateTimeFormatter df = DateTimeFormatter.ofPattern(PATTERN_DATE);
		
		return df.format(date);
	}
	
	

	/**
	 * Converte data no formato yyyy/MM/dd para objeto do tipo Calendar
	 * 
	 * @param date - String
	 * 
	 * @return Calendar
	 * @throws ParseException 
	 */
	public static Calendar parseStringToDate(final String date) throws ParseException {
		final Date parsed = new SimpleDateFormat(PATTERN_DATE).parse(date);
		
		final Calendar calendar = Calendar.getInstance();
		
		calendar.setTime(parsed);
		
		return calendar;
	}
}
