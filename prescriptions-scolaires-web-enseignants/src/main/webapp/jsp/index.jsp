<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
                <s:a class="nav-link active" action="index">Accueil</s:a>
            </li>
            <li class="nav-item">
                <s:a class="nav-link" action="myPrescriptions">Mes listes</s:a>
            </li>
        </ul>
        <%@include file="/include/jsp/navbar_right.jsp" %>
    </nav>
</div>

<div class="container" style=""margin-top:30px">
    <div class="card mb-4">
        <div class="card-header text-white bg-secondary"><h4>Bienvenue sur l'application Prescriptions Scolaires - Enseignants.</h4></div>
        <div class="card-body">
            <p class="card-text">Cette application vous permet vous enseignants de préparer des listes de prescriptions scolaires et d'être informé si un livre de vos listes n'est pas disponible.</p>
            <p class="card-text">Une fois les livres d'une prescription scolaire validés par un libraire, vous pourrez imprimer et distributer la liste sans crainte de devoir la recommencer à la dernière minute.</p>
        </div>
    </div>

</div>

<%@include file="/include/jsp/footer.jsp" %>

</body>
</html>