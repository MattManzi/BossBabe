package control.controlAccessori;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bean.Accessori;
import model.AccessoriModel;
import utils.Validator;


@WebServlet("/Admin/AggiuntaAccessoriControl")
public class AggiuntaAccessoriControl extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public AggiuntaAccessoriControl() {
	super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		AccessoriModel am = new AccessoriModel();
		String redirectedPage = "/Admin/Accessori.jsp";

		String nome = request.getParameter("nomeAc");
		String tipo=request.getParameter("tipoAc");
		String descrizione=request.getParameter("descrizioneAc");
		String colore = request.getParameter("coloreAc");
		System.out.println(nome +""+ descrizione + ""+ colore);
		try {
			if (!nome.equals("") && !descrizione.equals("")) {
					Validator validator = new Validator();
					if (validator.validaRequest(request)) {						
						Accessori a = new Accessori(nome ,tipo, 0 ,descrizione, colore, 0);
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
