package ch.jherzig.ffhs.test;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import ch.jherzig.ffhs.controller.UserBean;
import ch.jherzig.ffhs.model.Link;

/**
 * Servlet implementation class MangerServletWsTest
 */
@WebServlet(name = "manageWsTest", urlPatterns = { "/manageWsTest" })
public class MangerServletWsTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MangerServletWsTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String urlWsTest = "/ws/wstest.jsp";
	@EJB
	private UserBean userBean;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action == null) {
			action = "";
		}

		ServletContext sc = getServletContext();

		switch (action) {
		case "todo":

			// TODO zur zeit nicht verwendet
			// break;

		default:

			RequestDispatcher rdDefault = sc.getRequestDispatcher(urlWsTest);

			rdDefault.forward(request, response);

			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// action
		String action = request.getParameter("action");
		// key
		String strID = request.getParameter("inpID");

		switch (action) {
		case "loudLink":
			Boolean loudLink = false;
			System.out.println("http://localhost:8080/jrLink_JHE_WEB/rest/service/link/print/2");

			ClientRequest clientRequest = new ClientRequest("http://localhost:8080/jrLink_JHE_WEB/rest/service/link/print/" + strID);
			Link link = null;
			try {
				ClientResponse<Link> clientResponse = clientRequest.get(Link.class);
				link = clientResponse.getEntity();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (link != null) {
				loudLink = true;
				request.setAttribute("loudLink", loudLink);
				request.setAttribute("link", link);
				System.out.println("Link Name: " + link.getName());
				System.out.println("Link Value: " + link.getValue());
				System.out.println("Link Key: " + link.getKey());
			}

			doGet(request, response);
			
			break;

		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
