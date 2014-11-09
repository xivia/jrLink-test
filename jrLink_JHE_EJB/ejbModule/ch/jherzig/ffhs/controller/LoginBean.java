package ch.jherzig.ffhs.controller;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

import ch.jherzig.ffhs.model.User;

/**
 * Session Bean implementation class LoginBean
 */
@Stateful
@LocalBean
public class LoginBean implements LoginBeanLocal {

    private User user = null;
	private Boolean login = false;

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
		return this.user;
	}

	@Override
	public Boolean getLogin() {
		return this.login;
	}

	@Override
	public void setLogin(Boolean login) {
		this.login = login;
		
	}

}
