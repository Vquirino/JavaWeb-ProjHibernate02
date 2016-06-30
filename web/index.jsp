<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f"%>

<%@page import="model.*"%>
<%@page import="persistence.*"%>

<%
    request.setAttribute("professores", new ProfessorDao().listar());
    request.setAttribute("turmas", new TurmaDao().listar());
%>

<strong>COTI Informática WebDeveloper - Hibernate MVC</strong>
<hr size="1"/>
<br/><br/>

<form name="f" method="post" action="Controle">
    Nome da Turma: <input type="text" name="nome"/>
    Início:
    <input type="text" name="dia" size="2"/> / 
    <input type="text" name="mes" size="2"/> /
    <input type="text" name="ano" size="2"/>
    <br/><br/>
            
    Selecione o professor:
    <select name="professor">
        
        <c:forEach items="${professores}" var="p">
            <option value="${p.idProfessor}">${p.nome}</option>
        </c:forEach>
            
    </select>
    <br/><br/>
    
    Descrição da Turma: <br/>
    <textarea name="descricao" rows="4" cols="60"></textarea>
    <br/><br/>
    
    <input type="submit" value="Cadastrar Turma"/>
    <input type="reset" value="Apagar"/>
</form>

<h3>${mensagem}</h3>

<table border="1" width="60%">
    <tr>
        <td>Nome da turma</td>
        <td>Data de Início</td>
        <td>Professor</td>
        <td>Descrição</td>
    </tr>
    
    <c:forEach items="${turmas}" var="t">
        <tr>
            <td>${t.nome}</td>
            <td>${t.dataInicio}</td>
            <td>${t.professor.nome}</td>
            <td>${t.descricao}</td>
        </tr>
    </c:forEach>
</table>

