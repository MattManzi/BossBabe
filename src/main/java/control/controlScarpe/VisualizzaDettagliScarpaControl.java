package control.controlScarpe;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Scarpe;
import model.ScarpeModel;

@WebServlet("/VisualizzaDettagliScarpaControl")
public class VisualizzaDettagliScarpaControl extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	public VisualizzaDettagliScarpaControl() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ScarpeModel sm= new ScarpeModel();
		
		String id= request.getParameter("id");
		System.out.println("id: "+ id);
		String redirectedPage = "/VisualizzaDettagliScarpa.jsp";
		
		try {
			Scarpe s=sm.findByKey(id);
			ArrayList<Scarpe> sl=sm.findAll("");
			

			System.out.println("SottoScarpeControl--findAllByKey");
			request.setAttribute("scarpa", s);
			request.setAttribute("scarpel", sl);
			redirectedPage = "/VisualizzaDettagliScarpa.jsp";
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		

		redirectedPage = response.encodeURL(redirectedPage);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(redirectedPage);
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
