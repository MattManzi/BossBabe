package control.controlAccessori;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Accessori;
import model.AccessoriModel;



@WebServlet("/VisualizzaDettagliAccessoriControl")
public class VisualizzaDettagliAccessoriControl extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public VisualizzaDettagliAccessoriControl() {
	super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AccessoriModel am= new AccessoriModel();
		
		String id= request.getParameter("id");
		System.out.println("id: "+ id);
		String redirectedPage = "/VisualizzaDettagliAccessori.jsp";
		
		try {
			Accessori a=am.findByKey(id);
			ArrayList<Accessori> al=am.findAll("");
			

			System.out.println("SottoScarpeControl--findAllByKey");
			request.setAttribute("accessori", a);
			request.setAttribute("accessoril", al);
			redirectedPage = "/VisualizzaDettagliAccessori.jsp";
			
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
