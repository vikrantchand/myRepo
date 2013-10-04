package training.impetus.tp.services;

import java.util.List;

import org.springframework.stereotype.Component;

import training.impetus.tp.VO.FlightScheduleVO;

/**
 * Gives the services of searching flights
 * @author vikrant.chand
 *
 */
@Component
public interface FlightScheduleService {
	
	public List searchFlights(FlightScheduleVO flightScheduleVO);
	
	
	
	
	
	

}
