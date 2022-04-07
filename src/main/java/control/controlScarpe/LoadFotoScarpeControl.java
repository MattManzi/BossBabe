package control.controlScarpe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ScarpeModel;


@WebServlet("/LoadFotoScarpeControl")
public class LoadFotoScarpeControl extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("codiceS");
		String copertina=request.getParameter("copertinaS");
		System.out.println("Load foto:"+id + "---"+ copertina);
		try {
			if (id != null  && copertina.equals("1")){
				byte[] bt=null;
				bt = ScarpeModel.loadCopertina(id);
				
				ServletOutputStream out = response.getOutputStream();
				if(bt != null){
					out.write(bt);
					response.setContentType("image/jpeg");			
				}
				
				
				out.close();
			}if (id != null  && copertina.equals("2")){
				byte[] bt=null;
				bt = ScarpeModel.loadCopertina2(id);
				
				ServletOutputStream out = response.getOutputStream();
				if(bt != null){
					out.write(bt);
					response.setContentType("image/jpeg");			
				}
				
				
				out.close();
			}if (id != null && copertina.equals("3")){
				byte[] bt=null;
				bt = ScarpeModel.loadCopertina3(id);
				
				ServletOutputStream out = response.getOutputStream();
				if(bt != null){
					out.write(bt);
					response.setContentType("image/jpeg");			
				}
				
				
				out.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
