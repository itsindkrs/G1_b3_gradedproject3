package com.greatlearning.tickettrackerapplication.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.greatlearning.tickettrackerapplication.model.Ticket;

public interface TicketDao extends JpaRepository<Ticket, Long> {

	@Query("SELECT t FROM Ticket t WHERE LOWER(t.title) LIKE %:query%")
	List<Ticket> searchTickets(@Param("query") String query);

}
