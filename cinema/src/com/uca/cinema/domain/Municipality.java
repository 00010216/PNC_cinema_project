package com.uca.cinema.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the municipality database table.
 * 
 */
@Entity
public class Municipality  {

	@Id
	@SequenceGenerator(name="MUNICIPALITY_IDMUN_GENERATOR", sequenceName="MUNICIPALITY_ID_MUN_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MUNICIPALITY_IDMUN_GENERATOR")
	@Column(name="id_mun")
	private Integer idMun;

	@Column(name="created_by")
	private Integer createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="created_date")
	private Date createdDate;

	private String name;

	private Boolean status;

	@Column(name="updated_by")
	private Integer updatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="updated_date")
	private Date updatedDate;

	//bi-directional many-to-one association to Department
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_dep")
	private Department department;

	//bi-directional many-to-one association to CUser
	@OneToMany(mappedBy="municipality")
	private List<CUser> CUsers;

	public Municipality() {
	}

	public Integer getIdMun() {
		return this.idMun;
	}

	public void setIdMun(Integer idMun) {
		this.idMun = idMun;
	}

	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Integer getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<CUser> getCUsers() {
		return this.CUsers;
	}

	public void setCUsers(List<CUser> CUsers) {
		this.CUsers = CUsers;
	}

	public CUser addCUser(CUser CUser) {
		getCUsers().add(CUser);
		CUser.setMunicipality(this);

		return CUser;
	}

	public CUser removeCUser(CUser CUser) {
		getCUsers().remove(CUser);
		CUser.setMunicipality(null);

		return CUser;
	}

}