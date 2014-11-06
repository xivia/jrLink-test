package ch.jherzig.ffhs.controller;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import ch.jherzig.ffhs.model.User;

/**
 * Session Bean implementation class LoginBean
 */
@Stateless
@LocalBean
public class LoginBean implements LoginBeanLocal {

	private User user = null;
	private Boolean login;
    /**
     * Default constructor. 
     */
    public LoginBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public User getUser() {
		return user;
	}

	@Override
	public void setLogin(Boolean login) {
		this.login = login;
		
	}

	@Override
	public Boolean getLogin() {
		return login;
	}

}
