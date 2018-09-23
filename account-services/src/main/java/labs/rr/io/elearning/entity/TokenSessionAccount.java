package labs.rr.io.elearning.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Entity
@Table(name = "token_session_account")
public class TokenSessionAccount implements Serializable {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = -5246713328176786950L;

	@Id
	@Column(name = "tokenId")
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

	/**
	 * @return the tokenId
	 */
	public String getTokenId() {
		return tokenId;
	}

	/**
	 * @param tokenId the tokenId to set
	 */
	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

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

	/**
	 * @return the isExpired
	 */
	public boolean isExpired() {
		return isExpired;
	}

	/**
	 * @param isExpired the isExpired to set
	 */
	public void setExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}

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

	/**
	 * Pre persist
	 */
	public void prePersist() {
		this.tokenId = UUID.randomUUID().toString();
	}
}
