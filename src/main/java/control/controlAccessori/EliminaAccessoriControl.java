package control.controlAccessori;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Accessori;
import model.AccessoriModel;


@WebServlet("/Admin/EliminaAccessoriControl")
public class EliminaAccessoriControl extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public EliminaAccessoriControl() {
	super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		AccessoriModel am = new AccessoriModel();
		System.out.println("Elimina");
		String id= request.getParameter("id");
		String redirectedPage = "/Admin/Accessori.jsp";
		
		
		try {
			Accessori a=am.findByKey(id);
			am.delete(a);
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		redirectedPage = response.encodeURL(redirectedPage);
		response.sendRedirect(request.getContextPath()+ redirectedPage);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
