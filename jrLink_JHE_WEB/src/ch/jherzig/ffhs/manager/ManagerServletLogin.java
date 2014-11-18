package ch.jherzig.ffhs.manager;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ch.jherzig.ffhs.controller.LoginBean;
import ch.jherzig.ffhs.controller.LoginBeanLocal;
import ch.jherzig.ffhs.controller.UserBean;
import ch.jherzig.ffhs.model.User;
import ch.jherzig.ffhs.resource.UrlConst;

/**
 * Servlet implementation class ManagerServletLogin
 */
@WebServlet("/manageLogin")
public class ManagerServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerServletLogin() {
		super();

	}

	private String urlLoginForm = UrlConst.getUrlloginform();

	@EJB
	private UserBean userBean;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = null;
		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}
		// key
		String strKey = request.getParameter("key");
		Long key = new Long(0);
		if (strKey != null) {
			key = Long.parseLong(strKey);
			user = userBean.getByKey(key);
		}

		ServletContext sc = getServletContext();
		HttpSession session = request.getSession();

		switch (action) {
		case "logout":

			LoginBeanLocal login = (LoginBeanLocal) session.getAttribute("LoginBean");

			if (login == null) {
				login = new LoginBean();
			}

			if (login.getUser().getKey() == user.getKey()) {
				login.setLogin(false);
				login.setUser(new User());
			}
			session.setAttribute("LoginBean", login);

			RequestDispatcher rdLogout = sc.getRequestDispatcher(UrlConst.getIndex());

			rdLogout.forward(request, response);

			break;

		default:

			RequestDispatcher rdDefault = sc.getRequestDispatcher(urlLoginForm);

			rdDefault.forward(request, response);

			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();

		HttpSession session = request.getSession();
		LoginBeanLocal login = (LoginBeanLocal) session.getAttribute("LoginBean");

		if (login == null) {
			login = new LoginBean();
		}

		User user = userBean.getByNick((String) request.getParameter("inpNick"));

		if (user != null) {
			if (user.getPasswort().equals(request.getParameter("inpPasswort"))) {
				login.setUser(user);
				login.setLogin(true);
			}
		}

		session.setAttribute("LoginBean", login);

		RequestDispatcher rdDefault = sc.getRequestDispatcher(UrlConst.getIndex());

		rdDefault.forward(request, response);

	}

}
