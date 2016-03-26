package com.ats.core.generic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;



/**
 * BaseTransEntity.java, Used To
 *
 * @author Ali Saleh <Ali@ats-ware.com>
 * @since Dec 22, 2014
 **/
@MappedSuperclass
public abstract class BaseTransEntity {

	/**
	 * get the entity ID (Primary key)
	 *
	 * @return Long
	 */
	public abstract Long getRid();

	@Column(name = "LANG_RID")
	@NotNull//(message = CommonErrorCodes.NotNull)
	private Long langRid;

	public abstract String getTranslationDiscriminator();

	/**
	 * Specify if the current entity is auditable (has auditing columns)
	 *
	 * @return
	 */
	public boolean isAuditable() {
		return false;
	}

	/**
	 * @return the langRid
	 */
	public final Long getLangRid() {
		return langRid;
	}

	/**
	 * @param langRid the langRid to set
	 */
	public final void setLangRid(Long langRid) {
		this.langRid = langRid;
	}

}
