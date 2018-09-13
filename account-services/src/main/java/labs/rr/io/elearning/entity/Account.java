package labs.rr.io.elearning.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Column Family Account
 * 
 * 
 * @author regis.rocha
 *
 */
@Table(name = "account")
public class Account implements Serializable {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = 1217092416799446966L;

	@Id
	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@ManyToOne
	private Set<Contact> contacts;

	@Column(name = "created")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar created;

	@Column(name = "modified")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar modified;
	
	@OneToOne
	private Profile profile;
	
	@OneToOne
	private TokenSessionAccount token;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the contacts
	 */
	public Set<Contact> getContacts() {
		return contacts;
	}

	/**
	 * @param contacts
	 *            the contacts to set
	 */
	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created
	 *            the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * @return the modified
	 */
	public Date getModified() {
		return modified;
	}

	/**
	 * @param modified
	 *            the modified to set
	 */
	public void setModified(Date modified) {
		this.modified = modified;
	}

	/**
	 * @return the profile
	 */
	public Profile getProfile() {
		return profile;
	}

	/**
	 * @param profile the profile to set
	 */
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	/**
	 * @return the token
	 */
	public TokenSessionAccount getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(TokenSessionAccount token) {
		this.token = token;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [email=" + email + ", id=" + id + ", password=" + password + ", contacts=" + contacts
				+ ", created=" + created + ", modified=" + modified + ", profile=" + profile + ", token=" + token + "]";
	}

	public Account() {
	}

	/**
	 * @param id
	 */
	public Account(String email) {
		this.email = email;
	}
	
	/**
	 * @param id
	 */
	public Account(UUID id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Account)) {
			return false;
		}
		Account other = (Account) obj;
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		return true;
	}
	
}
