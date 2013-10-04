package training.impetus.tp.VO;


import java.sql.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightScheduleVO {
	
	private String cityFrom="";
	private String cityTo="";
	private Date departureDate;
	private Date returnDate;
	private String isOneWay="";
	private String isDirect="";
	private Integer totalAdults=1;
	private Integer totalChildern=0;
	private String seatCatagory="Economy"; 
	private String airlines;
	public String getCityFrom() {
		return cityFrom;
	}
	
	public void setCityFrom(String cityFrom) {
		this.cityFrom = cityFrom;
	}
	public String getCityTo() {
		return cityTo;
	}
	public void setCityTo(String cityTo) {
		this.cityTo = cityTo;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate=departureDate;
	}
	public String getIsOneWay() {
		return isOneWay;
	}
	public void setIsOneWay(String isOneWay) {
		this.isOneWay = isOneWay;
	}
	public String getIsDirect() {
		return isDirect;
	}
	public void setIsDirect(String isDirect) {
		this.isDirect = isDirect;
	}
	public Integer getTotalAdults() {
		return totalAdults;
	}
	public void setTotalAdults(Integer totalAdults) {
		this.totalAdults = totalAdults;
	}
	public Integer getTotalChildern() {
		return totalChildern;
	}
	public void setTotalChildern(Integer totalChildern) {
		this.totalChildern = totalChildern;
	}
	public String getSeatCatagory() {
		return seatCatagory;
	}
	public void setSeatCatagory(String seatCatagory) {
		this.seatCatagory = seatCatagory;
	}
	public String getAirlines() {
		return airlines;
	}
	public void setAirlines(String airlines) {
		this.airlines = airlines;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	@Override
	public String toString() {
		return "FlightScheduleVO [cityFrom=" + cityFrom + ", cityTo="
				+ cityTo + ", departureDate=" + departureDate + ", isOneWay="
				+ isOneWay + ", isDirect=" + isDirect + ", totalAdults=" + totalAdults
				+ ", totalChildern=" + totalChildern + ", seatCatagory="
				+ seatCatagory + ", airlines=" + airlines + "]";
	}

}
