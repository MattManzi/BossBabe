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

@WebServlet("/Admin/ModificaAccessoriControl")
public class ModificaAccessoriControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModificaAccessoriControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		AccessoriModel am = new AccessoriModel();
		String redirectedPage = "/Admin/Accessori.jsp";

		System.out.println("Sono in modifica");

		String codice = request.getParameter("id");
		String prezzo = request.getParameter("prezzoAc");
		String quantita = request.getParameter("quantitaAc");
		System.out.println("\n"+quantita+"\n");
		System.out.println("\n"+prezzo+"\n");
		try {
			if (!prezzo.equals("") || !quantita.equals("")) {
				Validator validator = new Validator();
				Accessori a = am.findByKey(codice);

				if (!prezzo.equals("")) {
					if (validator.valida(prezzo, "prezzoAc")) {
						a.setPrezzo(Double.parseDouble(prezzo));
					} else {
						request.setAttribute("msgErrorNomeVinile", "Nome non valido");
						throw new Exception("ModificaVinileControl: Dati Non Validi");
					}
				}
				if (!quantita.equals("")) {
					if (validator.valida(quantita, "quantitaAc")) {
						a.setQuantita(Integer.parseInt(quantita));
					} else {
						request.setAttribute("msgErrorNomeVinile", "Nome non valido");
						throw new Exception("ModificaVinileControl: Dati Non Validi");
					}
				}

				am.update(a);
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
