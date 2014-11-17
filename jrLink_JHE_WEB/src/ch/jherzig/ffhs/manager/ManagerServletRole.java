package ch.jherzig.ffhs.manager;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ch.jherzig.ffhs.controller.LoginBeanLocal;
import ch.jherzig.ffhs.controller.RoleBean;
import ch.jherzig.ffhs.model.Role;

/**
 * Servlet implementation class ManagerServletRole
 */
@WebServlet("/manageRole")
public class ManagerServletRole extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerServletRole() {
		super();

	}

	// redirect urls
	private static final String urlRoleList = "/rolelist.jsp";
	private static final String urlRoleForm = "/roleform.jsp";
	@EJB
	private RoleBean roleBean;

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

	private void isLogout(HttpServletRequest request, HttpServletResponse response) {
		ServletContext sc = getServletContext();
		
		RequestDispatcher rdDefault = sc.getRequestDispatcher( "/index.jsp");

		request.setAttribute("authority", "Keine Berechtigung für die Rollenverwaltung");

		try {
			rdDefault.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void isLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Role role = new Role();
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
			role = roleBean.getByKey(key);
		}

		ServletContext sc = getServletContext();

		switch (action) {
		case "edit":
			RequestDispatcher rdEdit = sc.getRequestDispatcher(urlRoleForm);

			request.setAttribute("role", role);
			request.setAttribute("nextAction", "update");
			rdEdit.forward(request, response);

			break;

		case "new":

			RequestDispatcher rdNew = sc.getRequestDispatcher(urlRoleForm);

			request.setAttribute("nextAction", "create");
			rdNew.forward(request, response);

			break;

		case "delete":

			if (role != null) {
				roleBean.delete(role);
			}

			// fall through -> fill list
			// break;

		default:

			Collection<Role> ejbResult = roleBean.getRoleList();

			RequestDispatcher rdDefault = sc.getRequestDispatcher(urlRoleList);

			request.setAttribute("resultList", ejbResult);
			rdDefault.forward(request, response);

			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Role role = new Role();
		request.setCharacterEncoding("UTF-8");
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());

		// action
		String action = request.getParameter("action");
		// key
		String strKey = request.getParameter("inpKey");
		Long key = null;
		if (strKey != "") {
			key = Long.parseLong(strKey);
			role = roleBean.getByKey(key);
		}

		role.setName(request.getParameter("inpName"));

		switch (action) {
		case "update":

			role.setChdt(timestamp);
			roleBean.update(role);
			// goto list
			doGet(request, response);

			break;

		case "create":

			role.setCrdt(timestamp);
			roleBean.create(role);
			// goto list
			doGet(request, response);

			break;

		default:
			break;
		}
	}

}
