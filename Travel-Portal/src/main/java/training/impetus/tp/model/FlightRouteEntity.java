package training.impetus.tp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table(name = "routes")
public class FlightRouteEntity {
	@Id
	private String routeId;
	@Override
	public String toString() {
		return "FlightRouteEntity [routeId=" + routeId + ", departureCity="
				+ departureCity + ", destinationCity=" + destinationCity + "]";
	}

	private String departureCity;
	private String destinationCity;

	public String getRouteId() {
		return routeId;
	}

	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}
}
