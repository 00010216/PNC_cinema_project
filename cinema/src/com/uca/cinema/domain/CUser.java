package com.uca.cinema.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the c_user database table.
 * 
 */
@Entity
@Table(name="c_user")
public class CUser  {

	@Id
	@SequenceGenerator(name="C_USER_IDUSER_GENERATOR", sequenceName="C_USER_ID_USER_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="C_USER_IDUSER_GENERATOR")
	@Column(name="id_user")
	private Integer idUser;
	
	@NotEmpty(message="Este campo no puede estar vacio")
	private String address;

	@Temporal(TemporalType.DATE)
	@Column(name="approved_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date approvedDate;

	private BigDecimal balance;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;

	@Temporal(TemporalType.DATE)
	@Column(name="created_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdDate;
	
	@NotEmpty(message="Este campo no puede estar vacio")
	private String email;

	@Column(name="first_name")
	@NotEmpty(message="Este campo no puede estar vacio")
	private String firstName;

	private Boolean isadmin;

	@Column(name="last_name")
	@NotEmpty(message="Este campo no puede estar vacio")
	private String lastName;
	
	@NotEmpty(message="Este campo no puede estar vacio")
	private String passwd;

	private Boolean status;
	
	private Boolean loggedin;

	@Column(name="updated_by")
	private Integer updatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="updated_date")
	private Date updatedDate;
	
	@NotEmpty(message="Este campo no puede estar vacio")
	private String username;

	//bi-directional many-to-one association to CUser
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="approved_by")
	private CUser CUser;

	//bi-directional many-to-one association to CUser
	@OneToMany(mappedBy="CUser")
	private List<CUser> CUsers;

	//bi-directional many-to-one association to Country
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_country")
	private Country country;

	//bi-directional many-to-one association to LogAction
	@OneToMany(mappedBy="CUser")
	private List<LogAction> logActions;

	//bi-directional many-to-one association to Ticket
	@OneToMany(mappedBy="CUser")
	private List<Ticket> tickets;

	//bi-directional many-to-one association to Municipality
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_mun")
	private Municipality municipality;

	public CUser() {
	}

	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getApprovedDate() {
		return this.approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Boolean getIsadmin() {
		return this.isadmin;
	}

	public void setIsadmin(Boolean isadmin) {
		this.isadmin = isadmin;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
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

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public CUser getCUser() {
		return this.CUser;
	}

	public void setCUser(CUser CUser) {
		this.CUser = CUser;
	}

	public List<CUser> getCUsers() {
		return this.CUsers;
	}

	public void setCUsers(List<CUser> CUsers) {
		this.CUsers = CUsers;
	}

	public CUser addCUser(CUser CUser) {
		getCUsers().add(CUser);
		CUser.setCUser(this);

		return CUser;
	}

	public CUser removeCUser(CUser CUser) {
		getCUsers().remove(CUser);
		CUser.setCUser(null);

		return CUser;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<LogAction> getLogActions() {
		return this.logActions;
	}

	public void setLogActions(List<LogAction> logActions) {
		this.logActions = logActions;
	}

	public LogAction addLogAction(LogAction logAction) {
		getLogActions().add(logAction);
		logAction.setCUser(this);

		return logAction;
	}

	public LogAction removeLogAction(LogAction logAction) {
		getLogActions().remove(logAction);
		logAction.setCUser(null);

		return logAction;
	}

	public List<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Ticket addTicket(Ticket ticket) {
		getTickets().add(ticket);
		ticket.setCUser(this);

		return ticket;
	}

	public Ticket removeTicket(Ticket ticket) {
		getTickets().remove(ticket);
		ticket.setCUser(null);

		return ticket;
	}

	public Municipality getMunicipality() {
		return this.municipality;
	}

	public void setMunicipality(Municipality municipality) {
		this.municipality = municipality;
	}

	public Boolean getLoggedin() {
		return loggedin;
	}

	public void setLoggedin(Boolean loggedin) {
		this.loggedin = loggedin;
	}

}