package com.greatlearning.tickettrackerapplication.service;

import java.util.List;

import com.greatlearning.tickettrackerapplication.model.Ticket;

public interface TicketService {

	public List<Ticket> getAllTickets();

	public Ticket createTicket(Ticket ticket);

	public Ticket getTicketById(Long id);

	public Ticket updateTicket(Ticket ticket);

	public void deleteTicket(Long id);

	public List<Ticket> searchTickets(String query);

}
