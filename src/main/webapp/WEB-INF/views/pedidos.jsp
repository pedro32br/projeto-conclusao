<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tags:pageTemplate titulo="Lista de pedidos atuais">

	<section id="index-section" class="container middle">
		
		<ul class="clearfix book-collection">
			<h1>Lista de pedidos atuais</h1>
			<table>
				<tr>
					<th>Id</th>
					<th>Valor</th>
					<th>Data Pedido</th>
					<th>Títulos</th>
				</tr>
				<c:forEach items="${pedidos}" var="pedidos" >
					<tr>
						<td>${pedidos.id}</td>
						<td>${pedidos.valor}</td>
						<td><fmt:formatDate value="${pedidos.data.time}" pattern="dd/MM/yy"/></td>
						<td>
							<c:forEach items="${pedidos.produtos}" var="produto" varStatus="contador">
								${produto.titulo}<c:if test="${!contador.last}">,</c:if>
							</c:forEach>
						</td>
					</tr>
				</c:forEach>
			</table>
		</ul>
	
	</section>
	
</tags:pageTemplate>
