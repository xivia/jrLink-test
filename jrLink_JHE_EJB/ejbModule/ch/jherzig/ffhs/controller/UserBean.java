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
		User user;
		user = em.find(User.class, key);
		
		return user;
	}

	@Override
	public Collection<User> getUserList() {
		return em.createNamedQuery("User.findAll", User.class).getResultList();
	}
	

}
