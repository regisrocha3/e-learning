package labs.rr.io.elearning.response;

import java.io.Serializable;

/**
 * Request Profile
 * 
 * 
 * @author regis.rocha
 *
 */
public class ProfileResponse implements Serializable {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = -1610516130406722692L;

	private String name;

	private String birthdate;

	private String photoBase64;

	private String gender;


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
	public String getBirthdate() {
		return birthdate;
	}

	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * @return the photoBase64
	 */
	public String getPhotoBase64() {
		return photoBase64;
	}

	/**
	 * @param photoBase64 the photoBase64 to set
	 */
	public void setPhotoBase64(String photoBase64) {
		this.photoBase64 = photoBase64;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProfileRequest [name=" + name + ", birthdate=" + birthdate + ", photoBase64="
				+ photoBase64 + ", gender=" + gender + "]";
	}

}
