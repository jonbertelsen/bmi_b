
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/header.inc"%>

<div class="alert alert-danger" role="alert">
        <c:if test = "${requestScope.error!= null}" >
           <h2>Der er opstået en fejl ! </h2>
            ${requestScope.error}
        </c:if>
</div>

<p><a href="FrontController?target=redirect&destination=index">Til forsiden</a></p>

<%@include file="../includes/footer.inc"%>
