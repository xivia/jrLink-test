package ch.jherzig.ffhs.test;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.jherzig.ffhs.controller.RoleBean;
import ch.jherzig.ffhs.controller.UserBean;
import ch.jherzig.ffhs.model.User;

/**
 * Servlet implementation class ManagerServlet
 */
@WebServlet("/manage")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerServlet() {
		super();
	}

	// redirect urls
	private static final String urlUserList = "/userlist.jsp";
	private static final String urlUserForm = "/userform.jsp";

	@EJB
	private UserBean userBean;
	@EJB
	private RoleBean roleBean;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// action
		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}
		// key
		String strKey = request.getParameter("key");
		Long key = new Long(0);
		if (strKey != null) {
			key = Long.parseLong(strKey);
		}

		ServletContext sc = getServletContext();

		switch (action) {
		case "edit":
			RequestDispatcher rdEdit = sc.getRequestDispatcher(urlUserForm);

			User user = userBean.getByKey(key);

			request.setAttribute("entryKey", user.getKey());
			request.setAttribute("entryName", user.getName());
			request.setAttribute("entryNick", user.getNick());
			request.setAttribute("entryMail", user.getMail());
			request.setAttribute("nextAction", "update");
			rdEdit.forward(request, response);

			break;

		default:

			Collection<User> ejbResult = userBean.getUserList();

			RequestDispatcher rdDefault = sc.getRequestDispatcher(urlUserList);

			request.setAttribute("resultList", ejbResult);
			rdDefault.forward(request, response);

			break;
		}

		System.out.println("@WebServlet(/manage)");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// action
		String action = request.getParameter("action");
		// key
		String strKey = request.getParameter("inpKey");
		Long key = new Long(0);
		if (strKey != null) {
			key = Long.parseLong(strKey);
		}

		ServletContext sc = getServletContext();
		User user = new User();
		user.setKey(key);
		user.setName(request.getParameter("inpName"));
		user.setNick(request.getParameter("inpNick"));
		user.setMail(request.getParameter("inpMail"));

		switch (action) {
		case "update":

			userBean.update(user);
			// goto list
			doGet(request, response);

			break;

		default:
			break;
		}
	}

}
