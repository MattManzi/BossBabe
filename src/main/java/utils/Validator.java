package utils;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class Validator {
	
	public Validator() {
		
	}
	
	public boolean validaRequest(HttpServletRequest request) {
		Enumeration<String> p = request.getParameterNames();

		while (p.hasMoreElements()) {
			String name = p.nextElement();
			String param = request.getParameter(name);
			System.out.println("Validator: " + name);
			if (!valida(param, name))
				return false;
		}
		
		return true;
	}

	public boolean valida(String p, String n) {
		InputValidator val = new InputValidator();
		val.setString(p);
		if (setStrategy(val, n))
			return true;
		if (!val.validator())
			return false;

		return true;
	}
	
	public boolean setStrategy(InputValidator v, String s) {
		if (s.equals("nome"))
			v.setValidatorStrategy(new ValidatorName());
		else if (s.equals("quantita"))
			v.setValidatorStrategy(new ValidatorNumber());
		else if (s.equals("prezzo"))
			v.setValidatorStrategy(new ValidatorDouble());
		else
			return true;

		return false;
	}
	
	
}
