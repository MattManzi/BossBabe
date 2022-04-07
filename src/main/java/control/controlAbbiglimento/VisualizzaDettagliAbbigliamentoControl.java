package control.controlAbbiglimento;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Abbigliamento;
import model.AbbigliamentoModel;


@WebServlet("/VisualizzaDettagliAbbigliamentoControl")

public class VisualizzaDettagliAbbigliamentoControl extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public VisualizzaDettagliAbbigliamentoControl() {
	super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AbbigliamentoModel am= new AbbigliamentoModel();
		
		String id= request.getParameter("id");
		System.out.println("id: "+ id);
		String redirectedPage = "/VisualizzaDettagliAbbigliamento.jsp";
		
		try {
			Abbigliamento a=am.findByKey(id);
			ArrayList<Abbigliamento> al=am.findAll("");
			

			System.out.println("Dettagli Abbigliamento Control--findAllByKey");
			request.setAttribute("abbigliamento", a);
			request.setAttribute("abbigliamentol", al);
			
			redirectedPage = "/VisualizzaDettagliAbbigliamento.jsp";
			
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
