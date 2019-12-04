package pl.n2god;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author n2god on 04/12/2019
 * @project config
 */
/*@WebServlet(name = "WelcomeServlet",
		urlPatterns = "/WelcomeServlet",
		initParams = {
		@WebInitParam(name = "defaultUsername", value = "Nieznajomy"),
		@WebInitParam(name = "defaultPassword", value = "admin"),
		})*/
public class WelcomeServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		if (username == null || "".equals(username)){
			username = getServletConfig().getInitParameter("defaultUsername");
		}
		try {
			setResponse(response, username);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void setResponse(HttpServletResponse response, String username) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>");
		writer.println("Witaj " + username + "</title>" + "</head>");
		writer.println("<h1>");
		writer.println("Witaj " + username + "</h1>");
		writer.println("</html>");
	}


}
