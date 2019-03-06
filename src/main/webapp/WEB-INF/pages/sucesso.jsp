<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sucesso</title>
</head>
<body>
	
	<c:if test="${not empty usuariocadastrado}">
		<h3>${usuariocadastrado.logon}, seu cadastro foi realizado com sucesso!</h3>
	</c:if>
	<c:if test="${empty usuariocadastrado}">
		<h3>Nenhum usuário cadastrado!</h3>
	</c:if>
</body>
</html>