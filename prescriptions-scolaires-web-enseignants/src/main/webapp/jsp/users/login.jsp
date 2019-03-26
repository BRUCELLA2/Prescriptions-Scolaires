<%@ taglib prefix="s" uri="/struts-tags" %>
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
                <s:a class="nav-link" action="index">Accueil</s:a>
            </li>
            <li class="nav-item">
                <s:a class="nav-link" action="myPrescriptions">Mes listes</s:a>
            </li>
        </ul>
        <%@include file="/include/jsp/navbar_right.jsp" %>
    </nav>
</div>

<div class="container" style="margin-top: 30px">
    <div class="card mb-4 w-25 mx-auto">
        <div class="card-header text-white bg-secondary"><h4 class="text-center">Connexion</h4></div>
        <div class="card-body">

            <form method="post" action="login">
                <div class="form-group mr-sm-2">
                    <label for="userLogin" class="mr-sm-2">Identifiant : </label>
                    <input type="text" class="form-control is-invalid mb-2 mr-sm-2" id="userLogin" name="userLogin"
                           value='<s:property value="userLogin"/>' maxlength="30">
                    <div class="invalid-feedback"><s:fielderror fieldName="userLogin"/></div>
                </div>
                <div class="form-group mr-sm-2">
                    <label for="userPass" class="mr-sm-2">Mot de passe : </label>
                    <input type="password" class="form-control is-invalid" id="userPass" name="userPass">
                    <div class="invalid-feedback"><s:fielderror fieldName="userPass"/></div>
                </div>

                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Connexion</button>
                </div>
            </form>
        </div>
    </div>
</div>

<%@include file="/include/jsp/footer.jsp" %>

</body>
</html>