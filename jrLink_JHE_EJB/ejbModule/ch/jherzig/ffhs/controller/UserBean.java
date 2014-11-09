package ch.jherzig.ffhs.controller;

import java.util.Collection;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ch.jherzig.ffhs.model.User;

/**
 * Session Bean implementation class UserBean
 */
@Stateless
@LocalBean
public class UserBean implements UserBeanLocal {

	/**
	 * Default constructor.
	 */
	public UserBean() {
	}

	@PersistenceContext
	private EntityManager em;

	@Override
	public User getByKey(Long key) {
		User user = null;
		user = em.find(User.class, key);

		return user;
	}

	@Override
	public Collection<User> getUserList() {
		return em.createNamedQuery("User.findAll", User.class).getResultList();
	}

	@Override
	public void update(User user) {
		if (getByKey(user.getKey()) != null) {
			em.merge(user);
			em.flush();
		}
	}

	@Override
	public void create(User user) {

		em.persist(user);
		em.flush();

	}

	@Override
	public void delete(User user) {
		User userDelete = getByKey(user.getKey());
		if (userDelete != null) {
			em.remove(userDelete);
			em.flush();
		}

	}

	@Override
	public User getByNick(String nick) {
		User user = null;
		Query query = em.createNamedQuery("User.findNick");
		try {
			user = (User) query.setParameter("nick", nick).getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		

		return user;
	}
}
