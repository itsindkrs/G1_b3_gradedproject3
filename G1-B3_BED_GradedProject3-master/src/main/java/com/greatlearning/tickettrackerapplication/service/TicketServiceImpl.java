package com.greatlearning.tickettrackerapplication.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.tickettrackerapplication.dao.TicketDao;
import com.greatlearning.tickettrackerapplication.model.Ticket;

@Service
public class TicketServiceImpl implements TicketService {
	TicketDao ticketDao;

	public TicketServiceImpl(TicketDao ticketDao) {
		super();
		this.ticketDao = ticketDao;
	}

	@Override
	public List<Ticket> getAllTickets() {
		// TODO Auto-generated method stub
		return ticketDao.findAll();
	}

	@Override
	public Ticket createTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return ticketDao.save(ticket);
	}

	@Override
	public Ticket getTicketById(Long id) {
		// TODO Auto-generated method stub
		return ticketDao.findById(id).get();
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return ticketDao.save(ticket);
	}

	@Override
	public void deleteTicket(Long id) {
		// TODO Auto-generated method stub
		ticketDao.deleteById(id);

	}

	@Override
	public List<Ticket> searchTickets(String query) {
		return ticketDao.searchTickets(query);
	}

}
