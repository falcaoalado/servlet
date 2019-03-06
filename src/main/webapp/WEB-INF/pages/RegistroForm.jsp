<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulário de Registro</title>
</head>
<body>
	
	<div>
		<p>Error: ${erro}</p>
	</div>
	
	<form method="post" action="Registro">
		Nick: <input type="text" name="nick">
		Senha: <input type="password" name="senha">
		
		<button type="submit">Cadastrar</button>
	</form>
</body>
</html>