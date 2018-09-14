package labs.rr.io.elearning.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Table token_session_account
 * 
 * 
 * @author regis.rocha
 *
 */
@Table(name = "token_session_account")
public class TokenSessionAccount implements Serializable {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = -5246713328176786950L;

	@Id
	private String tokenId;

	@OneToOne
	@JoinColumn(name = "email", referencedColumnName = "email")
	private Account account;

	@Column(name = "created")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar created;

	@Column(name = "modified")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar modified;

	@Column(name = "is_expired")
	private boolean isExpired;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TokenSessionAccount [tokenId=" + tokenId + ", account=" + account + ", created=" + created
				+ ", modified=" + modified + ", isExpired=" + isExpired + "]";
	}
}
