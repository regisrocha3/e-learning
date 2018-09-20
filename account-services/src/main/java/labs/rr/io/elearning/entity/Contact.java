package labs.rr.io.elearning.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Table Contact
 * 
 * @author regis.rocha
 *
 */
//@Entity
//@Table(name = "contact")
public class Contact implements Serializable {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = 3026697457012921080L;

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "ddi_code")
	private String ddiCode;

	@Column(name = "ddd_code")
	private String dddCode;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "description")
	private String description;

	@Column(name = "secondary_email")
	private String secondaryEmail;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the ddiCode
	 */
	public String getDdiCode() {
		return ddiCode;
	}

	/**
	 * @param ddiCode the ddiCode to set
	 */
	public void setDdiCode(String ddiCode) {
		this.ddiCode = ddiCode;
	}

	/**
	 * @return the dddCode
	 */
	public String getDddCode() {
		return dddCode;
	}

	/**
	 * @param dddCode the dddCode to set
	 */
	public void setDddCode(String dddCode) {
		this.dddCode = dddCode;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the secondaryEmail
	 */
	public String getSecondaryEmail() {
		return secondaryEmail;
	}

	/**
	 * @param secondaryEmail the secondaryEmail to set
	 */
	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Contact [id=" + id + ", ddiCode=" + ddiCode + ", dddCode=" + dddCode + ", phoneNumber=" + phoneNumber
				+ ", description=" + description + ", secondaryEmail=" + secondaryEmail + "]";
	}
}
