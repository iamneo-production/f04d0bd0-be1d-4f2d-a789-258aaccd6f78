package controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dao.IBooking;
import model.Booking;

@RestController
public class BookingController {
	@Autowired
	IBooking booking;
	
	@GetMapping("allBooking")
	public List<Booking> allBooking(){
		return booking.findAll();
	}
	
	@PostMapping("book")
	public String booked(@RequestBody Booking b) {
		booking.save(b);
		return "Movie Booked";
	}
	
	@DeleteMapping("cancelBooking/{id}")
	public String booked(@PathVariable("id") int id) {
		booking.deleteById(id);
		return "Booking Cancelled";
	}
	

	@GetMapping("admin/allBooking")
	public List<Booking> allBookings(){
		return booking.findAll();
	}
}

