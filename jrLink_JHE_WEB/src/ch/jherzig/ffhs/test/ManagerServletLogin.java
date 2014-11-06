package ch.jherzig.ffhs.test;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.jherzig.ffhs.model.Role;
import ch.jherzig.ffhs.model.User;

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
        // TODO Auto-generated constructor stub
    }
    
    private String urlLoginForm = "/loginform.jsp";
    private String urlindex = "/index.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}


		ServletContext sc = getServletContext();

		switch (action) {
		case "edit":


			break;

		default:


			RequestDispatcher rdDefault = sc.getRequestDispatcher(urlLoginForm);

			rdDefault.forward(request, response);

			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = getServletContext();
		
		User user = new User();
		
		user.setNick(request.getParameter("inpNick"));
		user.setPasswort(request.getParameter("inpPasswort"));
		
		System.out.println("Nick: "+user.getNick());
		System.out.println("Passwort: "+ user.getPasswort());
		
		
		request.setAttribute("inpNick", user.getNick());
		request.setAttribute("inpPasswort", user.getPasswort());
		RequestDispatcher rdDefault = sc.getRequestDispatcher(urlindex);

		rdDefault.forward(request, response);
	}

}
