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


@WebServlet("/Admin/VisualizzaAbbigliamentoControl")
public class VisualizzaAbbigliamentoControl extends HttpServlet{
	private static final long serialVersionUID = 1L;

    public VisualizzaAbbigliamentoControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		AbbigliamentoModel am = new AbbigliamentoModel();

		String redirectedPage = "/Admin/Abbigliamento.jsp";
		
		try {
			System.out.println("Abbigliamentocontrol-- findAll");
			ArrayList<Abbigliamento> a=am.findAll("");

			request.setAttribute("abbigliamento", a);

			redirectedPage = "/Admin/Abbigliamento.jsp";
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
