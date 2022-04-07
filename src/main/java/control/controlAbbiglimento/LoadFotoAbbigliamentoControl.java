package control.controlAbbiglimento;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AbbigliamentoModel;


@WebServlet("/LoadFotoAbbigliamentoControl")
public class LoadFotoAbbigliamentoControl extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public LoadFotoAbbigliamentoControl() {
	super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("codiceA");
		String copertina=request.getParameter("copertinaA");
		System.out.println("Load foto:"+id + "---"+ copertina);
		try {
			if (id != null  && copertina.equals("1")){
				byte[] bt=null;
				bt = AbbigliamentoModel.loadCopertina(id);
				
				ServletOutputStream out = response.getOutputStream();
				if(bt != null){
					out.write(bt);
					response.setContentType("image/jpeg");			
				}
				
				
				out.close();
			}if (id != null  && copertina.equals("2")){
				byte[] bt=null;
				bt = AbbigliamentoModel.loadCopertina2(id);
				
				ServletOutputStream out = response.getOutputStream();
				if(bt != null){
					out.write(bt);
					response.setContentType("image/jpeg");			
				}
				
				
				out.close();
			}if (id != null && copertina.equals("3")){
				byte[] bt=null;
				bt = AbbigliamentoModel.loadCopertina3(id);
				
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
