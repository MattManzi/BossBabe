package control.controlScarpe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bean.Scarpe;
import model.ScarpeModel;
import utils.Validator;

@WebServlet("/Admin/ModificaScarpeControl")
public class ModificaScarpeControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModificaScarpeControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		ScarpeModel sm = new ScarpeModel();
		String redirectedPage = "/Admin/Scarpe.jsp";

		System.out.println("Sono in modifica");

		String codice = request.getParameter("id");
		String prezzo = request.getParameter("prezzoS");
		String taglia = "";

		for (int i = 0; i < 11; i++) {
			String valore = request.getParameter("Taglia" + i);

			taglia += valore;
			if (i < 10) {
				taglia += "-";
			}
			System.out.println(taglia);
		}

		System.out.println(taglia);

		try {
			if (!prezzo.equals("") || !taglia.equals("")) {
				Validator validator = new Validator();
				Scarpe s = sm.findByKey(codice);

				if (!prezzo.equals("")) {
					if (validator.valida(prezzo, "prezzoS")) {
						s.setPrezzo(Double.parseDouble(prezzo));
					} else {
						request.setAttribute("msgErrorNomeVinile", "Nome non valido");
						throw new Exception("ModificaVinileControl: Dati Non Validi");
					}
				}
				if (!taglia.equals("")) {
					if (validator.valida(taglia, "tagliaS")) {
						s.setTaglia(taglia);
					} else {
						request.setAttribute("msgErrorGiriVinile", "Giri non valido");
						throw new Exception("ModificaVinileControl: Dati Non Validi");
					}
				}
				sm.update(s);
			} else {
				request.setAttribute("msgError", "Nassun Dato inserito");
				throw new Exception("ModificaVinileControl: Dati Non Inseriti");
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
