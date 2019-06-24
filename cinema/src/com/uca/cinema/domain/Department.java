package com.uca.cinema.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the department database table.
 * 
 */
@Entity
@NamedQuery(name="Department.findAll", query="SELECT d FROM Department d")
public class Department  {

	@Id
	@SequenceGenerator(name="DEPARTMENT_IDDEP_GENERATOR", sequenceName="DEPARTMENT_ID_DEP_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DEPARTMENT_IDDEP_GENERATOR")
	@Column(name="id_dep")
	private Integer idDep;

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

	//bi-directional many-to-one association to Municipality
	@OneToMany(mappedBy="department")
	private List<Municipality> municipalities;

	public Department() {
	}

	public Integer getIdDep() {
		return this.idDep;
	}

	public void setIdDep(Integer idDep) {
		this.idDep = idDep;
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

	public List<Municipality> getMunicipalities() {
		return this.municipalities;
	}

	public void setMunicipalities(List<Municipality> municipalities) {
		this.municipalities = municipalities;
	}

	public Municipality addMunicipality(Municipality municipality) {
		getMunicipalities().add(municipality);
		municipality.setDepartment(this);

		return municipality;
	}

	public Municipality removeMunicipality(Municipality municipality) {
		getMunicipalities().remove(municipality);
		municipality.setDepartment(null);

		return municipality;
	}

}