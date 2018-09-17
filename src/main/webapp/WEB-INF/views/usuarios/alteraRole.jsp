<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<tags:pageTemplate titulo="Formulário de cadastro dos usuários">

	<div class="container">
		<h1>Cadastro de permissões para ${usuario.nome}</h1>
		<form:form action="${s:mvcUrl('UC#alterar').arg(0, usuario).arg(1, usuario.email).build() }" method="post" commandName="usuario" enctype="multipart/form-data">
			<form:checkboxes items="${roles}" path="roles"/>
			<input type="hidden" value="${usuario.email}" name="email" >
			<input type="hidden" value="${usuario.senha}" name="senha" >
			<input type="hidden" value="${usuario.confirmaSenha}" name="confirmaSenha" >
			<input type="hidden" value="${usuario.nome}" name="nome" >
			<button type="submit" class="btn btn-primary">Alterar</button>
		</form:form>
	</div>
	
</tags:pageTemplate>
