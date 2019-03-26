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
    <div class="card mb-4 w-75 mx-auto">
        <div class="card-header text-white bg-secondary"><h4 class="text-center">Modification du compte : <s:property
                value="#session.userLog.login"/></h4></div>
        <div class="card-body">

            <form method="post" action="userModification">

                <div class="form-group row">
                    <div class="col-sm-6">
                        <label for="firstName" class="mr-sm-2">Prénom : </label>
                        <input type="text"
                               class="form-control is-invalid mb-2 mr-sm-2"
                               id="firstName"
                               name="firstName"
                               value='<s:property value="firstName"/>'
                               maxlength="50">
                        <div class="invalid-feedback"><s:fielderror fieldName="firstName" /></div>
                    </div>

                    <div class="col-sm-6">
                        <label for="lastName" class="mr-sm-2">Nom : </label>
                        <input type="text"
                               class="form-control is-invalid mb-2 mr-sm-2"
                               id="lastName"
                               name="lastName"
                               value='<s:property value="lastName"/>'
                               maxlength="50">
                        <div class="invalid-feedback"><s:fielderror fieldName="lastName" /></div>
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-6">
                        <label for="userEmail" class="mr-sm-2">Email : </label>
                        <input type="text"
                               class="form-control is-invalid mb-2 mr-sm-2"
                               id="userEmail"
                               name="userEmail"
                               value='<s:property value="userEmail"/>'
                               maxlength="100">
                        <div class="invalid-feedback"><s:fielderror fieldName="userEmail" /></div>
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-6">
                        <label for="userPass" class="mr-sm-2">Mot de passe : </label>
                        <input type="password" class="form-control is-invalid mb-2 mr-sm-2" id="userPass"
                               name="userPass"
                               maxlength="100">
                        <div class="invalid-feedback"><s:fielderror fieldName="userPass"/></div>
                    </div>

                    <div class="col-sm-6">
                        <label for="userPassConf" class="mr-sm-2">Confirmation du mot de passe : </label>
                        <input type="password" class="form-control is-invalid mb-2 mr-sm-2" id="userPassConf"
                               name="userPassConf"
                               maxlength="100">
                        <div class="invalid-feedback"><s:fielderror fieldName="userPassConf"/></div>
                    </div>
                </div>

                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Valider les modifications</button>
                </div>

            </form>
        </div>
    </div>
</div>

<%@include file="/include/jsp/footer.jsp" %>

</body>

</html>