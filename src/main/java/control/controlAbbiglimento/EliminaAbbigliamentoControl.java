package control.controlAbbiglimento;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Abbigliamento;
import model.AbbigliamentoModel;


@WebServlet("/Admin/EliminaAbbigliamentoControl")
public class EliminaAbbigliamentoControl extends HttpServlet{
	private static final long serialVersionUID = 1L;

	
	public EliminaAbbigliamentoControl() {
	super();
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		AbbigliamentoModel am = new AbbigliamentoModel();
		System.out.println("Elimina");
		String id= request.getParameter("id");
		String redirectedPage = "/Admin/Abbigliamento.jsp";
		
		
		try {
			Abbigliamento a=am.findByKey(id);
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
