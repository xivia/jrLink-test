package ch.jherzig.ffhs.controller;

import java.util.Collection;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
		User dbUser = getByKey(user.getKey());
		dbUser.setName(user.getName());
		dbUser.setNick(user.getNick());
		dbUser.setMail(user.getMail());
		
		em.merge(dbUser);
		em.flush();
	}

	@Override
	public void create(User user) {
		User dbUser = new User();
		dbUser.setName(user.getName());
		dbUser.setNick(user.getNick());
		dbUser.setMail(user.getMail());
		
		em.persist(dbUser);
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
	

}
