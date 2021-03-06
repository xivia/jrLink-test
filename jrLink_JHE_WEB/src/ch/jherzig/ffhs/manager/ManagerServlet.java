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
import ch.jherzig.ffhs.controller.UserBean;
import ch.jherzig.ffhs.model.Role;
import ch.jherzig.ffhs.model.User;
import ch.jherzig.ffhs.resource.UrlConst;

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
	private static final String urlUserList = UrlConst.getUrluserlist();
	private static final String urlUserForm = UrlConst.getUrluserfrom();

	@EJB
	private UserBean userBean;
	private User user;
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
		
		RequestDispatcher rdDefault = sc.getRequestDispatcher( UrlConst.getIndex());

		request.setAttribute("authority", "Keine Berechtigung f�r die Benutzerverwaltung");

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
			user = userBean.getByKey(key);
		}

		ServletContext sc = getServletContext();
		Collection<Role> listRole = roleBean.getRoleList();

		switch (action) {
		case "edit":
			RequestDispatcher rdEdit = sc.getRequestDispatcher(urlUserForm);
			
			

			request.setAttribute("listrole", listRole);
			request.setAttribute("user", user);
			request.setAttribute("nextAction", "update");
			rdEdit.forward(request, response);

			break;

		case "new":

			RequestDispatcher rdNew = sc.getRequestDispatcher(urlUserForm);

			request.setAttribute("listrole", listRole);
			request.setAttribute("nextAction", "create");
			rdNew.forward(request, response);

			break;

		case "delete":

			if (user != null) {
				userBean.delete(user);
			}
			
			// fall through -> fill list
			// break;

		default:

			Collection<User> ejbResult = userBean.getUserList();

			RequestDispatcher rdDefault = sc.getRequestDispatcher(urlUserList);

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
		request.setCharacterEncoding("UTF-8");
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		User user = new User();
		Role role = new Role();
		
		// action
		String action = request.getParameter("action");
		// key
		String strKey = request.getParameter("inpKey");
		Long key = null;
		if (strKey != "") {
			key = Long.parseLong(strKey);
			user = userBean.getByKey(key);
		}
		if (request.getParameter("inprole") != "") {
			long roleKey = Long.parseLong(request.getParameter("inprole"));
			role = roleBean.getByKey(roleKey);
		}
		

		user.setName(request.getParameter("inpName"));
		user.setVorname(request.getParameter("inpVorName"));
		user.setNick(request.getParameter("inpNick"));
		user.setMail(request.getParameter("inpMail"));
		user.setPasswort(request.getParameter("inpPasswort"));
		user.setRole(role);
			

		switch (action) {
		case "update":
		
			user.setChdt(timestamp);
			userBean.update(user);
			// goto list
			doGet(request, response);

			break;
			
		case "create":

			user.setCrdt(timestamp);
			userBean.create(user);
			// goto list
			doGet(request, response);

			break;

		default:
			break;
		}
	}

}
