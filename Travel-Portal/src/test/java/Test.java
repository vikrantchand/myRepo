import training.impetus.tp.VO.FlightScheduleVO;
import training.impetus.tp.services.impl.FlightScheduleServiceImpl;


public  class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlightScheduleVO vo=new FlightScheduleVO();
			FlightScheduleServiceImpl f=new FlightScheduleServiceImpl();
			System.out.println(f.searchFlights(vo));
	}

}
