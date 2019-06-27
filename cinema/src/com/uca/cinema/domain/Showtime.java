package com.uca.cinema.domain;

import javax.persistence.*;
import java.text.SimpleDateFormat;
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

	@Temporal(TemporalType.TIME)
	private Date schedule;

	private Boolean status;

	@Column(name="updated_by")
	private Integer updatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="updated_date")
	private Date updatedDate;

	//bi-directional many-to-one association to Movie
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_movie")
	private Movie movie;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_format")
	private ShowtimeFormat showtimeFormat;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_theater")
	private Theater theater;

	//bi-directional many-to-one association to Ticket
	@OneToMany(mappedBy="showtime", fetch = FetchType.LAZY)
	private List<Ticket> tickets;
	
	private Date showdate;

	public Date getShowdate() {
		return showdate;
	}

	public void setShowdate(Date showdate) {
		this.showdate = showdate;
	}

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

	public Date getSchedule() {
		return this.schedule;
	}
	
	public String getScheduleString() {
		String time= new SimpleDateFormat("HH:mm").format(schedule);
		return time;
	}

	public void setSchedule(Date schedule) {
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

	public String getDelegateShowdate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(showdate);
	}
	
	public String getDelegateSchedule() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
		return dateFormat.format(schedule);
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