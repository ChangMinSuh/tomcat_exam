<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.ll.exam.article.dto.ArticleDto" %>

<%
    ArticleDto article = (ArticleDto)request.getAttribute("article");
%>

<h1>게시물 상세페이지</h1>

<div>
    <% if ( article != null ) { %>
    <div>
        ID : <%=article.getId()%>
    </div>
    <div>
        제목 : <%=article.getTitle()%>
    </div>
    <div>
        내용 : <%=article.getBody()%>
    </div>
    <% } %>

</div>