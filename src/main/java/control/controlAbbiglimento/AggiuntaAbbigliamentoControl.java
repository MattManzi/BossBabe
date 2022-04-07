package control.controlAbbiglimento;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Abbigliamento;
import model.AbbigliamentoModel;
import utils.Validator;


@WebServlet("/Admin/AggiuntaAbbigliamentoControl")
public class AggiuntaAbbigliamentoControl extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public AggiuntaAbbigliamentoControl() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		AbbigliamentoModel am = new AbbigliamentoModel();
		String redirectedPage = "/Admin/Abbigliamento.jsp";

		String nome = request.getParameter("nomeA");
		String tipo=request.getParameter("tipoA");
		String descrizione=request.getParameter("descrizioneA");
		String colore = request.getParameter("coloreA");
		String taglia ="0-0-0-0-0";
		System.out.println(nome +""+ descrizione + ""+ colore);
		try {
			if (!nome.equals("") && !descrizione.equals("")) {
					Validator validator = new Validator();
					if (validator.validaRequest(request)) {						
						Abbigliamento a = new Abbigliamento(nome, tipo ,descrizione, colore, taglia, 0);
						am.save(a);
					} else {
						request.setAttribute("msgError", "Dati inseriti non validi.");
						throw new Exception("AggiuntaScarpeControl: Errore Dati Non Validi");
					}

				}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		redirectedPage = response.encodeURL(redirectedPage);
		response.sendRedirect(request.getContextPath() + redirectedPage);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
