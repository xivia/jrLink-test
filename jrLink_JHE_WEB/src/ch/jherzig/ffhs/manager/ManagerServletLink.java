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

import ch.jherzig.ffhs.controller.LinkBean;
import ch.jherzig.ffhs.controller.LoginBeanLocal;
import ch.jherzig.ffhs.model.Link;

/**
 * Servlet implementation class ManagerServletLink
 */
@WebServlet("/manageLink")
public class ManagerServletLink extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerServletLink() {
		super();

	}

	private static final String urlUserList = "/linklist.jsp";
	private static final String urlUserForm = "/linkform.jsp";
	@EJB
	private LinkBean linkBean;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		LoginBeanLocal login = (LoginBeanLocal) session.getAttribute("LoginBean");
		if (login != null) {
			if (login.getLogin()) {
				isLogin(request, response);
			} else {
				isLogout(request, response);
			}
		} else {
			isLogout(request, response);
		}
	}

	private void isLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletContext sc = getServletContext();

		RequestDispatcher rdDefault = sc.getRequestDispatcher(urlUserList);

		request.setAttribute("resultList", linkBean.getLinkList());
		rdDefault.forward(request, response);

	}

	private void isLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Link link = null;
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
			link = linkBean.getByKey(key);
		}

		ServletContext sc = getServletContext();

		switch (action) {
		case "edit":
			RequestDispatcher rdEdit = sc.getRequestDispatcher(urlUserForm);

			request.setAttribute("link", link);
			request.setAttribute("nextAction", "update");
			rdEdit.forward(request, response);

			break;

		case "new":

			RequestDispatcher rdNew = sc.getRequestDispatcher(urlUserForm);

			request.setAttribute("nextAction", "create");
			rdNew.forward(request, response);

			break;

		case "delete":

			if (link != null) {
				linkBean.delete(link);
			}

			// fall through -> fill list
			// break;

		default:

			RequestDispatcher rdDefault = sc.getRequestDispatcher(urlUserList);
			
			request.setAttribute("resultList", linkBean.getLinkList());
			rdDefault.forward(request, response);

			break;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Link link = new Link();
		// action
		String action = request.getParameter("action");
		// key
		String strKey = request.getParameter("inpKey");
		Long key = null;
		if (strKey != "") {
			key = Long.parseLong(strKey);
			link = linkBean.getByKey(key);
		}

		link.setName(request.getParameter("inpName"));
		link.setValue(request.getParameter("inpValue"));

		switch (action) {
		case "update":


			linkBean.update(link);
			// goto list
			doGet(request, response);

			break;

		case "create":

			linkBean.create(link);
			// goto list
			doGet(request, response);

			break;

		default:
			break;
		}
	}

}
