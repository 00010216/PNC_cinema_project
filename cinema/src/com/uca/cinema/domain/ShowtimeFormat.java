package com.uca.cinema.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the showtime_format database table.
 * 
 */
@Entity
@Table(name="showtime_format")
public class ShowtimeFormat  {
	@Id
	@SequenceGenerator(name="SHOWTIME_FORMAT_IDSTFORMAT_GENERATOR", sequenceName="SHOWTIME_FORMAT_ID_ST_FORMAT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SHOWTIME_FORMAT_IDSTFORMAT_GENERATOR")
	@Column(name="id_st_format")
	private Integer idStFormat;

	@Column(name="created_by")
	private Integer createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="created_date")
	private Date createdDate;

	private String description;

	private String name;

	private Boolean status;

	@Column(name="updated_by")
	private Integer updatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="updated_date")
	private Date updatedDate;

	//bi-directional many-to-one association to Showtime
	@OneToMany(mappedBy="showtimeFormat")
	private List<Showtime> showtimes;

	public ShowtimeFormat() {
	}

	public Integer getIdStFormat() {
		return this.idStFormat;
	}

	public void setIdStFormat(Integer idStFormat) {
		this.idStFormat = idStFormat;
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
		showtime.setShowtimeFormat(this);

		return showtime;
	}

	public Showtime removeShowtime(Showtime showtime) {
		getShowtimes().remove(showtime);
		showtime.setShowtimeFormat(null);

		return showtime;
	}

}