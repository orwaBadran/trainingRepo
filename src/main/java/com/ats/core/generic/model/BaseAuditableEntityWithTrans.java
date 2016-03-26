package com.ats.core.generic.model;

import java.util.List;

import javax.persistence.MappedSuperclass;

import com.ats.core.generic.util.CollectionUtils;

/**
 * AuditableEntity.java Super class for Audited entities, used to add auditing columns to child entity and set attributes values when needed, in addition this class will create an auditing table
 * automatically
 *
 * @author Ali Saleh <Ali@ats-ware.com>
 * @since Aug 13, 2014
 **/

@MappedSuperclass
public abstract class BaseAuditableEntityWithTrans<T extends BaseTransEntity> extends BaseAuditableEntity {

	/**
	 * Get translation object by a given lang id
	 * 
	 * @param langRid
	 * @return Translation object
	 */
	public T getTransObject(Long langRid) {

		if (langRid == 1 || langRid == 2) {
			return null;// should not be reached
		}

		List<T> transLits = getTransList();
		if (CollectionUtils.isListEmpty(transLits)) {
			return null;
		}

		for (T transObject : transLits) {
			if (transObject.getLangRid() == langRid) {
				return transObject;
			}
		}

		return null;
	}

	// Get the Discriminator by language
	public String getDiscriminator(Long langRid) {
		if (langRid == 1) {
			return getPrimaryLangDiscriminator();
		} else if (langRid == 2) {
			return getSecondaryLangDiscriminator();
		} else {
			T transObject = getTransObject(langRid);
			if (transObject == null) {
				return getPrimaryLangDiscriminator();
			}
			return transObject.getTranslationDiscriminator();
		}
	}

	/**
	 * Must be overiden to get the translation list
	 * 
	 * @return List<T>
	 */
	public abstract List<T> getTransList();

	public abstract String getPrimaryLangDiscriminator();

	public abstract String getSecondaryLangDiscriminator();

}
