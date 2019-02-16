package br.com.falcaoalado.servlet.dao;

import br.com.falcaoalado.servlet.model.Usuario;

public class UsuarioDAO extends DAO {

	public void create(Usuario usuario) throws Exception {
		super.open();
		super.preparedStatement = super.connection.prepareStatement("INSERT INTO Usuario (LOGON, SENHA) VALUES (?, ?)");
		super.preparedStatement.setString(1, usuario.getLogon());
		super.preparedStatement.setString(2, usuario.getSenha());
		super.preparedStatement.execute();
		super.close();
	}
	
	public Usuario login(Usuario usuario) throws Exception {
		
		Usuario login = new Usuario();
		
		super.open();
		super.preparedStatement = super.connection.
				prepareStatement("SELECT * FROM Usuario WHERE LOGON = ? AND SENHA = ?");
		super.preparedStatement.setString(1, usuario.getLogon());
		super.preparedStatement.setString(2, usuario.getSenha());
		super.resultSet = super.preparedStatement.executeQuery();
		while(super.resultSet.next()) {
			login.setId(super.resultSet.getLong(1));
			login.setLogon(super.resultSet.getString(2));
			login.setSenha(super.resultSet.getString(3));
		}
		super.close();
		
		return login;
	}
}
