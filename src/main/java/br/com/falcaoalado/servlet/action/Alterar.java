package br.com.falcaoalado.servlet.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.falcaoalado.servlet.dao.UsuarioDAO;
import br.com.falcaoalado.servlet.model.Usuario;

public class Alterar implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		long id = Long.parseLong(request.getParameter("id"));
		String senha = request.getParameter("senha");
		
		try {
			
			Usuario usuario = new UsuarioDAO().findById(id);
			usuario.setSenha(senha);
			new UsuarioDAO().update(usuario);
			System.out.println("Deu bom!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:ListaUsuarios";
	}

}
