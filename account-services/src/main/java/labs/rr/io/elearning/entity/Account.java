package labs.rr.io.elearning.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Table Account
 * 
 * 
 * @author regis.rocha
 *
 */
@Entity
@Table(name = "account")
@NamedQueries(value = {@NamedQuery(name = "Account.findById", query = "FROM Account a WHERE a.email=:email")})
public class Account implements Serializable {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = 1217092416799446966L;

	@Id
	private String email;

	@Column(name = "password")
	private String password;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_contact")
	private Set<Contact> contacts;

	@OneToOne
	@JoinColumn(name = "email", referencedColumnName = "email")
	private Profile profile;

	@OneToOne
	@JoinColumn(name = "email", referencedColumnName = "email")
	private TokenSessionAccount token;

	@Column(name = "created")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar created;

	@Column(name = "modified")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar modified;

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
	public Set<Contact> getContacts() {
		return contacts;
	}

	/**
	 * @param contacts the contacts to set
	 */
	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
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

	/**
	 * @return the created
	 */
	public Calendar getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(Calendar created) {
		this.created = created;
	}

	/**
	 * @return the modified
	 */
	public Calendar getModified() {
		return modified;
	}

	/**
	 * @param modified the modified to set
	 */
	public void setModified(Calendar modified) {
		this.modified = modified;
	}
	
	public Account() {
	}
	
	public Account(String email) {
		this.email = email;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [email=" + email + ", password=" + password + ", contacts=" + contacts + ", profile=" + profile
				+ ", token=" + token + ", created=" + created + ", modified=" + modified + "]";
	}
	
}
