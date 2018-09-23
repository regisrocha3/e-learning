package labs.rr.io.elearning.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Table Profile
 * 
 * 
 * @author regis.rocha
 *
 */
@Entity
@Table(name = "profile")
public class Profile implements Serializable {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = -2820927396532698876L;

	@Id
	@OneToOne
	@JoinColumn(name = "email", referencedColumnName = "email")
	private Account account;

	@Column(name = "name")
	private String name;

	@Column(name = "birthdate")
	@Temporal(TemporalType.DATE)
	private Calendar birthdate;

	@Column(name = "photo")
	private byte[] photo;

	@Column(name = "gender", length = 1, nullable = false)
	private String gender;

	@Column(name = "created")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar created;

	@Column(name = "modified")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar modified;

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the birthdate
	 */
	public Calendar getBirthdate() {
		return birthdate;
	}

	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(Calendar birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * @return the photo
	 */
	public byte[] getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Profile [account=" + account + ", name=" + name + ", birthdate=" + birthdate + ", photo="
				+ Arrays.toString(photo) + ", gender=" + gender + ", created=" + created + ", modified=" + modified
				+ "]";
	}

}
