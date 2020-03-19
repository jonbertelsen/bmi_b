<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@include file="../includes/header.inc"%>

        <h3>Ret sportskategori</h3>

        <form action="FrontController" method="post">
                <input type="hidden" name="target" value="managecategory"/>
                <input type="hidden" name="action" value="opdater"/>
                <input type="hidden" name="sportid" value="${requestScope.sport.sports_id}"/>

                <div class="form-group">
                        <label for="kategori">Ret kategoriteksten:</label>
                        <input type="text" class="form-control" id="kategori" name="kategori" value="${requestScope.sport.name}" aria-describedby="heightHelp">
                </div>

                <button type="submit" name="opdater" class="btn btn-primary">Opdater</button>

        </form>

        <ul>

                <li><a href="FrontController?target=redirect&destination=index">Til forsiden</a></li>

        </ul>

<%@include file="../includes/footer.inc"%>

