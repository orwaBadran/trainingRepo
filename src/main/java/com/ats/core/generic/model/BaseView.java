package com.ats.core.generic.model;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

@MappedSuperclass
public abstract class BaseView extends BaseEntity {

	/**
	 * get the entity ID (Primary key)
	 *
	 * @return Long
	 */
	public abstract Long getRid();

	@PrePersist
	private void prePersist() throws Exception {
		throw new Exception("Persist Not allowed on View");
	}

	@PreRemove
	private void preRemove() throws Exception {
		throw new Exception("Remove Not allowed on View");
	}

	@PreUpdate
	private void preUpdate() throws Exception {
		throw new Exception("Update Not allowed on View");
	}

}
