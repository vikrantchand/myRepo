package training.impetus.tp.VO;

import org.springframework.stereotype.Component;

import training.impetus.tp.model.FlightEntity;
import training.impetus.tp.model.FlightRouteEntity;
import training.impetus.tp.model.FlightScheduleEntity;

@Component
public class FlightListVO {


	private FlightScheduleEntity flightScheduleEntity;
	private Integer noOfPassengers;
	

	
	public FlightScheduleEntity getFlightScheduleEntity() {
		return flightScheduleEntity;
	}

	public void setFlightScheduleEntity(
			FlightScheduleEntity flightScheduleEntity) {
		this.flightScheduleEntity = flightScheduleEntity;
	}

	public Integer getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(Integer noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	

}
