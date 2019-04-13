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
                <s:a class="nav-link active" action="search">Recherche</s:a>
            </li>
        </ul>
        <%@include file="/include/jsp/navbar_right.jsp" %>
    </nav>
</div>

<div class="container" style="margin-top: 30px">
    <div class="card mb-4">
        <div class="card-header text-white bg-primary"><h4 class="text-center">Recherche de prescriptions ou de livres</h4></div>
        <div class="card-body">

            <form method="post" action="search">

                <div class="form-group row justify-content-around">
                    <div class="col-sm-4">
                        <label>Département :</label>
                        <select name="departmentId" class="form-control mb-2 mr-sm-2">
                            <option value='<s:property value="departmentId" />'>
                                <s:set var="departmentName" value="%{getDepartmentName()}"/>
                                <s:property value="#departmentName"/>
                            </option>
                            <option/>
                            <s:iterator value="departmentList" var="departments">
                                <option value='<s:property value="departmentId" />'><s:property value="departmentName" /></option>
                            </s:iterator>
                        </select>
                    </div>
                    <div class="col-sm-4">
                        <label>Ville :</label>
                        <select name="cityId" class="form-control mb-2 mr-sm-2">
                            <option value='<s:property value="cityId" />'>
                                <s:set var="cityName" value="%{getCityName()}"/>
                                <s:property value="#cityName"/>
                            </option>
                            <option/>
                            <s:iterator value="cityList" var="cities">
                                <option value='<s:property value="cityId" />'><s:property value="cityName" /></option>
                            </s:iterator>
                        </select>
                    </div>
                </div>
                <div class="form-group row justify-content-around">
                    <div class="col-sm-4">
                        <label>Etablissement :</label>
                        <select name="epleRne" class="form-control mb-2 mr-sm-2">
                            <option value='<s:property value="epleRne" />'>
                                <s:set var="epleName" value="%{getEpleName()}"/>
                                <s:property value="#epleName"/>
                            </option>
                            <option/>
                            <s:iterator value="epleList" var="eples">
                                <option value='<s:property value="rne" />'><s:property value="epleName" /></option>
                            </s:iterator>
                        </select>
                    </div>
                    <div class="col-sm-4">
                        <label for="deadline" class="mr-sm-2">Prescription effective à partir du :</label>
                        <input type="date"
                               class="form-control mb-2 mr-sm-2"
                               id="deadline"
                               name="deadline"
                                value='<s:property value="deadline"/>'>
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-1"></div>
                    <div class="col-sm-11">
                        <div class="form-check">
                            <input type="checkbox" class="form-check-input" id="processed" value="false" name="processed"
                            <s:if test="processed.equals('true')">
                                   checked="checked"
                            </s:if>
                            >
                            <label class="form-check-label" for="processed">Voir que les prescriptions non traitées</label>
                        </div>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-1"></div>
                    <div class="col-sm-11">
                        <div class="form-check">
                            <input type="checkbox" class="form-check-input" id="bookView" value="true" name="bookView"
                            <s:if test="bookView.equals('true')">
                                   checked="checked"
                            </s:if>
                            >
                            <label class="form-check-label" for="bookView">Affichage par livres</label>
                        </div>
                    </div>
                </div>

                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Rechercher</button>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="container" style="margin-top: 30px;">
    <div class="card mb-4">
        <div class="card-header text-white bg-primary"><h4 class="text-center">Résultat de la recherche</h4></div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-striped table-bordered">
                    <s:if test="bookView">
                        <thead>
                        <tr>
                            <th>EAN</th>
                            <th>Titre</th>
                            <th>Auteur</th>
                            <th>Prescription pour le :</th>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>

                        <s:iterator value="booksList" var="books">
                            <tr>
                                <td><s:property value="ean"/> </td>
                                <td><s:property value="title"/></td>
                                <td><s:property value="author"/></td>
                                <td class="text-center">
                                    <fmt:parseDate value="${purchaseDeadline}"
                                                   pattern="dd-MM-yyyy HH:mm:ss" var="parsedDate" type="BOTH" />
                                    <fmt:formatDate value="${parsedDate}" var="stdDatum" type="date" pattern="dd/MM/yyyy" />
                                    <c:out value="${stdDatum}"/>
                                </td>
                                <td class="text-center">
                                    <s:if test="bookStatusId == 2">
                                        <div class="btn btn-primary text-center">
                                            Disponible
                                        </div>
                                    </s:if>
                                    <s:else>
                                        <s:a class="btn btn-secondary text-center" action="setAvailable">
                                            <s:param name="bookId" value="bookId"/>
                                            <s:param name="deadline" value="deadline"/>
                                            <s:param name="cityId" value="cityId"/>
                                            <s:param name="epleRne" value="epleRne"/>
                                            <s:param name="bookView" value="bookView"/>
                                            <s:param name="processed" value="processed"/>
                                            <s:param name="departmentId" value="departmentId"/>
                                            Disponible
                                        </s:a>
                                    </s:else>

                                    <s:if test="bookStatusId == 3">
                                        <div class="btn btn-primary text-center">
                                            Indisponible
                                        </div>
                                    </s:if>
                                    <s:else>
                                        <s:a class="btn btn-secondary text-center" action="setNotAvailable">
                                            <s:param name="bookId" value="bookId"/>
                                            <s:param name="bookId" value="bookId"/>
                                            <s:param name="deadline" value="deadline"/>
                                            <s:param name="cityId" value="cityId"/>
                                            <s:param name="epleRne" value="epleRne"/>
                                            <s:param name="bookView" value="bookView"/>
                                            <s:param name="processed" value="processed"/>
                                            <s:param name="departmentId" value="departmentId"/>
                                            Indisponible
                                        </s:a>
                                    </s:else>

                                    <s:if test="bookStatusId == 4">
                                        <div class="btn btn-primary text-center">
                                            Épuisé
                                        </div>
                                    </s:if>
                                    <s:else>
                                        <s:a class="btn btn-secondary text-center" action="setDepleted">
                                            <s:param name="bookId" value="bookId"/>
                                            <s:param name="bookId" value="bookId"/>
                                            <s:param name="deadline" value="deadline"/>
                                            <s:param name="cityId" value="cityId"/>
                                            <s:param name="epleRne" value="epleRne"/>
                                            <s:param name="bookView" value="bookView"/>
                                            <s:param name="processed" value="processed"/>
                                            <s:param name="departmentId" value="departmentId"/>
                                            Épuisé
                                        </s:a>
                                    </s:else>
                                </td>
                                <td class="text-center">
                                    <s:set var="processedBook" value="%{checkBookProcessedForUser(#books)}"/>
                                    <s:if test="#processedBook">
                                        <s:a class="btn btn-primary text-center" action="setProcessedBook">
                                            <s:param name="bookId" value="bookId"/>Traité
                                        </s:a>
                                    </s:if>
                                    <s:else>
                                        <s:a class="btn btn-primary text-center" action="setProcessedBook">
                                            <s:param name="bookId" value="bookId"/>Non Traité
                                        </s:a>
                                    </s:else>
                                </td>
                            </tr>
                        </s:iterator>
                    </s:if>
                    <s:else>
                        <thead>
                        <tr>
                            <th>Statut</th>
                            <th>Nom de la prescription</th>
                            <th>Département</th>
                            <th>Ville</th>
                            <th>Établissement</th>
                            <th>Effectif</th>
                            <th>Prescription pour le :</th>
                            <th></th>
                        </tr>
                        </thead>

                        <s:iterator value="prescriptionsList" var="prescriptions">
                            <tr>
                                <td class="text-center">
                                    <s:set var="processedPrescription" value="%{checkPrescriptionProcessedForUser(#prescriptions)}"/>
                                    <s:if test="#processedPrescription">
                                        Traitée
                                    </s:if>
                                    <s:else>
                                        Non traitée
                                    </s:else>
                                </td>
                                <td><s:property value="prescriptionName"/></td>
                                <td><s:property value="departmentName"/></td>
                                <td><s:property value="cityName"/></td>
                                <td><s:property value="epleRne"/></td>
                                <td><s:property value="headcount"/></td>
                                <td class="text-center">
                                    <fmt:parseDate value="${purchaseDeadline}"
                                                   pattern="dd-MM-yyyy HH:mm:ss" var="parsedDate" type="BOTH" />
                                    <fmt:formatDate value="${parsedDate}" var="stdDatum" type="date" pattern="dd/MM/yyyy" />
                                    <c:out value="${stdDatum}"/></td>
                                <td>
                                    <s:a class="btn btn-primary text-center" action="prescriptionDetails">
                                        <s:param name="prescriptionId" value="prescriptionId"/>Détails
                                    </s:a>

                                </td>
                            </tr>
                        </s:iterator>
                    </s:else>
                </table>
            </div>
        </div>
    </div>
</div>

<%@include file="/include/jsp/footer.jsp" %>