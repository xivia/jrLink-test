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

import ch.jherzig.ffhs.controller.LinkBean;



/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/manageTestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @EJB
    private TestBean bean;
    @EJB
    private LinkBean linkBean;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext sc = getServletContext();
		String urlList = "/testListe.jsp";
		
		RequestDispatcher rdDefault = sc.getRequestDispatcher(urlList);
		
		String res = bean.sayHello("Hallo vom Servlet");
		

		request.setAttribute("result", res);
		request.setAttribute("linkKey", linkBean.getByKey(new Long(2)).getLinkey());
		request.setAttribute("linkName", linkBean.getByKey(new Long(2)).getLinname());
		request.setAttribute("linkValue", linkBean.getByKey(new Long(2)).getLinvalue());
		
		rdDefault.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
