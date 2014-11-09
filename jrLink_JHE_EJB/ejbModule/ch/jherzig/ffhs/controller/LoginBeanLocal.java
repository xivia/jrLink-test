package ch.jherzig.ffhs.controller;

import javax.ejb.Local;

import ch.jherzig.ffhs.model.User;

@Local
public interface LoginBeanLocal {
	public void setUser(User user);
	public User getUser();
	public Boolean getLogin();
	public void setLogin(Boolean login);

}
