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

@WebServlet("/Admin/ModificaAbbigliamentoControl")
public class ModificaAbbigliamentoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModificaAbbigliamentoControl() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		AbbigliamentoModel am = new AbbigliamentoModel();
		String redirectedPage = "/Admin/Abbigliamento.jsp";

		System.out.println("Sono in modifica");

		String codice = request.getParameter("id");
		String prezzo = request.getParameter("prezzoA");
		String taglia = "";

		for (int i = 0; i < 5; i++) {
			String valore = request.getParameter("Taglia" + i);

			taglia += valore;
			if (i < 4) {
				taglia += "-";
			}
			System.out.println(taglia);
		}

		System.out.println(taglia);

		try {
			if (!prezzo.equals("") || !taglia.equals("")) {
				Validator validator = new Validator();
				Abbigliamento a = am.findByKey(codice);

				if (!prezzo.equals("")) {
					if (validator.valida(prezzo, "prezzoA")) {
						a.setPrezzo(Double.parseDouble(prezzo));
					} else {
						request.setAttribute("msgErrorNomeVinile", "Nome non valido");
						throw new Exception("ModificaVinileControl: Dati Non Validi");
					}
				}
				if (!taglia.equals("")) {
					if (validator.valida(taglia, "tagliaA")) {
						a.setTaglia(taglia);
					} else {
						request.setAttribute("msgErrorGiriVinile", "Giri non valido");
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
