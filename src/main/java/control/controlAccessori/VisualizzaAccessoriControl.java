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

import bean.Accessori;
import model.AccessoriModel;

@WebServlet("/Admin/VisualizzaAccessoriControl")

public class VisualizzaAccessoriControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VisualizzaAccessoriControl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		AccessoriModel am = new AccessoriModel();

		String redirectedPage = "/Admin/Accessori.jsp";

		try {
			System.out.println("Accessoriocontrol-- findAll");
			ArrayList<Accessori> a = am.findAll("");

			request.setAttribute("accessori", a);

			redirectedPage = "/Admin/Accessori.jsp";
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
