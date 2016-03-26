package com.ats.core.generic.model;

public class DefaultEntityImpl extends BaseEntity {

	private Long rid;
	private String desc;

	public DefaultEntityImpl(Long rid) {
		this.rid = rid;
	}

	public DefaultEntityImpl(Long rid, String desc) {
		this.rid = rid;
		this.desc = desc;
	}

	@Override
	public Long getRid() {
		return rid;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @param rid the rid to set
	 */
	public void setRid(Long rid) {
		this.rid = rid;
	}

	@Override
	public String getPrimaryLangDiscriminator() {
		return desc;
	}

	@Override
	public String getSecondaryLangDiscriminator() {
		return desc;
	}

}
