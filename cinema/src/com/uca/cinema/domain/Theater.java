package com.uca.cinema.domain;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the theater database table.
 * 
 */
@Entity
public class Theater  {

	@Id
	@SequenceGenerator(name="theater_id_theater_seq", sequenceName="theater_id_theater_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="theater_id_theater_seq")

	@Column(name="id_theater")
	private Integer idTheater;
	
	@Min(1)
	@Max(100)
	private Integer capacity;

	@Column(name="created_by")
	private Integer createdBy;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="created_date")
	private Date createdDate;

	@NotEmpty(message = "Este campo no puede estar vacío")	
	private String description;
	
	@NotEmpty(message = "Este campo no puede estar vacío")
	private String name;
	
	private Boolean status;

	@Column(name="updated_by")
	private Integer updatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="updated_date")
	private Date updatedDate;

	//bi-directional many-to-one association to Showtime
	@OneToMany(mappedBy="theater")
	private List<Showtime> showtimes;

	public Theater() {
	}

	public Integer getIdTheater() {
		return this.idTheater;
	}

	public void setIdTheater(Integer idTheater) {
		this.idTheater = idTheater;
	}

	public Integer getCapacity() {
		return this.capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public List<Showtime> getShowtimes() {
		return this.showtimes;
	}

	public void setShowtimes(List<Showtime> showtimes) {
		this.showtimes = showtimes;
	}

	public Showtime addShowtime(Showtime showtime) {
		getShowtimes().add(showtime);
		showtime.setTheater(this);

		return showtime;
	}

	public Showtime removeShowtime(Showtime showtime) {
		getShowtimes().remove(showtime);
		showtime.setTheater(null);

		return showtime;
	}
	
	public String getDelegateStatus() {				
		return this.status ? "Disponible" : "No disponible";
	}

}