package training.impetus.tp.VO;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import training.impetus.tp.model.PassengerEntity;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class PassengerDetailsVo {


	private List <PassengerEntity> passengerList;
	private Integer noOfPassengers;
	private String scheduleId;

	



	

	public List<PassengerEntity> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(List<PassengerEntity> passengerList) {
		this.passengerList = passengerList;
	}

	@Override
	public String toString() {
		return "PassengerDetailsVo [passengerList=" + passengerList
				+ ", noOfPassengers=" + noOfPassengers + ", scheduleId="
				+ scheduleId + "]";
	}

	public Integer getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(Integer noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	public String getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}

}
