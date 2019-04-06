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
                <div class="form-row justify-content-around">
                    <div class="form-group mr-sm-2">

                        <label class="mr-sm-2">Département :</label>
                        <select name="departmentId" class="form-control mb-2 mr-sm-2">
                            <s:iterator value="departmentList" var="departments">
                                <option value='<s:property value="departementId" />'><s:property value="departmentName" /></option>
                            </s:iterator>
                        </select>

                        <label class="mr-sm-2">Ville :</label>
                        <select name="cityId" class="form-control mb-2 mr-sm-2">
                            <s:iterator value="cityList" var="cities">
                                <option value='<s:property value="cityId" />'><s:property value="cityName" /></option>
                            </s:iterator>
                        </select>

                        <label class="mr-sm-2">Etablissement :</label>
                        <select name="epleName" class="form-control mb-2 mr-sm-2">
                            <s:iterator value="epleList" var="eples">
                                <option value='<s:property value="epleId" />'><s:property value="epleName" /></option>
                            </s:iterator>
                        </select>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<%@include file="/include/jsp/footer.jsp" %>