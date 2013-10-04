package training.impetus.tp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table(name = "flights")
public class FlightEntity {
	@Id
	private String flightId;
	private String flightProvider;
	private String arrivalTime;
	private String departureTime;
	private String source;
	private String destination;
	private Boolean isNonStop;

	@Override
	public String toString() {
		return "FlightEntity [flightId=" + flightId + ", flightProvider="
				+ flightProvider + ", arrivalTime=" + arrivalTime
				+ ", departureTime=" + departureTime + ", source=" + source
				+ ", destination=" + destination + ", isNonStop=" + isNonStop
				+ "]";
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getFlightProvider() {
		return flightProvider;
	}

	public void setFlightProvider(String flightProvider) {
		this.flightProvider = flightProvider;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Boolean getIsNonStop() {
		return isNonStop;
	}

	public void setIsNonStop(Boolean isNonStop) {
		this.isNonStop = isNonStop;
	}

}
