package control.controlScarpe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.*;
import model.*;
import utils.Validator;

@WebServlet("/Admin/AggiuntaScarpeControl")
public class AggiuntaScarpeControl extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	
	public AggiuntaScarpeControl() {
		super();
		}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		ScarpeModel sm = new ScarpeModel();
		String redirectedPage = "/Admin/Scarpe.jsp";

		String nome = request.getParameter("nomeS");
		String descrizione=request.getParameter("descrizioneS");
		String colore = request.getParameter("coloreS");
		String taglia ="0-0-0-0-0-0-0-0-0-0-0";
		System.out.println(nome +""+ descrizione + ""+ colore);
		try {
			if (!nome.equals("") && !descrizione.equals("")) {
					Validator validator = new Validator();
					if (validator.validaRequest(request)) {						
						Scarpe s = new Scarpe(nome, descrizione, colore, taglia, 0);
						sm.save(s);
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
