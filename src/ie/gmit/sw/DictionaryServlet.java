package ie.gmit.sw;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(asyncSupported = true)
public class DictionaryServlet extends HttpServlet {
	// Marshalling
	private static final long serialVersionUID = 999L;
	
	// GET method
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Instance of Client passing in the searchWord to be processed
		Client c = new Client(request.getParameter("searchWord"));
		
		// Attempted to do some cool loading screen stuff - failed miserably
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.print("<html><head><title>Distributed Systems Assignment</title>");		
//		out.print("</head>");		
//		out.print("<body>");
//		out.print("Processing job number#"+c.getJobId());
//		out.print("</body>");	
//		out.print("</html>");
		
		// This is the code to keep polling the server - was unable to implement unfortuantely due to time constraints.
//		out.print("<script>");
//		out.print("var wait=setTimeout(\"document.frmRequestDetails.submit();\", 10000);");
//		out.print("</script>");
		
		// Invoke the getWord method to process and remove the searchword from inQueue and add the definition to the outQueue
		try{
			c.getWord();
		}catch(Exception e){
			System.out.println(e.toString());
		}
		
		try{
			// Sleep the thread to mimic asychronous calls
			Thread.sleep(1000);
			
			// Set two parameters b,a to the jobid and word definition
			String b = Integer.toString(c.getJobId());
			String a = c.getDefinition();
			
			// Set request attributes to a,b to be used in client
			request.setAttribute("definition", a);
			request.setAttribute("JobNumber", b);
			
			// Forward the request into the result jsp page
			RequestDispatcher rd=request.getRequestDispatcher("/result.jsp");
			rd.forward(request, response);
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	// Delegate work to the GET method.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
