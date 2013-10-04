package training.impetus.tp.dao.impl;

import training.impetus.tp.commons.dao.GenericJpaDao;
import training.impetus.tp.dao.UserDao;
import training.impetus.tp.model.UserEntity;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TableGenerator;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * Data access object JPA impl to work with User entity database operations.
 * 
 * @author Vikrant Chand
 */
@Component
public class UserDaoImpl extends GenericJpaDao<UserEntity, Long> implements
		UserDao {

	public UserDaoImpl() {
		super(UserEntity.class);
	}

	/**
	 * Queries database for user name availability
	 * 
	 * @param userName
	 * @return true if available
	 */
	public boolean checkAvailable(String email) {
		System.out.println(email);
		Assert.notNull(email);

		Query query = getEntityManager().createQuery(
				"select count(*) from " + getPersistentClass().getSimpleName()
						+ " u where u.email = :email").setParameter(
				"email", email);

		Long count = (Long) query.getSingleResult();
	
		return count < 1;
	}

	/**
	 * Queries user by username
	 * 
	 * @param userName
	 * @return User entity
	 */
	public UserEntity loadUserByUserName(String userName) {
		Assert.notNull(userName);

		UserEntity user = null;

		Query query = getEntityManager().createQuery(
				"select u from " + getPersistentClass().getSimpleName()
						+ " u where u.userName = :userName").setParameter(
				"userName", userName);

		try {
			user = (UserEntity) query.getSingleResult();
		} catch (NoResultException e) {
			// do nothing
		}

		return user;
	}

}