<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<tags:pageTemplate titulo="Relatório dos produtos">



	<section id="index-section" class="container middle">
	
		<ul class="clearfix book-collection">
		<h1>Relatório dos produtos</h1>	
          <table>
              <tr>
              	<th>Data de geração do relatório: <fmt:formatDate value="${dataGeracao.time}" pattern="dd/MM/yyyy"/></th>
              </tr>
              <tr>
                  <th>Id</th>
                  <th>Título</th>
                  <th>Descrição</th>
                  <th>Número de páginas</th>
                  <th>Sumário</th>
                  <th>Preços</th>
                  <th>Data de lançamento</th>
              </tr>
              <c:forEach items="${produto}" var="produto" >
              	<tr>
                   <td>${produto.id}</td>
                   <td>${produto.titulo}</td>
                   <td>${produto.descricao}</td>
                   <td>${produto.paginas}</td>
                   <td>${produto.sumarioPath}</td>
                   <td>${produto.precos}</td>
                   <td>
                      <fmt:formatDate value="${produto.dataLancamento.time}" pattern="dd/MM/yyyy"/>
                   </td>
              	</tr>
              </c:forEach>
              
              	<form:form action="${s:mvcUrl('RPC#relatorio').build()}" method="get" commandName="data" enctype="multipart/form-data">
	              	<tr> 
	              		<th>Quantidade: </th>
	              		<td>${quantidade}</td>
	              	</tr>
	              	<tr>
	              		<th>Filtro por data: </th>
	              		<td><input type="date" name="data"><button type="submit">Buscar</button></td>
	              	</tr>
              	</form:form>
          </table>
      	</ul>
	
	</section>
	
</tags:pageTemplate>
