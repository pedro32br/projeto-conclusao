<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<tags:pageTemplate titulo="Lista de Usuários cadastrados">

	<div class="container">
		<a href="${s:mvcUrl('UC#form').build()}">Novo usuário</a>
		<h1>Lista de Usuários</h1>
		<p> ${sucesso} </p>
	
		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th>Nome</th>
				<th>Email</th>
				<th>Roles</th>
				<th>Alterar Roles</th>
			</tr>
			<c:forEach items="${usuarios}" var="usuario">
				<tr>
					<td>${usuario.nome}</td>
					<td>${usuario.email}</td>
					<td>${usuario.roles}</td>
					<td>
						<a href="${s:mvcUrl('UC#setRole').arg(0, usuario.email).arg(1, role).build() }">Alterar</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
</tags:pageTemplate>
