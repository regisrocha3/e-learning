package labs.rr.io.elearning.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 * Column Family token_session_account
 * 
 * 
 * @author regis.rocha
 *
 */
@Table(value = "token_session_account")
public class TokenSessionAccount implements Serializable {

	/**
	 * serial version
	 */
	private static final long serialVersionUID = -5246713328176786950L;

	@PrimaryKeyColumn(name = "token_id", ordering = Ordering.DESCENDING, ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private UUID tokenId;

	@PrimaryKeyColumn(name = "id_account")
	private UUID accountId;

	@Column(value = "created")
	private Date created;

	@Column(value = "modified")
	private Date modified;

	@Column(value = "is_expired")
	private String isExpired;

	/**
	 * @return the tokenId
	 */
	public UUID getTokenId() {
		return tokenId;
	}

	/**
	 * @param tokenId the tokenId to set
	 */
	public void setTokenId(UUID tokenId) {
		this.tokenId = tokenId;
	}

	/**
	 * @return the accountId
	 */
	public UUID getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(UUID accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
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
	 * @param modified the modified to set
	 */
	public void setModified(Date modified) {
		this.modified = modified;
	}

	/**
	 * @return the isExpired
	 */
	public String getIsExpired() {
		return isExpired;
	}

	/**
	 * @param isExpired the isExpired to set
	 */
	public void setIsExpired(String isExpired) {
		this.isExpired = isExpired;
	}
	
	public boolean isTokenValid() {
		return "N".equalsIgnoreCase(this.isExpired);
	} 

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TokenSessionAccount [tokenId=" + tokenId + ", accountId=" + accountId + ", created=" + created
				+ ", modified=" + modified + ", isExpired=" + isExpired + "]";
	}
	
	public TokenSessionAccount() {
	}
	
	public TokenSessionAccount(final String tokenID) {
		this.tokenId = UUID.fromString(tokenID);
	}
	
	public TokenSessionAccount(final String tokenID, final String accountId) {
		this.tokenId = UUID.fromString(tokenID);
		this.accountId = UUID.fromString(accountId);
	}
	
	public TokenSessionAccount(final UUID tokenID, final UUID accountId) {
		this.tokenId = tokenID;
		this.accountId = accountId;
	}

}
