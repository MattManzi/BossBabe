package control.controlScarpe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Scarpe;
import model.ScarpeModel;


@WebServlet("/Admin/NewScarpeControl")
public class NewScarpeControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewScarpeControl() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		ScarpeModel sm = new ScarpeModel();
		String redirectedPage = "/Admin/Scarpe.jsp";

		String codice = request.getParameter("id");

		System.out.println("Sono in modifica");

		try {

			Scarpe s = sm.findByKey(codice);
			System.out.println(s.isNuovo());
			sm.newProdotto(s);
			
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
