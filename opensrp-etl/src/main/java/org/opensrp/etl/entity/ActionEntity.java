package org.opensrp.etl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "action")
public class ActionEntity {
	
	public ActionEntity() {
		
	}
	
	@Override
	public String toString() {
		return "ActionEntity [id=" + id + ", provider=" + anmIdentifier + ", caseID=" + caseId + ", startDate=" + startDate
		        + ", beneficiaryType=" + beneficiaryType + ", scheduleName=" + scheduleName + ", expiryDate=" + expiryDate
		        + ", visitCode=" + visitCode + ", alertStatus=" + alertStatus + ", actionTarget=" + actionTarget
		        + ", actionType=" + actionType + ", isActionActive=" + isActionActive + ", timeStamp=" + timeStamp + "]";
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "action_id_seq")
	@SequenceGenerator(name = "action_id_seq", sequenceName = "action_id_seq", allocationSize = 1)
	private long id;
	
	@Column(name = "time_stamp")
	private Long timeStamp;
	
	@Column(name = "is_action_active")
	private Boolean isActionActive;
	
	@Column(name = "provider")
	private String anmIdentifier;
	
	@Column(name = "case_id")
	private String caseId;
	
	@Column(name = "beneficiary_type")
	private String beneficiaryType;
	
	@Column(name = "schedule_name")
	private String scheduleName;
	
	@Column(name = "visit_code")
	private String visitCode;
	
	@Column(name = "alert_status")
	private String alertStatus;
	
	@Column(name = "action_target")
	private String actionTarget;
	
	@Column(name = "action_type")
	private String actionType;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "expiry_date")
	private Date expiryDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", updatable = false)
	@CreationTimestamp
	private Date created = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFIED_DATE", insertable = true, updatable = true)
	@UpdateTimestamp
	private Date updated = new Date();
	
	public long getId() {
		return id;
	}
	
	public String getCaseId() {
		return caseId;
	}
	
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	
	public Date getCreated() {
		return created;
	}
	
	public Date getUpdated() {
		return updated;
	}
	
	public String getAnmIdentifier() {
		return anmIdentifier;
	}
	
	public void setanmIdentifier(String provider) {
		this.anmIdentifier = provider;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setstartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public String getBeneficiaryType() {
		return beneficiaryType;
	}
	
	public void setbeneficiaryType(String beneficiaryType) {
		this.beneficiaryType = beneficiaryType;
	}
	
	public String getScheduleName() {
		return scheduleName;
	}
	
	public void setscheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}
	
	public Date getExpiryDate() {
		return expiryDate;
	}
	
	public void setexpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	public String getVisitCode() {
		return visitCode;
	}
	
	public void setvisitCode(String visitCode) {
		this.visitCode = visitCode;
	}
	
	public String getAlertStatus() {
		return alertStatus;
	}
	
	public void setalertStatus(String alertStatus) {
		this.alertStatus = alertStatus;
	}
	
	public String getActionTarget() {
		return actionTarget;
	}
	
	public void setactionTarget(String actionTarget) {
		this.actionTarget = actionTarget;
	}
	
	public String getActionType() {
		return actionType;
	}
	
	public void setactionType(String actionType) {
		this.actionType = actionType;
	}
	
	public Boolean getIsActionActive() {
		return isActionActive;
	}
	
	public void setisActionActive(Boolean isActionActive) {
		this.isActionActive = isActionActive;
	}
	
	public Long getTimeStamp() {
		return timeStamp;
	}
	
	public void settimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
