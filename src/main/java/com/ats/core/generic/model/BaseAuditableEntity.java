package com.ats.core.generic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AuditableEntity.java Super class for Audited entities, used to add auditing columns to child entity and set attributes values when needed, in addition this class will create an auditing table
 * automatically
 *
 * @author Ali Saleh <Ali@ats-ware.com>
 * @since Aug 13, 2014
 **/

@MappedSuperclass
public abstract class BaseAuditableEntity extends BaseEntity {

	@Column(name = "CREATED_BY")
	private Long createdBy;

	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Column(name = "UPDATED_BY")
	private Long updatedBy;

	@Column(name = "UPDATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	@Override
	public boolean isAuditable() {
		return true;
	}

	@PrePersist
	public void onPrePersist() {
		populateAudit();
	}

	@PreUpdate
	public void onPreUpdate() {
		populateAudit();
	}

	@PreRemove
	public void onPreRemove() {

	}

	/**
	 * populate timestamp on presist and update
	 */
	protected void populateAudit() {

	}

	// Get the Discriminator by language
	@Override
	public String getDiscriminator(Long langRid) {
		if (langRid == 1) {
			return getPrimaryLangDiscriminator();
		} else if (langRid == 2) {
			return getSecondaryLangDiscriminator();
		} else
			return getPrimaryLangDiscriminator();
	}

	/**
	 * @return the createdBy
	 */
	public final Long getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public final void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDate
	 */
	public final Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public final void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the updatedBy
	 */
	public final Long getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public final void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the updatedDate
	 */
	public final Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public final void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
