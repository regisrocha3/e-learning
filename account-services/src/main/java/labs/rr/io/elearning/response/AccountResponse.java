package labs.rr.io.elearning.response;

import java.io.Serializable;
import java.util.Set;

/**
 * Request Account
 * 
 * 
 * @author regis.rocha
 *
 */
public class AccountResponse implements Serializable {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = 5459966318518103003L;

	private String email;

	private String password;

	private Set<ContactResponse> contacts;

	private ProfileResponse profile;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the contacts
	 */
	public Set<ContactResponse> getContacts() {
		return contacts;
	}

	/**
	 * @param contacts the contacts to set
	 */
	public void setContacts(Set<ContactResponse> contacts) {
		this.contacts = contacts;
	}

	/**
	 * @return the profile
	 */
	public ProfileResponse getProfile() {
		return profile;
	}

	/**
	 * @param profile the profile to set
	 */
	public void setProfile(ProfileResponse profile) {
		this.profile = profile;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AccountRequest [email=" + email + ", password=" + password + "]";
	}

}
