package com.ats.core.control.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;

import com.ats.core.generic.model.BaseEntity;
import com.ats.core.generic.util.StringUtils;

/**
 *
 * CtlLogin.java
 *
 * @since Jan 28, 2015
 */
@Entity
@Indexed
@Table(name = "CTL_LOGINS")
@NamedQueries({ @NamedQuery(name = "CtlLogin.findByRidFetch", query = "SELECT c FROM CtlLogin c WHERE c.rid = :rid"),
		@NamedQuery(name = "CtlLogin.findPersonOpenedSessions", query = "SELECT c FROM CtlLogin c WHERE c.userRid.rid= :userRid AND c.logoutMethod IS NULL"),
		@NamedQuery(name = "CtlLogin.findByUserRidAndSessionId", query = "SELECT c FROM CtlLogin c WHERE c.sessionId = :sessionId AND c.userRid.rid= :userRid AND c.logoutMethod IS NULL"),
		@NamedQuery(name = "CtlLogin.findUserLastAttempt", query = "SELECT c FROM CtlLogin c WHERE  c.rid=(select max(g.rid) from CtlLogin g where g.userRid.rid= :userRid)") })
public class CtlLogin extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CtlLogin.RIDSeq")
	@SequenceGenerator(name = "CtlLogin.RIDSeq", sequenceName = "CTL_LOGINS_SEQ")
	@Basic(optional = false)
	@Column(name = "RID")
	private Long rid;

	@Basic(optional = false)
	@Column(name = "SESSION_ID")
	@NotNull // (message = CommonErrorCodes.NotNull)
	@Size(max = 200)
	@Field(index = Index.YES, analyze = Analyze.YES)
	private String sessionId;

	@Basic(optional = false)
	@Column(name = "LOGIN_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull // (message = CommonErrorCodes.NotNull)
	private Date loginTime;

	@Column(name = "LOGOFF_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date logoffTime;

	@Basic(optional = false)
	@Column(name = "CLIENT_IP")
	@NotNull // (message = CommonErrorCodes.NotNull)
	@Size(max = 20)
	@Field(index = Index.YES, analyze = Analyze.YES)
	private String clientIp;

	@Column(name = "PC_NAME")
	@Size(max = 100)
	@Field(index = Index.YES, analyze = Analyze.YES)
	private String pcName;

	@Column(name = "LOGOUT_METHOD")
	@Digits(integer = 1, fraction = 0/* , message = CommonErrorCodes.Digits */)
	private Short logoutMethod;

	@Column(name = "KILLED_BY")
	private Long killedBy;

	@Column(name = "KILLED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date killedDate;

	@Basic(optional = false)
	@Column(name = "LOGIN_METHOD")
	@Digits(integer = 1, fraction = 0)
	@NotNull // (message = CommonErrorCodes.NotNull)
	private Short loginMethod;

	@Column(name = "FAILURE_REASON")
	@Digits(integer = 1, fraction = 0/* , message = CommonErrorCodes.Digits */)
	private Short failureReason;

	@Basic(optional = false)
	@Column(name = "SUCCESS_AFTER")
	@NotNull // (message = CommonErrorCodes.NotNull)
	@Digits(integer = 2, fraction = 0/* , message = CommonErrorCodes.Digits */)
	private short attemptNumber;// Ali Saleh, the name "SucessAfter" is misleading

	@Basic(optional = false)
	@Column(name = "SERVER_IP")
	@NotNull // (message = CommonErrorCodes.NotNull)
	@Size(max = 20)
	@Field(index = Index.YES, analyze = Analyze.YES)
	private String serverIp;

	@Transient
	private String usernameT;

	@Transient
	private String loginMethodC;

	@Transient
	private String loginTimeF;

	public CtlLogin() {
	}

	public CtlLogin(Long rid) {
		this.rid = rid;
	}

	public CtlLogin(Long rid, String sessionId, Date loginTime, String clientIp, Short loginMethod, short attemptNumber, String serverIp) {
		this.rid = rid;
		this.sessionId = sessionId;
		this.loginTime = loginTime;
		this.clientIp = clientIp;
		this.loginMethod = loginMethod;
		this.attemptNumber = attemptNumber;
		this.serverIp = serverIp;
	}

	@Override
	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Date getLogoffTime() {
		return logoffTime;
	}

	public void setLogoffTime(Date logoffTime) {
		this.logoffTime = logoffTime;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getPcName() {
		return pcName;
	}

	public void setPcName(String pcName) {
		this.pcName = pcName;
	}

	public Short getLogoutMethod() {
		return logoutMethod;
	}

	public void setLogoutMethod(Short logoutMethod) {
		this.logoutMethod = logoutMethod;
	}

	public Long getKilledBy() {
		return killedBy;
	}

	public void setKilledBy(Long killedBy) {
		this.killedBy = killedBy;
	}

	public Date getKilledDate() {
		return killedDate;
	}

	public void setKilledDate(Date killedDate) {
		this.killedDate = killedDate;
	}

	public Short getLoginMethod() {
		return loginMethod;
	}

	public void setLoginMethod(Short loginMethod) {
		this.loginMethod = loginMethod;
	}

	public Short getFailureReason() {
		return failureReason;
	}

	public void setFailureReason(Short failureReason) {
		this.failureReason = failureReason;
	}

	public short getAttemptNumber() {
		return attemptNumber;
	}

	public void setAttemptNumber(short attemptNumber) {
		this.attemptNumber = attemptNumber;
	}

	public String getServerIp() {
		return serverIp;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public String getUsernameT() {
		return usernameT;
	}

	public void setUsernameT(String usernameT) {
		this.usernameT = usernameT;
	}

	public String getLoginMethodC() {
		return StringUtils.getTextStyleClass(loginMethodC);
	}

	public void setLoginMethodC(String loginMethodC) {
		this.loginMethodC = loginMethodC;
	}

	public String getLoginTimeF() {
		return loginTimeF;
	}

	public void setLoginTimeF(String loginTimeF) {
		this.loginTimeF = loginTimeF;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (rid != null ? rid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof CtlLogin)) {
			return false;
		}
		CtlLogin other = (CtlLogin) object;
		if ((this.rid == null && other.rid != null) || (this.rid != null && !this.rid.equals(other.rid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return getClass().getName() + "  [rid=" + rid + "]";
	}

}
