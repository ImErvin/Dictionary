package ie.gmit.sw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(asyncSupported = true)
public class DictionaryServlet extends HttpServlet {
	private static final long serialVersionUID = 999L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Client c = new Client(request.getParameter("searchWord"));
		
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.print("<html><head><title>Distributed Systems Assignment</title>");		
//		out.print("</head>");		
//		out.print("<body>");
//		out.print("Processing job number#"+c.getJobId());
//		out.print("</body>");	
//		out.print("</html>");
//		out.print("<script>");
//		out.print("var wait=setTimeout(\"document.frmRequestDetails.submit();\", 10000);");
//		out.print("</script>");
		
		try{
			Thread.sleep(1000);
			c.getWord();
		}catch(Exception e){
			System.out.println(e.toString());
		}	
		try{
			String b = Integer.toString(c.getJobId());
			String a = c.getDefinition();
			request.setAttribute("definition", a);
			request.setAttribute("JobNumber", b);
			RequestDispatcher rd=request.getRequestDispatcher("/result.jsp");
			rd.forward(request, response);
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
