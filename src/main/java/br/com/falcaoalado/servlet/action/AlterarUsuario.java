package br.com.falcaoalado.servlet.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.falcaoalado.servlet.dao.UsuarioDAO;
import br.com.falcaoalado.servlet.model.Usuario;

public class AlterarUsuario implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Long id =  Long.parseLong(request.getParameter("id"));
		System.out.println(id);
		try {
			Usuario usuario = new UsuarioDAO().findById(id);
			request.setAttribute("alterar", usuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "forward:AlterarUsuario.jsp";
	}

}
