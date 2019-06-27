package com.uca.cinema.dto;

import java.util.Date;

public class ShowtimeDTO {
	
	private Integer idShowtime;

	private Integer avaliableSeats;

	private double price;

	private Date schedule;

	private Boolean status;

	private Integer idmovie;

	private Integer idShowtimeFormat;

	private Integer idTheater;
	
	private Date showdate;
	
	private Integer createdBy;
	
	private Date createdDate;

	private Integer updatedBy;
	
	private Date updatedDate;

	public Integer getIdShowtime() {
		return idShowtime;
	}

	public void setIdShowtime(Integer idShowtime) {
		this.idShowtime = idShowtime;
	}

	public Integer getAvaliableSeats() {
		return avaliableSeats;
	}

	public void setAvaliableSeats(Integer avaliableSeats) {
		this.avaliableSeats = avaliableSeats;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getSchedule() {
		return schedule;
	}

	public void setSchedule(Date schedule) {
		this.schedule = schedule;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Integer getIdmovie() {
		return idmovie;
	}

	public void setIdmovie(Integer idmovie) {
		this.idmovie = idmovie;
	}

	public Integer getIdShowtimeFormat() {
		return idShowtimeFormat;
	}

	public void setIdShowtimeFormat(Integer idShowtimeFormat) {
		this.idShowtimeFormat = idShowtimeFormat;
	}

	public Integer getIdTheater() {
		return idTheater;
	}

	public void setIdTheater(Integer idTheater) {
		this.idTheater = idTheater;
	}

	public Date getShowdate() {
		return showdate;
	}

	public void setShowdate(Date showdate) {
		this.showdate = showdate;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
}
