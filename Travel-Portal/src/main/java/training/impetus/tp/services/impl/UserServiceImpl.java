package training.impetus.tp.services.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import training.impetus.tp.commons.dao.GenericJpaDao;
import training.impetus.tp.dao.UserDao;
import training.impetus.tp.model.UserEntity;
import training.impetus.tp.services.UserService;

/**
 * Service providing service methods to work with user data and entity.
 * 
 * @author Vikrant Chand
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	/**
	 * Create user - persist to database
	 * 
	 * @param userEntity
	 * @return true if success
	 */
	
	public boolean createUser(UserEntity userEntity) {

		if (!userDao.checkAvailable(userEntity.getEmail())) {
			/**
			 * Set some error msgs
			 */

			return false;
		}

		try {
			System.out.println("saving");
			logger.debug("vikrant321"+userEntity);
			userDao.save(userEntity);
			System.out.println("Donr");
		} catch (Exception e) {
			/**
			 * Set some error msgs
			 */
			e.printStackTrace();
			return false;
		}

		return true;
	}



	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	/**
	 * Check user name availability. UI ajax use.
	 * 
	 * @param ajax
	 *            event
	 * @return
	 */
	/*
	 * public boolean checkAvailable(AjaxBehaviorEvent event) {
	 * 
	 * InputText inputText = (InputText) event.getSource(); String value =
	 * (String) inputText.getValue();
	 * 
	 * boolean available = userDao.checkAvailable(value);
	 * 
	 * if (!available) { FacesMessage message = constructErrorMessage(null,
	 * String.format(getMessageBundle().getString("userExistsMsg"), value));
	 * getFacesContext().addMessage(event.getComponent().getClientId(),
	 * message); } else { FacesMessage message = constructInfoMessage(null,
	 * String.format(getMessageBundle().getString("userAvailableMsg"), value));
	 * getFacesContext().addMessage(event.getComponent().getClientId(),
	 * message); }
	 * 
	 * return available; }
	 *//**
	 * Construct UserDetails instance required by spring security
	 */
	/*
	 * public UserDetails loadUserByUsername(String userName) throws
	 * UsernameNotFoundException {
	 * 
	 * UserEntity user = userDao.loadUserByUserName(userName);
	 * 
	 * if (user == null) { throw new
	 * UsernameNotFoundException(String.format(getMessageBundle
	 * ().getString("badCredentials"), userName)); }
	 * 
	 * Collection<GrantedAuthority> authorities = new
	 * ArrayList<GrantedAuthority>(); authorities.add(new
	 * SimpleGrantedAuthority("ROLE_USER"));
	 * 
	 * User userDetails = new User(user.getName(), user.getPassword(),
	 * authorities);
	 * 
	 * return userDetails; }
	 *//**
	 * Retrieves full User record from database by user name
	 * 
	 * @param userName
	 * @return UserEntity
	 */
	/*
	 * public UserEntity loadUserEntityByUsername(String userName) { return
	 * userDao.loadUserByUserName(userName); }
	 * 
	 * protected FacesMessage constructErrorMessage(String message, String
	 * detail){ return new FacesMessage(FacesMessage.SEVERITY_ERROR, message,
	 * detail); }
	 * 
	 * protected FacesMessage constructInfoMessage(String message, String
	 * detail) { return new FacesMessage(FacesMessage.SEVERITY_INFO, message,
	 * detail); }
	 * 
	 * protected FacesMessage constructFatalMessage(String message, String
	 * detail) { return new FacesMessage(FacesMessage.SEVERITY_FATAL, message,
	 * detail); }
	 * 
	 * protected FacesContext getFacesContext() { return
	 * FacesContext.getCurrentInstance(); }
	 * 
	 * protected ResourceBundle getMessageBundle() { return
	 * ResourceBundle.getBundle("message-labels"); }
	 * 
	 * 
	 * }
	 */







}