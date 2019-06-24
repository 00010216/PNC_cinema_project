package com.uca.cinema.domain;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ticket database table.
 * 
 */
@Entity
@NamedQuery(name="Ticket.findAll", query="SELECT t FROM Ticket t")
public class Ticket  {

	@Id
	@SequenceGenerator(name="TICKET_IDTICKET_GENERATOR", sequenceName="TICKET_ID_TICKET_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TICKET_IDTICKET_GENERATOR")
	@Column(name="id_ticket")
	private Integer idTicket;

	private double price;

	@Temporal(TemporalType.DATE)
	@Column(name="purchase_date")
	private Date purchaseDate;

	@Column(name="remaining_balance")
	private double remainingBalance;

	@Column(name="reserved_seats")
	private Integer reservedSeats;

	private double subtotal;

	private double total;

	@Column(name="used_balance")
	private double usedBalance;

	//bi-directional many-to-one association to CUser
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_user")
	private CUser CUser;

	//bi-directional many-to-one association to Showtime
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_showtime")
	private Showtime showtime;

	public Ticket() {
	}

	public Integer getIdTicket() {
		return this.idTicket;
	}

	public void setIdTicket(Integer idTicket) {
		this.idTicket = idTicket;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getPurchaseDate() {
		return this.purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public double getRemainingBalance() {
		return this.remainingBalance;
	}

	public void setRemainingBalance(double remainingBalance) {
		this.remainingBalance = remainingBalance;
	}

	public Integer getReservedSeats() {
		return this.reservedSeats;
	}

	public void setReservedSeats(Integer reservedSeats) {
		this.reservedSeats = reservedSeats;
	}

	public double getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getUsedBalance() {
		return this.usedBalance;
	}

	public void setUsedBalance(double usedBalance) {
		this.usedBalance = usedBalance;
	}

	public CUser getCUser() {
		return this.CUser;
	}

	public void setCUser(CUser CUser) {
		this.CUser = CUser;
	}

	public Showtime getShowtime() {
		return this.showtime;
	}

	public void setShowtime(Showtime showtime) {
		this.showtime = showtime;
	}

}