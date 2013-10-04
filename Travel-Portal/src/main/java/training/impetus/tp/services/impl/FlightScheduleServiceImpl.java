package training.impetus.tp.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import training.impetus.tp.VO.FlightListVO;
import training.impetus.tp.VO.FlightScheduleVO;
import training.impetus.tp.dao.FlightScheduleDao;
import training.impetus.tp.model.FlightEntity;
import training.impetus.tp.model.FlightRouteEntity;
import training.impetus.tp.model.FlightScheduleEntity;
import training.impetus.tp.services.FlightScheduleService;


@Component
public class FlightScheduleServiceImpl implements FlightScheduleService {
	@Autowired
	private FlightScheduleDao flightScheduleDao;

	@SuppressWarnings({ "rawtypes" })
	public List searchFlights(FlightScheduleVO flightScheduleVO) {
		
		System.out.println("IN services");
		
		List flightList = flightScheduleDao.listFlightSchedules(flightScheduleVO);
		
		
		
		
		return flightList;
	}

}
