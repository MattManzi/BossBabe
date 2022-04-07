package control.controlAbbiglimento;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Abbigliamento;
import model.AbbigliamentoModel;


@WebServlet("/Admin/NewAbbigliamentoControl")
public class NewAbbigliamentoControl extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public NewAbbigliamentoControl() {
	super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		AbbigliamentoModel am = new AbbigliamentoModel();
		String redirectedPage = "/Admin/Abbigliamento.jsp";

		String codice = request.getParameter("id");

		System.out.println("Sono in modifica");

		try {

			Abbigliamento a = am.findByKey(codice);
			System.out.println(a.isNuovo());
			am.newProdotto(a);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		redirectedPage = response.encodeURL(redirectedPage);
		response.sendRedirect(request.getContextPath() + redirectedPage);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
