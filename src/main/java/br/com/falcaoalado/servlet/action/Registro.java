package br.com.falcaoalado.servlet.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.falcaoalado.servlet.dao.UsuarioDAO;
import br.com.falcaoalado.servlet.model.Usuario;

public class Registro implements Acao {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String nick = request.getParameter("nick");
		String senha = request.getParameter("senha");
		
		Usuario usuario = new Usuario(nick, senha);
		
		if (isValido(request, usuario)) {
			
			try {
				new UsuarioDAO().create(usuario);
				request.getSession().setAttribute("usuariocadastrado", usuario);
				return "redirect:Sucesso";
			} catch (Exception e) {
				request.setAttribute("erro", "Usuário já cadastrado");
				e.printStackTrace();
				return "forward:RegistroForm.jsp";
			}
		} else {
			return "forward:RegistroForm.jsp";
		}
	}

	public boolean isValido(HttpServletRequest request, Usuario usuario) {
		
		if (usuario.getLogon() == null || usuario.getLogon().isEmpty()) {
			request.setAttribute("erro", "Por favor, digite seu nick.");
			return false;
		}
		
		if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
			request.setAttribute("erro", "Por favor, digite sua senha.");
			return false;
		}
		
		
		return true;
	}
}
