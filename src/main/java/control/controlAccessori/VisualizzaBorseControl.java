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

import bean.Abbigliamento;
import bean.Accessori;
import model.AbbigliamentoModel;
import model.AccessoriModel;


@WebServlet("/VisualizzaBorseControl")
public class VisualizzaBorseControl extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public VisualizzaBorseControl() {
	super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("Catalogo pantaloni....");
		AccessoriModel am = new AccessoriModel();

		String redirectedPage = "/HomePage.jsp";

		try {
			ArrayList<Accessori> a = am.findAllBorse("");

			request.setAttribute("accessori", a);

			redirectedPage = "/CatalogoAccessori.jsp";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		redirectedPage = response.encodeURL(redirectedPage);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(redirectedPage);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
