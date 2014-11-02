package ch.jherzig.ffhs.test;

import java.io.IOException;
import java.util.Collection;

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
		// TODO Auto-generated constructor stub
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

		ServletContext sc = getServletContext();

		switch (action) {
		case "test":

			break;

		default:
			// TODO Anzeige im jsp funktioniert noch nicht
			
			// fill list
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
		// TODO Auto-generated method stub
	}

}
