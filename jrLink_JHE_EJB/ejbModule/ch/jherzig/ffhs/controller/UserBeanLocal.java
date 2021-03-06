package ch.jherzig.ffhs.controller;

import java.util.Collection;
import javax.ejb.Local;

import ch.jherzig.ffhs.model.User;

@Local
public interface UserBeanLocal {
	
	public User getByKey(Long key);
	public Collection<User> getUserList();
	public void update(User user);
	public void create(User user);
	public void delete(User user);
	public User getByNick(String nick);

}
