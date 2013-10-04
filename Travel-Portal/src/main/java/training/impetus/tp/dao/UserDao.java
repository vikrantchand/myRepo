package training.impetus.tp.dao;

import org.springframework.stereotype.Component;

import training.impetus.tp.commons.dao.GenericDao;
import training.impetus.tp.model.UserEntity;

/**
 * Data access object interface to work with User entity database operations.
 * 
 * @author Vikrant Chand
 */
@Component
public interface UserDao extends GenericDao<UserEntity, Long> {

	/**
	 * Queries database for user name availability
	 * 
	 * @param userName
	 * @return true if available
	 */
	boolean checkAvailable(String userName);

	/**
	 * Queries user by username
	 * 
	 * @param userName
	 * @return User entity
	 */
	UserEntity loadUserByUserName(String userName);
}
