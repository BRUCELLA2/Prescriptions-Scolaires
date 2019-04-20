<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="fr">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS Spacelab theme-->
    <link rel="stylesheet" href="/prescriptions-scolaires-web-libraires/bootstrap/css/bootstrap.css">

    <title>Accueil - Prescriptions Scolaires - Libraires</title>
</head>

<body>
<div class="container">
    <header class="pb-2 mt-4 mb-2 border-bottom">
        <div class="jumbotron">
            <div class="container">
                <h1 class="display-3">Prescriptions Scolaires - Libraires</h1>
            </div>
        </div>
    </header>

    <nav class="navbar navbar-expand-sm bg-primary navbar-dark">
        <ul class="navbar-nav">
            <li class="nav-item">
                <s:a class="nav-link" action="index">Accueil</s:a>
            </li>
            <li class="nav-item">
                <s:a class="nav-link" action="detailsSearch">
                    <s:param name="bookId" value="bookId"/>
                    <s:param name="deadline" value="deadline"/>
                    <s:param name="cityId" value="cityId"/>
                    <s:param name="epleRne" value="epleRne"/>
                    <s:param name="bookView" value="bookView"/>
                    <s:param name="processed" value="processed"/>
                    <s:param name="departmentId" value="departmentId"/>
                    <s:param name="prescriptionId" value="prescriptionId"/>
                    Recherche</s:a>
            </li>
            <li class="nav-item">
                <s:a class="nav-link active">Détails Prescription</s:a>
            </li>
        </ul>
        <%@include file="/include/jsp/navbar_right.jsp" %>
    </nav>
</div>

<div class="container" style="margin-top: 30px">
    <div class="card mb-4">
        <div class="card-header text-white bg-primary"><h4 class="text-center">Détails de la prescriptions</h4></div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>EAN</th>
                        <th>Titre</th>
                        <th>Auteur</th>
                        <th>Etablissement</th>
                        <th>Prescription pour le :</th>
                        <th>Effectif</th>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>

                    <s:iterator value="booksList" var="books">
                        <tr>
                            <td><s:property value="ean"/> </td>
                            <td><s:property value="title"/></td>
                            <td><s:property value="author"/></td>
                            <td><s:property value="epleName"/></td>
                            <td class="text-center">
                                <fmt:parseDate value="${purchaseDeadline}"
                                               pattern="dd-MM-yyyy HH:mm:ss" var="parsedDate" type="BOTH" />
                                <fmt:formatDate value="${parsedDate}" var="stdDatum" type="date" pattern="dd/MM/yyyy" />
                                <c:out value="${stdDatum}"/>
                            </td>
                            <th><s:property value="headcount"/></th>
                            <td class="text-center">
                                <s:if test="bookStatusId == 2">
                                    <div class="btn btn-primary text-center">
                                        Disponible
                                    </div>
                                </s:if>
                                <s:else>
                                    <s:a class="btn btn-secondary text-center" action="detailsSetAvailable">
                                        <s:param name="bookId" value="bookId"/>
                                        <s:param name="deadline" value="deadline"/>
                                        <s:param name="cityId" value="cityId"/>
                                        <s:param name="epleRne" value="epleRne"/>
                                        <s:param name="bookView" value="bookView"/>
                                        <s:param name="processed" value="processed"/>
                                        <s:param name="departmentId" value="departmentId"/>
                                        <s:param name="prescriptionId" value="prescriptionId"/>
                                        Disponible
                                    </s:a>
                                </s:else>

                                <s:if test="bookStatusId == 3">
                                    <div class="btn btn-primary text-center">
                                        Indisponible
                                    </div>
                                </s:if>
                                <s:else>
                                    <s:a class="btn btn-secondary text-center" action="detailsSetNotAvailable">
                                        <s:param name="bookId" value="bookId"/>
                                        <s:param name="deadline" value="deadline"/>
                                        <s:param name="cityId" value="cityId"/>
                                        <s:param name="epleRne" value="epleRne"/>
                                        <s:param name="bookView" value="bookView"/>
                                        <s:param name="processed" value="processed"/>
                                        <s:param name="departmentId" value="departmentId"/>
                                        <s:param name="prescriptionId" value="prescriptionId"/>
                                        Indisponible
                                    </s:a>
                                </s:else>

                                <s:if test="bookStatusId == 4">
                                    <div class="btn btn-primary text-center">
                                        Épuisé
                                    </div>
                                </s:if>
                                <s:else>
                                    <s:a class="btn btn-secondary text-center" action="detailsSetDepleted">
                                        <s:param name="bookId" value="bookId"/>
                                        <s:param name="deadline" value="deadline"/>
                                        <s:param name="cityId" value="cityId"/>
                                        <s:param name="epleRne" value="epleRne"/>
                                        <s:param name="bookView" value="bookView"/>
                                        <s:param name="processed" value="processed"/>
                                        <s:param name="departmentId" value="departmentId"/>
                                        <s:param name="prescriptionId" value="prescriptionId"/>
                                        Épuisé
                                    </s:a>
                                </s:else>
                            </td>
                            <td class="text-center">
                                <s:set var="processedBook" value="%{checkBookProcessedForUser(#books)}"/>
                                <s:if test="#processedBook">
                                    <s:a class="btn btn-primary text-center" action="detailsSetProcessedBook">
                                        <s:param name="bookId" value="bookId"/>
                                        <s:param name="processedBookStatusForUser" value="false" />
                                        <s:param name="prescriptionId" value="prescriptionId" />
                                        <s:param name="deadline" value="deadline"/>
                                        <s:param name="cityId" value="cityId"/>
                                        <s:param name="epleRne" value="epleRne"/>
                                        <s:param name="bookView" value="bookView"/>
                                        <s:param name="processed" value="processed"/>
                                        <s:param name="departmentId" value="departmentId"/>
                                        <s:param name="prescriptionId" value="prescriptionId"/>
                                        Traité
                                    </s:a>
                                </s:if>
                                <s:else>
                                    <s:a class="btn btn-primary text-center" action="detailsSetProcessedBook">
                                        <s:param name="bookId" value="bookId"/>
                                        <s:param name="processedBookStatusForUser" value="true" />
                                        <s:param name="prescriptionId" value="prescriptionId" />
                                        <s:param name="deadline" value="deadline"/>
                                        <s:param name="cityId" value="cityId"/>
                                        <s:param name="epleRne" value="epleRne"/>
                                        <s:param name="bookView" value="bookView"/>
                                        <s:param name="processed" value="processed"/>
                                        <s:param name="departmentId" value="departmentId"/>
                                        <s:param name="prescriptionId" value="prescriptionId"/>
                                        Non Traité
                                    </s:a>
                                </s:else>
                            </td>
                        </tr>
                    </s:iterator>
                </table>
            </div>
        </div>
    </div>
</div>

<%@include file="/include/jsp/footer.jsp" %>
