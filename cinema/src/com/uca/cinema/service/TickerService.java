package com.uca.cinema.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.cinema.domain.Ticket;
import com.uca.cinema.repositories.TicketRepository;

@Service
public class TickerService implements TicketInterface{

	@Autowired
	TicketRepository ticketRepository;	
	
	@Override
	public List<Ticket> getAllTicketsByNameBetweenDates(Integer user_id, Date fromDate, Date toDate) {
		// TODO Auto-generated method stub
		return ticketRepository.getAllTicketsByNameBetweenDates(user_id, fromDate, toDate);
	}

}
