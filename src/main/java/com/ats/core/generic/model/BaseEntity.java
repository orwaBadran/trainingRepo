package com.ats.core.generic.model;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * BaseEntity.java Super class for entities, used to unify the get primary key attribute name and to add common attributes
 *
 * @author Ali Saleh <Ali@ats-ware.com>
 * @since Aug 13, 2014
 **/
@MappedSuperclass
public abstract class BaseEntity {

	/**
	 * get the entity ID (Primary key)
	 *
	 * @return Long
	 */
	public abstract Long getRid();

	@Transient
	private boolean markedForDeletion = false;

	// Get the Discriminator by language
	public String getDiscriminator(Long langRid) {
		if (langRid == 1) {
			return getPrimaryLangDiscriminator();
		} else if (langRid == 2) {
			return getSecondaryLangDiscriminator();
		} else
			return getPrimaryLangDiscriminator();
	}

	public String getPrimaryLangDiscriminator() {
		return getRid() + "";
	}

	public String getSecondaryLangDiscriminator() {
		return getRid() + "";
	}

	/**
	 * Specify if the current entity is auditable (has auditing columns)
	 *
	 * @return
	 */
	public boolean isAuditable() {
		return false;
	}

	/**
	 * @return the markedForDeletion
	 */
	public boolean isMarkedForDeletion() {
		return markedForDeletion;
	}

	/**
	 * @param markedForDeletion the markedForDeletion to set
	 */
	public void setMarkedForDeletion(boolean markedForDeletion) {
		this.markedForDeletion = markedForDeletion;
	}
}
