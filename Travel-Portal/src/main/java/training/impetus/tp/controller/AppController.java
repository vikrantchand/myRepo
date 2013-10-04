package training.impetus.tp.controller;

import java.util.List;



import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import training.impetus.tp.VO.FlightScheduleVO;
import training.impetus.tp.VO.PassengerDetailsVo;
import training.impetus.tp.model.FlightScheduleEntity;
import training.impetus.tp.model.PassengerEntity;
import training.impetus.tp.model.UserAddress;
import training.impetus.tp.model.UserEntity;
import training.impetus.tp.services.FlightScheduleService;
import training.impetus.tp.services.TicketBookingService;
import training.impetus.tp.services.UserService;


/**
 * Application Controller to controller all the incoming requests from client
 * 
 * @author vikrant.chand
 */
@SessionAttributes
@Controller
public class AppController {

	/*
	 * @Autowired private ReCaptcha reCaptcha = null;
	 * 
	 */
	private static final Logger logger = Logger.getLogger(AppController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private FlightScheduleService flightScheduleService;

	@Autowired
	private TicketBookingService ticketBookingService;

	/*
	 * @RequestMapping(value = { "/static/**" }) public void
	 * serveStaticAssets(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { ServletContext
	 * servletContext = request.getSession() .getServletContext();
	 * RequestDispatcher rd = servletContext.getNamedDispatcher("default"); if
	 * (rd == null) { throw new IllegalStateException(
	 * "A RequestDispatcher could not be located for the default servlet"); }
	 * rd.forward(request, response); }
	 */

	@RequestMapping(value = { "/", "index" }, method = RequestMethod.GET)
	public String getIndexPage() {

		return "index";
	}

	@RequestMapping(value = "flights", method = RequestMethod.GET)
	public String getFlightsPage(HttpServletRequest request,
			@RequestBody String sd) {
		String s = request.getParameter("departureDate");
		System.out.println(s + sd);

		return "flights";
	}

	@RequestMapping("/Header")
	public String insertHeader() {
		// logger.info("hjfdklnsjkdfnjksdbnfjksbdfkjbskdbfksbdjkfbskjdbfjksbdfjkbsjkdbfjksbdfjkbsjkdbf sjdfjksbdkjfjkshdfjk");
		return "Header";
	}

	@RequestMapping("/login")
	public String getLoginPage() {
		return "login";
	}

	@RequestMapping("/loginfailed")
	public String getLoginFailPage(ModelMap model) {
		model.addAttribute("error", "true");
		return "login";
	}

	@RequestMapping("/Book")
	public String getBookingPage(ModelMap model) {
		model.addAttribute("error", "true");
		return "Book";
	}

	@RequestMapping("/register")
	public String getregisterPage() {

		return "Register";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public UserEntity getregisterPage1(@RequestBody String content) {
		logger.info("logger");
		ObjectMapper mapper = new ObjectMapper();
		UserEntity userEntity = null;
		UserAddress userAddress = null;
		try {
			userEntity = mapper.readValue(content, UserEntity.class);
			userAddress = mapper.readValue(content, UserAddress.class);
			userEntity.setUSER_ID((long) 10);
			logger.debug(userAddress + "vikrant123" + userEntity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (userService.createUser(userEntity)) {
			return userEntity;
		}
		return userEntity;
	}

	@RequestMapping(value = "/flight", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public List<FlightScheduleEntity> getflights(@RequestBody String content) {
		ObjectMapper mapper = new ObjectMapper();
		FlightScheduleVO flightScheduleVO = null;
		try {
			flightScheduleVO = mapper
					.readValue(content, FlightScheduleVO.class);
			System.out.println(flightScheduleVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		@SuppressWarnings("unchecked")
		List<FlightScheduleEntity> flightList = flightScheduleService
				.searchFlights(flightScheduleVO);
		return flightList;
	}

	/*@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("userInfo") UserEntity userEntity,
			BindingResult res,

			@RequestParam("recaptcha_challenge_field") String challangeField,

			@RequestParam("recaptcha_response_field") String responseField,
			ServletRequest servletRequest) {
		String remoteAddress = servletRequest.getRemoteAddr();
		ReCaptchaResponse reCaptchaResponse = this.reCaptcha.checkAnswer(
				remoteAddress, challangeField, responseField);
		System.out.println("ajax call");
		if (userService.createUser(userEntity)) {
			return "success";
		} else {
			return "Register";
		}

	}*/

	@RequestMapping(value = "travellers", method = RequestMethod.GET)
	public String fillTravellerDetails() {

		return "passengerdetails";
	}

	@RequestMapping(value = "/ticket", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public List<FlightScheduleEntity> bookTicket(@RequestBody String content,
			PassengerDetailsVo passengerDetailsVo) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			passengerDetailsVo = mapper.readValue(content,
					PassengerDetailsVo.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("1");
		String s = ticketBookingService.bookTicket(passengerDetailsVo);
		System.out.println("2");

		return null;
	}

}
