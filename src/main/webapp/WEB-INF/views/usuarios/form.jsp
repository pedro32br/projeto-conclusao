<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<tags:pageTemplate titulo="Formulário de cadastro dos usuários">

	<div class="container">
		<h1>Cadastro de Usuário</h1>
		<p> ${falha} </p>
		<form:form action="${s:mvcUrl('UC#gravar').build() }" method="post" commandName="usuario" enctype="multipart/form-data">
			<div class="form-group">
				<label>Nome</label>
				<form:input path="nome" cssClass="form-control" />
				<form:errors path="nome" />
			</div>
			<div class="form-group">
		        <label>Email</label>
				<form:input path="email" cssClass="form-control" />
		        <form:errors path="email" />
			</div>
			<div class="form-group">
				<label>Senha</label>
				<form:password  path="senha" cssClass="form-control"/>
		        <form:errors path="senha" />
			</div>
			<div class="form-group">
				<label>Senha repetida</label>
				<form:password path="confirmaSenha" cssClass="form-control"/>
		        <form:errors path="confirmaSenha" />
			</div>
			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form:form>
	</div>
	
</tags:pageTemplate>
