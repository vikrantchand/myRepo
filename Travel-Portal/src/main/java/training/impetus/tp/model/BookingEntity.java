package training.impetus.tp.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "bookings")
public class BookingEntity {
	@Id
	private String bookingId;

	@ManyToOne
	@JoinColumn(name = "scheduleId")
	private FlightScheduleEntity flightSchedduleEntity;

	private Date bookingDate;
	private Integer pricePerSeat;

	@ElementCollection
	@CollectionTable(name = "Passengers", joinColumns = @JoinColumn(name = "ticketId"))
	@OrderColumn
	private List<PassengerEntity> passengerEntities;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private UserEntity userEntity;

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public FlightScheduleEntity getFlightSchedduleEntity() {
		return flightSchedduleEntity;
	}

	public void setFlightSchedduleEntity(
			FlightScheduleEntity flightSchedduleEntity) {
		this.flightSchedduleEntity = flightSchedduleEntity;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Integer getPricePerSeat() {
		return pricePerSeat;
	}

	public void setPricePerSeat(Integer pricePerSeat) {
		this.pricePerSeat = pricePerSeat;
	}

	public List<PassengerEntity> getPassengerEntities() {
		return passengerEntities;
	}

	public void setPassengerEntities(List<PassengerEntity> passengerEntities) {
		this.passengerEntities = passengerEntities;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

}
