package br.com.falcaoalado.servlet.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistroForm implements Acao{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "forward:RegistroForm.jsp";
	}
	
}
