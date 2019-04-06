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
            <li class="nav-item active">
                <s:a class="nav-link">Livre : <s:property value="book.bookName"/></s:a>
            </li>
        </ul>
        <%@include file="/include/jsp/navbar_right.jsp" %>
    </nav>
</div>

<div class="container" style="margin-top: 30px">
    <div class="card mb-4">
        <div class="card-body">

            <form method="post" action='<s:if test="%{bookId neq null}">bookModification</s:if><s:else>bookCreation</s:else>'>
                <div class="form-group row justify-content-around">
                    <div class="col-sm-6">
                        <label for="ean" class="mr-sm-2">EAN : </label>
                        <input type="text"
                               class="form-control is-invalid mb-2 mr-sm-2"
                               id="ean"
                               name="ean"
                               value='<s:property value="book.ean"/>'
                               maxlength="13">
                        <div class="invalid-feedback"><s:fielderror fieldName="ean" /></div>
                    </div>

                    <div class="col-sm-6">
                        <label for="title" class="mr-sm-2">EAN : </label>
                        <input type="text"
                               class="form-control is-invalid mb-2 mr-sm-2"
                               id="title"
                               name="title"
                               value='<s:property value="book.title"/>'
                               maxlength="150">
                        <div class="invalid-feedback"><s:fielderror fieldName="title" /></div>
                    </div>
                </div>

                <div class="form-group row justify-content-around">
                    <div class="col-sm-6">
                        <label for="author" class="mr-sm-2">Auteur(s) : </label>
                        <input type="text"
                               class="form-control is-invalid mb-2 mr-sm-2"
                               id="author"
                               name="author"
                               value='<s:property value="book.author"/>'
                               maxlength="150">
                        <div class="invalid-feedback"><s:fielderror fieldName="author" /></div>
                    </div>
                </div>
                <div class="text-center">
                    <s:if test="%{bookId eq null}">
                        <s:hidden name="prescriptionId" value="%{prescriptionId}" />
                        <button type="submit" class="btn btn-primary">Enregistrer</button>
                    </s:if>
                    <s:else>
                        <s:hidden name="bookId" value="%{book.bookId}" />
                        <button type="submit" class="btn btn-primary">Valider les modifications</button>
                    </s:else>
                </div>
            </form>
        </div>
    </div>
</div>
</body>

<%@include file="/include/jsp/footer.jsp" %>
</html>