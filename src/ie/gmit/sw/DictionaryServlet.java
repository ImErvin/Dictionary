package ie.gmit.sw;

import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/DictionaryServlet")
public class DictionaryServlet extends HttpServlet {
	private static final long serialVersionUID = 999L;

    public DictionaryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response, String definition) throws ServletException, IOException {
		response.getWriter().append(definition); // appends the response string to a writer object that returns the characters to the screen - buffers data to the end of a request (4)
		response.sendRedirect("index.jsp?definition=" + definition);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Client c = new Client(request.getParameter("searchWord"));
				
		try {
			Thread.sleep(1000);
			c.getWord();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		
		try{
			Thread.sleep(1000);
			doGet(request, response, c.getDefinition());
		}catch(Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		
	}

}
