package ch.ffhs.jhe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.ffhs.jhe.bean.BeanTestTable;
import ch.ffhs.jhe.model.TestTable;

/**
 * Servlet implementation class TestDB
 */
@WebServlet("/TestDB")
public class ServletTestDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletTestDB() {
		super();
		// TODO Auto-generated constructor stub
	}

	@EJB
	private BeanTestTable ejbTestTable;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ServletTestDB: post");

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String requestName = request.getParameterNames().nextElement();

		switch (requestName) {
		case "getName":

			String strID = request.getParameter("getName");

			if (strID == "") {
				writer.println("Keine id eingetragen!<br>");
			} else {

				int id = Integer.parseInt(strID);
				String name = ejbTestTable.getName(id);

				writer.println("Der Name ist: " + name + "<br>");
			}

			break;
		case "setName":
			TestTable table;
			String name = request.getParameter("setName");
			table = ejbTestTable.setName(name);
			writer.println("Folgender Eintrag wurde in der DB hinzugefügt <br>");
			writer.println("ID: " + table.getId() + " <br>");
			writer.println("Namen: " + table.getValue() + " <br>");

			break;

		case "getAllName":
			String output = "<h2>Alle Einträge</h2><br>";
			System.out.println("getAllName");
			Collection<TestTable> allName = ejbTestTable.getAllTestTable();

			for (Iterator<TestTable> iterator = allName.iterator(); iterator.hasNext();) {

				TestTable testTable = (TestTable) iterator.next();
				// System.out.println(testTable.getId());
				output = output + "ID: " + testTable.getId() + " Name: "
						+ testTable.getValue() + "<br>";
			}

			writer.println(output);

		default:
			break;
		}

		writer.println("<a href='http://localhost:8080/TestJHE_DB_webapp/'>Home</a>");
	}

}
