package labs.rr.io.elearning.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Table Profile
 * 
 * 
 * @author regis.rocha
 *
 */
@Table(name = "profile")
public class Profile implements Serializable {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = -2820927396532698876L;

	@Column(name = "name")
	private String name;

	@Column(name = "birthdate")
	private Calendar birthdate;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Profile [name=" + name + ", birthdate=" + birthdate + "]";
	}

	public Profile() {
	}

	/**
	 * @param name
	 * @param birthdate
	 */
	public Profile(String name, Date birthdate) {
		this.name = name;
		this.birthdate = birthdate;
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
		result = prime * result + ((birthdate == null) ? 0 : birthdate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (!(obj instanceof Profile)) {
			return false;
		}
		Profile other = (Profile) obj;
		if (birthdate == null) {
			if (other.birthdate != null) {
				return false;
			}
		} else if (!birthdate.equals(other.birthdate)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

}
