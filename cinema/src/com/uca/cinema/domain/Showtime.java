package com.uca.cinema.domain;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the showtime database table.
 * 
 */
@Entity
public class Showtime  {
	@Id
	@SequenceGenerator(name="SHOWTIME_IDSHOWTIME_GENERATOR", sequenceName="SHOWTIME_ID_SHOWTIME_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SHOWTIME_IDSHOWTIME_GENERATOR")
	@Column(name="id_showtime")
	private Integer idShowtime;

	@Column(name="avaliable_seats")
	private Integer avaliableSeats;

	@Column(name="created_by")
	private Integer createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="created_date")
	private Date createdDate;

	private double price;

	private Time schedule;

	private Boolean status;

	@Column(name="updated_by")
	private Integer updatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="updated_date")
	private Date updatedDate;

	//bi-directional many-to-one association to Movie
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_movie")
	private Movie movie;

	//bi-directional many-to-one association to ShowtimeFormat
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_format")
	private ShowtimeFormat showtimeFormat;

	//bi-directional many-to-one association to Theater
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_theater")
	private Theater theater;

	//bi-directional many-to-one association to Ticket
	@OneToMany(mappedBy="showtime")
	private List<Ticket> tickets;

	public Showtime() {
	}

	public Integer getIdShowtime() {
		return this.idShowtime;
	}

	public void setIdShowtime(Integer idShowtime) {
		this.idShowtime = idShowtime;
	}

	public Integer getAvaliableSeats() {
		return this.avaliableSeats;
	}

	public void setAvaliableSeats(Integer avaliableSeats) {
		this.avaliableSeats = avaliableSeats;
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

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Time getSchedule() {
		return this.schedule;
	}

	public void setSchedule(Time schedule) {
		this.schedule = schedule;
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

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public ShowtimeFormat getShowtimeFormat() {
		return this.showtimeFormat;
	}

	public void setShowtimeFormat(ShowtimeFormat showtimeFormat) {
		this.showtimeFormat = showtimeFormat;
	}

	public Theater getTheater() {
		return this.theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public List<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Ticket addTicket(Ticket ticket) {
		getTickets().add(ticket);
		ticket.setShowtime(this);

		return ticket;
	}

	public Ticket removeTicket(Ticket ticket) {
		getTickets().remove(ticket);
		ticket.setShowtime(null);

		return ticket;
	}

}