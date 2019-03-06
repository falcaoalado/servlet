package br.com.falcaoalado.servlet.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.falcaoalado.servlet.action.Acao;

public class Entrada implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String requisicao = retornaAcao(req.getRequestURI());

		if (requisicao.equals("")) {
			req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req, resp);
		} else {
			try {
				Acao acao = (Acao) Class.forName("br.com.falcaoalado.servlet.action." + requisicao).getConstructor().newInstance();
				String[] splitAcaoNome = acao.execute(req, resp).split(":");

				if (isForward(splitAcaoNome[0])) {
					req.getRequestDispatcher("/WEB-INF/pages/" + splitAcaoNome[1]).forward(req, resp);
				} else {
					resp.sendRedirect(splitAcaoNome[1]);
				}
			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("erro", requisicao);
				req.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(req, resp);
			}
		}
	}

	private boolean isForward(String string) {
		if (string.equals("forward"))
			return true;

		return false;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	private String retornaAcao(String url) {
		return url.substring(1, url.length());
	}
}
