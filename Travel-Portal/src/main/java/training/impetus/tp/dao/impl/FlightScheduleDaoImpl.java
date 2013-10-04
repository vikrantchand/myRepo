package training.impetus.tp.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import training.impetus.tp.VO.FlightScheduleVO;
import training.impetus.tp.commons.dao.GenericJpaDao;
import training.impetus.tp.dao.FlightScheduleDao;
import training.impetus.tp.model.FlightScheduleEntity;

@Component
public class FlightScheduleDaoImpl extends
		GenericJpaDao<FlightScheduleEntity, Long> implements FlightScheduleDao {

	public FlightScheduleDaoImpl() {
		super(FlightScheduleEntity.class);
	}
	


	public List<FlightScheduleEntity> listFlightSchedules(
			FlightScheduleVO flightScheduleVO) {
		
		Query query = getEntityManager()
				.createQuery(
						" select x from  FlightScheduleEntity x join x.flightEntity join x.flightRouteEntity where x.flightRouteEntity.departureCity=? and  x.flightRouteEntity.destinationCity=? and x.departureDate=? and seatsavailable>=?");
		System.out.println("In Dao 2");
		query.setParameter(1, flightScheduleVO.getCityFrom());
		query.setParameter(2, flightScheduleVO.getCityTo());
		query.setParameter(3, flightScheduleVO.getDepartureDate());
		query.setParameter(4, flightScheduleVO.getTotalAdults());

		 List<FlightScheduleEntity> list = query.getResultList();


		return list;
	}

	public boolean checkAvailable(String scheduleId, Integer noOfPassengers) {
		Assert.notNull(scheduleId);

		Query query = getEntityManager().createQuery(
				"select u from " + getPersistentClass().getSimpleName()
						+ " u where u.scheduleId = :scheduleId").setParameter(
				"scheduleId", scheduleId);

		FlightScheduleEntity flightScheduleEntity = (FlightScheduleEntity) query
				.getSingleResult();

		return flightScheduleEntity.getSeatsAvailable() > noOfPassengers;

	}

	public FlightScheduleEntity loadScheduleById(String scheduleId) {
		Assert.notNull(scheduleId);

		Query query = getEntityManager().createQuery(
				"select u from " + getPersistentClass().getSimpleName()
						+ " u where u.scheduleId = :scheduleId").setParameter(
				"scheduleId", scheduleId);

		FlightScheduleEntity flightScheduleEntity = (FlightScheduleEntity) query
				.getSingleResult();

		return flightScheduleEntity;
	}
	
	

}
