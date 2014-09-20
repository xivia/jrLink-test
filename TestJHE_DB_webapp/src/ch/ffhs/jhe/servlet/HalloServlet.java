package ch.ffhs.jhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.ffhs.jhe.bean.HalloBeanDBRemote;

/**
 * Servlet implementation class HalloServlet
 */
@WebServlet("/HalloServlet")
public class HalloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HalloServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@EJB
	private HalloBeanDBRemote ejb;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// setzt den Rückgabe wert auf html und erzeugt einen writer auf dem mit
		// println die Ausgabe gemacht werden kann
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println(ejb.sayHello(" Jörg Herzig", 2));
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post");
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		String name = request.getParameter("name");
		int id = Integer.parseInt(name);
		
		if (name == "") {
			System.out.println("if");
			writer.println(ejb.sayHello(" Jörg Herzig vom EJB:) ", 1));
		}
		else {
			System.out.println("else");
			writer.println(ejb.sayHello(" Jörg Herzig vom EJB with ",  id));
		}
		
	}
	

}
