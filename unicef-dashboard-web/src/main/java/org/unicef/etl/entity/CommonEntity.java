package org.unicef.etl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public abstract class CommonEntity {
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "birth_date")
	private Date birthdate;
	
	private String gender;
	
	@Column(name = "base_entity_id")
	public String baseEntityId;
	
	@Column(name = "instance_id")
	private String instanceId;
	
	private String provider;
	
	private Date start;
	
	@Column(name = "end_time")
	private Date end;
	
	@Temporal(TemporalType.DATE)
	private Date today;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "registration_date")
	private Date registrationDate;
	
	private String country;
	
	private String division;
	
	private String district;
	
	private String upazila;
	
	@Column(name = "unions")
	private String union;
	
	private String ward;
	
	private String subunit;
	
	@Column(name = "mauza_para")
	private String mauzaPara;
	
	private String gps;
	
	@Column(name = "submission_time")
	private long submissionTime;
	
	@Column(name = "server_version")
	private long serverVersion;
	
	@Column(name = "client_version")
	private long clientVersion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", updatable = false)
	@CreationTimestamp
	private Date created = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MODIFIED_DATE", insertable = true, updatable = true)
	@UpdateTimestamp
	private Date updated = new Date();
	
	@Column(name = "received_time")
	private Date receivedTime;
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Date getBirthdate() {
		return birthdate;
	}
	
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getInstanceId() {
		return instanceId;
	}
	
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}
	
	public String getProvider() {
		return provider;
	}
	
	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	public Date getToday() {
		return today;
	}
	
	public void setToday(Date today) {
		this.today = today;
	}
	
	public java.util.Date getStart() {
		return start;
	}
	
	public void setStart(java.util.Date start) {
		this.start = start;
	}
	
	public Date getEnd() {
		return end;
	}
	
	public void setEnd(Date end) {
		this.end = end;
	}
	
	public Date getRegistrationDate() {
		return registrationDate;
	}
	
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getDivision() {
		return division;
	}
	
	public void setDivision(String division) {
		this.division = division;
	}
	
	public String getDistrict() {
		return district;
	}
	
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public String getUpazila() {
		return upazila;
	}
	
	public void setUpazila(String upazila) {
		this.upazila = upazila;
	}
	
	public String getUnion() {
		return union;
	}
	
	public void setUnion(String union) {
		this.union = union;
	}
	
	public String getWard() {
		return ward;
	}
	
	public void setWard(String ward) {
		this.ward = ward;
	}
	
	public String getSubunit() {
		return subunit;
	}
	
	public void setSubunit(String subunit) {
		this.subunit = subunit;
	}
	
	public String getMauzaPara() {
		return mauzaPara;
	}
	
	public void setMauzaPara(String mauzaPara) {
		this.mauzaPara = mauzaPara;
	}
	
	public String getGps() {
		return gps;
	}
	
	public void setGps(String gps) {
		this.gps = gps;
	}
	
	public long getSubmissionTime() {
		return submissionTime;
	}
	
	public void setSubmissionTime(long submissionTime) {
		this.submissionTime = submissionTime;
	}
	
	public long getClientVersion() {
		return clientVersion;
	}
	
	public void setClientVersion(long clientVersion) {
		this.clientVersion = clientVersion;
	}
	
	public Date getCreated() {
		return created;
	}
	
	public void setCreated() {
		this.created = new Date();
	}
	
	public Date getUpdated() {
		return updated;
	}
	
	public void setUpdated() {
		this.updated = new Date();
	}
	
	public Date getReceivedTime() {
		return receivedTime;
	}
	
	public void setReceivedTime(Date receivedTime) {
		this.receivedTime = receivedTime;
	}
	
	public String getBaseEntityId() {
		return baseEntityId;
	}
	
	public void setBaseEntityId(String baseEntityId) {
		this.baseEntityId = baseEntityId;
	}
	
	public long getServerVersion() {
		return serverVersion;
	}
	
	public void setServerVersion(long serverVersion) {
		this.serverVersion = serverVersion;
	}
	
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
	@Override
	public String toString() {
		return "CommonEntity [firstName=" + firstName + ", lastName=" + lastName + ", birthdate=" + birthdate + ", gender="
		        + gender + ", baseEntityId=" + baseEntityId + ", instanceId=" + instanceId + ", provider=" + provider
		        + ", start=" + start + ", end=" + end + ", today=" + today + ", registrationDate=" + registrationDate
		        + ", country=" + country + ", division=" + division + ", district=" + district + ", upazila=" + upazila
		        + ", union=" + union + ", ward=" + ward + ", subunit=" + subunit + ", mauzaPara=" + mauzaPara + ", gps="
		        + gps + ", submissionTime=" + submissionTime + ", serverVersion=" + serverVersion + ", clientVersion="
		        + clientVersion + ", created=" + created + ", updated=" + updated + ", receivedTime=" + receivedTime + "]";
	}
	
}
