package com.uca.cinema.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uca.cinema.domain.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{
	
	@Query(nativeQuery = true, value = "SELECT * FROM ticket t INNER JOIN showtime s ON t.id_showtime = s.id_showtime "
			+ "INNER JOIN movie m ON m.id_movie = s.id_movie INNER JOIN c_user u ON u.id_user = t.id_user WHERE u.id_user = ?1 AND t.purchase_date BETWEEN ?2 AND ?3 ORDER BY t.id_ticket")
	public List<Ticket> getAllTicketsByNameBetweenDates(Integer user_id, Date fromDate, Date toDate);
	
}