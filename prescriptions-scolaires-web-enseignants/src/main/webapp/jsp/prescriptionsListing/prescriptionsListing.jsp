<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="fr">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS Spacelab theme-->
    <link rel="stylesheet" href="/prescriptions-scolaires-web-enseignants/bootstrap/css/bootstrap.css">

    <title>Accueil - Prescriptions Scolaires - Enseignants</title>
</head>

<body>
<div class="container">
    <header class="pb-2 mt-4 mb-2 border-bottom">
        <div class="jumbotron">
            <div class="container">
                <h1 class="display-3">Prescriptions Scolaires - Enseignants</h1>
            </div>
        </div>
    </header>

    <nav class="navbar navbar-expand-sm bg-primary navbar-dark">
        <ul class="navbar-nav">
            <li class="nav-item">
                <s:a class="nav-link" action="index">Accueil</s:a>
            </li>
            <li class="nav-item">
                <s:a class="nav-link active" action="myPrescriptions">Mes listes</s:a>
            </li>
        </ul>
        <%@include file="/include/jsp/navbar_right.jsp" %>
    </nav>
</div>

<div class="container" style="margin-top: 30px">
    <div class="card mb-4">
        <div class="card-header text-white bg-primary"><h4 class="text-center">Mes prescriptions</h4></div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>Nom de la prescription</th>
                        <th>Eple</th>
                        <th>Date d'effet</th>
                        <th>Vérification Libraire</th>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>

                    <s:iterator value="prescriptionsList" var="prescriptions">
                        <tr>
                            <td><b><s:property value="prescriptionName"/></b></td>
                            <td><s:property value="epleName"/></td>
                            <td>
                                <fmt:parseDate
                                        value="${purchaseDeadline}" pattern="dd-MM-yyyy HH:mm:ss"
                                        var="parsedDate" type="date" />
                                <fmt:formatDate value="${parsedDate}" var="stdDatum" type="date"
                                                pattern="dd/MM/yyyy" />
                                <c:out value="${stdDatum}"></c:out>
                            </td>
                            <td>
                                <s:set var="status" value="validationStatus"/>
                                <s:if test="%{#status == true}">
                                    Validée
                                </s:if>
                                <s:else>
                                    Non validée
                                </s:else>
                            <td>
                                <s:a class="btn btn-primary text-center" action="prescriptionDetails">
                                    <s:param name="prescriptionId" value="prescriptionId"/>
                                    Détails / Modifier
                                </s:a>
                            </td>
                            <td>
                                <s:a class="btn btn-primary text-center" action="deletePrescription">
                                    <s:param name="prescriptionId" value="prescriptionId"/>
                                    Supprimer
                                </s:a>
                            </td>
                        </tr>
                    </s:iterator>
                    <tr>
                        <td>
                            <s:a class="btn btn-primary text-center" action="newPrescription">
                                Nouvelle prescription
                            </s:a>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</div>

<%@include file="/include/jsp/footer.jsp" %>