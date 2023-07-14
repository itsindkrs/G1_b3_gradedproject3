package com.greatlearning.tickettrackerapplication.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.tickettrackerapplication.model.Ticket;
import com.greatlearning.tickettrackerapplication.service.TicketService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("admin")
public class TicketController {
	TicketService ticketService;

	public TicketController(TicketService ticketService) {
		super();
		this.ticketService = ticketService;
	}

	@GetMapping()
	public String showTicketList(Model model) {
		model.addAttribute("tktsrvc", ticketService.getAllTickets());
		LocalDateTime now = LocalDateTime.now();
		model.addAttribute("currentDateTime", now);
		return "tickets-list";
	}

	@GetMapping("/newTicket")
	public String createTicket(Model model, HttpServletRequest request) {
		model.addAttribute("ticket", new Ticket());
		model.addAttribute("request", request);
		return "ticket";
	}

	@GetMapping("/edit/{id}")
	public String updateTicket(Model model, @PathVariable Long id, HttpServletRequest request) {
		Ticket ticket = ticketService.getTicketById(id);
		model.addAttribute("ticket", ticket);
		model.addAttribute("request", request);
		return "ticket";
	}

	@GetMapping("/view/{id}")
	public String viewTicket(Model model, @PathVariable Long id, HttpServletRequest request) {
		Ticket ticket = ticketService.getTicketById(id);
		model.addAttribute("ticket", ticket);
		model.addAttribute("request", request);
		return "ticket";
	}

	@GetMapping("/delete/{id}")
	public String deleteTicket(Model model, @PathVariable Long id) {
		ticketService.deleteTicket(id);
		return "redirect:/admin";
	}

	@GetMapping("/tickets/search")
	public String searchTickets(Model model, @RequestParam("query") String query) {
		model.addAttribute("tktsrvc", ticketService.searchTickets(query));
		return "tickets-list";
	}

	@PostMapping("/saveTicket")
	public String saveTicket(Model model, @ModelAttribute("ticket") Ticket ticket) {
		ticketService.updateTicket(ticket);
		return "redirect:/admin";
	}

}
