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
                <s:a class="nav-link active" action="index">Accueil</s:a>
            </li>
            <li class="nav-item">
                <s:a class="nav-link" action="search">Recherche</s:a>
            </li>
        </ul>
        <%@include file="/include/jsp/navbar_right.jsp" %>
    </nav>
</div>

<div class="container" style="margin-top:30px">
    <div class="card mb-4">
        <div class="card-header text-white bg-secondary"><h4>Bienvenue sur l'application Prescriptions Scolaires - Libraires</h4></div>
        <div class="card-body">
            <p class="card-text">Cette application vous permet à vous libraires de consulter les listes de prescriptions scolaires qui ont été constituées par les enseignants.</p>
            <p class="card-text">Vous pourrez indiquer si un livre est indisponible ou épuisé. Vous pourrez également prévoir vos stocks et gérer le traitement des différents prescriptions</p>
        </div>
    </div>

</div>

<%@include file="/include/jsp/footer.jsp" %>

</body>
</html>