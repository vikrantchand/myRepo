package training.impetus.tp.services;

import org.springframework.stereotype.Component;

import training.impetus.tp.VO.PassengerDetailsVo;
@Component
public interface TicketBookingService {
	
	public String bookTicket(PassengerDetailsVo passengerDetailsVo);
	
}
