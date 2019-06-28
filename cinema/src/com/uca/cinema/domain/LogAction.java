package com.uca.cinema.domain;

import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the log_action database table.
 * 
 */
@Entity
@Table(name="log_action")
@NamedQuery(name="LogAction.findAll", query="SELECT l FROM LogAction l")
public class LogAction  {

	@Id
	@SequenceGenerator(name="log_action_id_log_seq", sequenceName="log_action_id_log_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="log_action_id_log_seq")
	@Column(name="id_log")
	private Integer idLog;

	@Column(name="created_at")
	private Timestamp createdAt;

	private String description;

	@Column(name="id_user")
	private Integer idUser;

	//bi-directional many-to-one association to CUser
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_admin")
	private CUser CUser;

	public LogAction() {
	}

	public Integer getIdLog() {
		return this.idLog;
	}

	public void setIdLog(Integer idLog) {
		this.idLog = idLog;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public CUser getCUser() {
		return this.CUser;
	}

	public void setCUser(CUser CUser) {
		this.CUser = CUser;
	}

}