<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulário de Registro</title>
</head>
<body>
	
	<form method="post" action="Alterar">
		<input type="hidden" value="${alterar.id}" name="id" id="id" />
		Nick: <input disabled value="${alterar.logon}" type="text" id="nick" name="nick">
		Senha: <input type="password" id="senha" name="senha">
		
		<button type="submit">Cadastrar</button>
	</form>
</body>
</html>