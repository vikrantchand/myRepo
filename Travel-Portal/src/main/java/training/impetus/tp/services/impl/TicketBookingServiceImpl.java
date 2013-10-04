package training.impetus.tp.services.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import training.impetus.tp.VO.PassengerDetailsVo;
import training.impetus.tp.dao.FlightScheduleDao;
import training.impetus.tp.model.FlightScheduleEntity;
import training.impetus.tp.model.PassengerEntity;
import training.impetus.tp.services.TicketBookingService;

@Component
public class TicketBookingServiceImpl implements TicketBookingService {
	@Autowired
	private FlightScheduleDao flightScheduleDao;
	
	
	
	public String bookTicket(PassengerDetailsVo passengerDetailsVo) {
		System.out.println("in services");
		Integer noOfPassengers;
		Integer seatsAvailable;
		List<PassengerEntity> passengerList = passengerDetailsVo
				.getPassengerList();
		noOfPassengers = passengerDetailsVo.getNoOfPassengers();
		FlightScheduleEntity flightScheduleEntity = flightScheduleDao
				.loadScheduleById(passengerDetailsVo.getScheduleId());
		seatsAvailable = flightScheduleEntity.getSeatsAvailable();
		if (seatsAvailable >= noOfPassengers) {
			flightScheduleEntity.setSeatsAvailable(decreaseSeats(
					seatsAvailable, noOfPassengers));
			System.out.println("updatinmg Services");
			flightScheduleEntity = flightScheduleDao
					.update(flightScheduleEntity);
			
	}
		flightScheduleEntity = flightScheduleDao
				.update(flightScheduleEntity);
		return null;
	}

	public Integer decreaseSeats(Integer seatsAvailable, Integer noOfPassengers) {
		return seatsAvailable - noOfPassengers;
	}

}
