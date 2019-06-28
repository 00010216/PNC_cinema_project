package com.uca.cinema.service;

import java.util.Date;
import java.util.List;

import com.uca.cinema.domain.Ticket;

public interface TicketInterface {
	public List<Ticket> getAllTicketsByNameBetweenDates(Integer user_id, Date fromDate, Date toDate);
}
