package training.impetus.tp.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import training.impetus.tp.VO.FlightScheduleVO;
import training.impetus.tp.commons.dao.GenericDao;
import training.impetus.tp.model.FlightScheduleEntity;

@Component
public interface FlightScheduleDao extends GenericDao<FlightScheduleEntity,Long> {

	public List<FlightScheduleEntity> listFlightSchedules(
			FlightScheduleVO flightScheduleVO);

	boolean checkAvailable(String scheduleId, Integer noOfPassengers);

	FlightScheduleEntity loadScheduleById(String scheduleId);

}
