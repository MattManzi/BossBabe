package control.controlScarpe;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ScarpeModel;
import bean.Scarpe;

@WebServlet("/Admin/EliminaScarpaControl")
public class EliminaScarpaControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public EliminaScarpaControl(){
		super();
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		ScarpeModel sm = new ScarpeModel();
		System.out.println("Elimina");
		String id= request.getParameter("id");
		String redirectedPage = "/Admin/Scarpe.jsp";
		
		
		try {
			Scarpe s=sm.findByKey(id);
			sm.delete(s);
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
