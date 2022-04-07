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

@WebServlet("/VisualizzaScarpeCaroselControl")
public class VisualizzaScarpeCaroselControl extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public VisualizzaScarpeCaroselControl() {
	super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("Catalogo scarpeCarosel");
		ScarpeModel sm = new ScarpeModel();
		
		String redirectedPage = "/VisualizzaDettagliScarpa.jsp";
		
		try {
			ArrayList<Scarpe> s=sm.findAll("");

			
			request.setAttribute("scarpeCarosel", s);


			redirectedPage = "/VisualizzaDettagliScarpa.jsp";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		redirectedPage = response.encodeURL(redirectedPage);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(redirectedPage);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
