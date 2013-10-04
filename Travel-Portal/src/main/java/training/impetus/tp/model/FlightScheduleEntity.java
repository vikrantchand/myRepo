package training.impetus.tp.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table(name = "schedules")
public class FlightScheduleEntity {
	@Id
	private String scheduleId;
	private Date departureDate;
	private Date arrivalDate;
	private Integer seatsAvailable;
	private String departureTime;
	@Override
	public String toString() {
		return "FlightScheduleEntity [scheduleId=" + scheduleId
				+ ", departureDate=" + departureDate + ", arrivalDate="
				+ arrivalDate + ", seatsAvailable=" + seatsAvailable
				+ ", departureTime=" + departureTime + ", ArrivalTime="
				+ ArrivalTime + ", fare=" + fare + ", flightRouteEntity="
				+ flightRouteEntity + ", flightEntity=" + flightEntity + "]";
	}

	private String ArrivalTime;
	private Integer fare;
	@ManyToOne
	@JoinColumn(name = "routeId")
	private FlightRouteEntity flightRouteEntity;

	@ManyToOne
	@JoinColumn(name = "flightId")
	private FlightEntity flightEntity;

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public FlightRouteEntity getFlightRouteEntity() {
		return flightRouteEntity;
	}

	public void setFlightRouteEntity(FlightRouteEntity flightRouteEntity) {
		this.flightRouteEntity = flightRouteEntity;
	}


	
	public String getArrivalTime() {
		return ArrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		ArrivalTime = arrivalTime;
	}

	public String getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public Integer getFare() {
		return fare;
	}

	public void setFare(Integer fare) {
		this.fare = fare;
	}

	public Integer getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(Integer seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public FlightEntity getFlightEntity() {
		return flightEntity;
	}

	public void setFlightEntity(FlightEntity flightEntity) {
		this.flightEntity = flightEntity;
	}

}
