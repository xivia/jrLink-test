package ch.jherzig.ffhs.controller;

import javax.ejb.Local;

import ch.jherzig.ffhs.model.User;

@Local
public interface LoginBeanLocal {
	
	public void setUser(User user);
	public User getUser();
	public void setLogin(Boolean login);
	public Boolean getLogin();

}
