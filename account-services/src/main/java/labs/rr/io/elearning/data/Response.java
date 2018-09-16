package labs.rr.io.elearning.data;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class that encapsulates the default response.
 * 
 * @author regis.rocha
 *
 */
@XmlRootElement(name = "response")
public final class Response<BodyType> implements Serializable {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = 3118689620114658552L;

	private String generalMessage;

	private BodyType reponseBody;
	
	private Collection<BodyType> collectionBody;
	
	private int businessCode;
	
	private String businessMessage;

	/**
	 * @return the generalMessage
	 */
	@JsonProperty("message")
	public String getGeneralMessage() {
		if (StringUtils.isBlank(this.generalMessage)) {
			this.generalMessage = "";
		}
		
		return generalMessage;
	}

	/**
	 * @return the reponseBody
	 */
	@JsonProperty("body-attribute")
	public BodyType getReponseBody() {
		return reponseBody;
	}
	

	/**
	 * @return the collectionBody
	 */
	@JsonProperty("body-collection-attributes")
	public Collection<BodyType> getCollectionBody() {
		if (this.collectionBody == null) {
			this.collectionBody = Collections.emptyList();
		}
		
		return collectionBody;
	}
	
	
	/**
	 * @return the businessCode
	 */
	@JsonProperty("business-code")
	public int getBusinessCode() {
		return businessCode;
	}

	/**
	 * @return the businessMessage
	 */
	@JsonProperty("business-message")
	public String getBusinessMessage() {
		return businessMessage;
	}

	/**
	 * Create object that represents the success response.
	 * 
	 * Success response return 
	 * 	. HTTP Status 		- OK 
	 *  . general Message 	- OK 
	 *  . reponseBody 		- empty
	 * 
	 * @return Response<T>
	 */
	public Response<BodyType> createSuccessResponse() {
		// message OK
		this.generalMessage = HttpStatus.OK.getReasonPhrase();

		return this;
	}
	
	/**
	 * Create object that represents the internal Bad Request response.
	 * 
	 * Success response return 
	 * 	. HTTP Status 		- BAD_REQUEST 
	 *  . general Message 	- Bad Request 
	 *  . reponseBody 		- empty
	 * 
	 * @return Response<T>
	 */
	public Response<BodyType> createValidationErrorResponse() {
		// message INTERNAL_SERVER_ERROR
		this.generalMessage = HttpStatus.BAD_REQUEST.getReasonPhrase();

		return this;
	}

	
	/**
	 * Create object that represents the NOT_FOUND response.
	 * 
	 * Success response return 
	 * 	. HTTP Status 		- NOT_FOUND 
	 *  . general Message 	- not found 
	 *  . reponseBody 		- empty
	 * 
	 * @return Response<T>
	 */
	public Response<BodyType> createNotFoundResponse() {
		// message OK
		this.generalMessage = HttpStatus.NOT_FOUND.getReasonPhrase();

		return this;
	}
	
	
	/**
	 * Create object that represents the internal server error response.
	 * 
	 * Success response return 
	 * 	. HTTP Status 		- INTERNAL_SERVER_ERROR 
	 *  . general Message 	- Internal Server Error 
	 *  . reponseBody 		- empty
	 * 
	 * @return Response<T>
	 */
	public Response<BodyType> createErrorResponse() {
		// message INTERNAL_SERVER_ERROR
		this.generalMessage = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();

		return this;
	}

	
	/**
	 * Create object that represents no content.
	 * 
	 * Success response return 
	 * 	. HTTP Status 		- NO_CONTENT 
	 *  . general Message 	- No Content
	 *  . reponseBody 		- empty
	 * 
	 * @return Response<T>
	 */
	public Response<BodyType> createEmptyResponse() {
		// message No Content
		this.generalMessage = HttpStatus.NO_CONTENT.getReasonPhrase();

		return this;
	}
	
	/**
	 * Create object that represents created.
	 * 
	 * Success response return 
	 * 	. HTTP Status 		- CREATED 
	 *  . general Message 	- created
	 *  . reponseBody 		- empty
	 * 
	 * @return Response<T>
	 */
	public Response<BodyType> createResponse() {
		// message No Content
		this.generalMessage = HttpStatus.CREATED.getReasonPhrase();

		return this;
	}
	
	
	/**
	 * Add message.
	 * 
	 * @param message - String
	 * 
	 * @return Response<T>
	 */
	public Response<BodyType> addGeneralMessage(final String message) {
		this.generalMessage = message;
		return this;
	}
	
	/**
	 * Add message.
	 * 
	 * @param message - String
	 * 
	 * @return Response<T>
	 */
	public Response<BodyType> addBusinessMessage(final String message) {
		this.businessMessage = message;
		return this;
	}
	
	/**
	 * Add code.
	 * 
	 * @param int - code
	 * 
	 * @return Response<T>
	 */
	public Response<BodyType> addBusinessCode(final int code) {
		this.businessCode = code;
		return this;
	}
	
	/**
	 * Add code and message.
	 * 
	 * @param int 		- code
	 * @param message 	- String
	 * 
	 * @return Response<T>
	 */
	public Response<BodyType> addBusinessCodeAndMessage(final int code, final String message) {
		this.businessCode = code;
		this.businessMessage = message;
		return this;
	}
	
	
	/**
	 * Add body in a single attribute.
	 * 
	 * @param body - BodyType
	 * 
	 * @return Response<T>
	 */
	public Response<BodyType> addBody(final BodyType body) {
		this.reponseBody = body;
		
		return this;
	}
	
	/**
	 * Add collection body.
	 * 
	 * @param pCollectionBody - Collection<BodyType>
	 * 
	 * @return Response<T>
	 */
	public Response<BodyType> addCollectionBody(final Collection<BodyType> pCollectionBody) {
		if (this.collectionBody == null) {
			this.collectionBody = pCollectionBody;
			
			return this;
		}
		
		this.collectionBody.addAll(pCollectionBody);
		
		return this;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Response [generalMessage=" + generalMessage + ", reponseBody=" + reponseBody + ", collectionBody="
				+ collectionBody + ", businessCode=" + businessCode + ", businessMessage=" + businessMessage + "]";
	}
}
