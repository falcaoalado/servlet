package br.com.falcaoalado.servlet.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.api.Session;

import br.com.falcaoalado.servlet.dao.UsuarioDAO;
import br.com.falcaoalado.servlet.model.Usuario;

public class ListaUsuarios implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			List<Usuario> usuarios = new UsuarioDAO().findAll();
			System.out.println(usuarios);
			request.getSession().setAttribute("usuarios", usuarios);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "forward:ListaUsuarios.jsp";
	}

}
