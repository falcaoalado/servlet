package br.com.falcaoalado.servlet.dao;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<Usuario> findAll() throws Exception {
		
		super.open();
		super.preparedStatement = super.connection.prepareStatement("SELECT * FROM Usuario");
		super.resultSet = super.preparedStatement.executeQuery();
		
		List<Usuario> usuarios = new ArrayList<>();
		
		while (super.resultSet.next()) {
			Usuario usuario = new Usuario();
			usuario.setId(super.resultSet.getLong(1));
			usuario.setLogon(super.resultSet.getString(2));
			usuario.setSenha(super.resultSet.getString(3));
			
			usuarios.add(usuario);
		}
		
		super.resultSet.close();
		super.close();
		
		return usuarios;
	}
	
	public Usuario findById(Long id) throws Exception {
		
		super.open();
		super.preparedStatement = super.connection.prepareStatement("SELECT * FROM Usuario WHERE id = ?");
		super.preparedStatement.setLong(1, id);
		super.resultSet = super.preparedStatement.executeQuery();
		Usuario usuario = new Usuario();
		if(super.resultSet.next()) {
			usuario.setId(super.resultSet.getLong(1));
			usuario.setLogon(super.resultSet.getString(2));
			usuario.setSenha(super.resultSet.getString(3));
		}
		super.resultSet.close();
		super.preparedStatement.close();
		super.close();
		
		return usuario;
	}
	
	public void update (Usuario usuario) throws Exception {
		
		super.open();
		super.preparedStatement = super.connection.prepareStatement("UPDATE Usuario SET senha = ? WHERE id = ?");
		super.preparedStatement.setString(1, usuario.getSenha());
		super.preparedStatement.setLong(2, usuario.getId());
		super.preparedStatement.execute();
		super.close();
	}
	
}
