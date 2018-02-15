package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.beans.editors.EnumEditor;

/**
 * Servlet implementation class Login
 */
@WebServlet({"/Login","/login"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private int counter;
    /**
     * @see HttpServlet#HttpServlet()
     */
    
    
      
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		counter=0;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		counter++;
		Enumeration e =request.getParameterNames();
		PrintWriter pw= response.getWriter();
		pw.append("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"UTF-8\">\r\n" + 
				"<title>Insert title here</title>\r\n" + 
				"</head>\r\n" + 
				"<body>");
		while (e.hasMoreElements()) {
			Object object = (Object) e.nextElement();
			System.out.println(object);
			pw.append(object+"="+request.getParameter(object.toString()));
			pw.append("<br>");
		}
		pw.append("szamlalo: "+counter);
		pw.flush();
		HttpSession hs=request.getSession();
		hs.setAttribute("loggedIn", true);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
