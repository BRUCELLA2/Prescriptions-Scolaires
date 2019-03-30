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
                <s:a class="nav-link">Prescription : <s:property value="prescription.prescriptionName"/></s:a>
            </li>
        </ul>
        <%@include file="/include/jsp/navbar_right.jsp" %>
    </nav>
</div>

<div class="container" style="margin-top: 30px">
    <div class="card mb-4">
        <div class="card-body">

            <form method="post" action='<s:if test="%{prescriptionId neq null}">prescriptionModification</s:if><s:else>prescriptionCreation</s:else>'>
                <div class="form-group row justify-content-around">
                    <div class="col-sm-6">
                        <label for="prescriptionName" class="mr-sm-2">Nom de la prescription : </label>
                        <input type="text"
                               class="form-control is-invalid mb-2 mr-sm-2"
                               id="prescriptionName"
                               name="prescriptionName"
                               value='<s:property value="prescription.prescriptionName"/>'
                               maxlength="150">
                        <div class="invalid-feedback"><s:fielderror fieldName="prescriptionName" /></div>
                    </div>

                    <div class="col-sm-6">
                        <label class="mr-sm-2">Eple : </label>
                        <select name="epleId" class="form-control is-invalid mb-2 mr-sm-2">
                            <s:iterator value="epleList" var="eples">
                                <option value='<s:property value="epleId" />'><s:property value="epleName" /></option>
                            </s:iterator>
                        </select>
                        <div class="invalid-feedback"><s:fielderror fieldName="epleName" /></div>
                    </div>
                </div>

                <div class="form-group row justify-content-around">
                    <div class="col-sm-3">
                        <label for="headcount" class="mr-sm-2">Effectif : </label>
                        <input type="number"
                               class="form-control is-invalid mb-2 mr-sm-2"
                               id="headcount"
                               name="headcount"
                               value='<s:property value="prescription.headcount"/>'>
                        <div class="invalid-feedback"><s:fielderror fieldName="headcount" /></div>
                    </div>
                    <div class="col-sm-3">
                        <label for="purchaseDeadline" class="mr-sm-2">Date d'effet : </label>
                        <input type="date"
                               class="form-control is-invalid mb-2 mr-sm-2"
                               id="purchaseDeadline"
                               name="purchaseDeadline"
                               value='<s:property value="purchaseDeadline"/>'>
                        <div class="invalid-feedback"><s:fielderror fieldName="purchaseDeadline" /></div>
                    </div>
                </div>
                <div class="text-center">

                    <s:if test="%{prescriptionId eq null}">
                        <button type="submit" class="btn btn-primary">Enregistrer</button>
                    </s:if>
                    <s:else>
                        <s:hidden name="prescriptionId" value="%{prescription.prescriptionId}" />
                        <button type="submit" class="btn btn-primary">Valider les modifications</button>
                    </s:else>
                </div>
            </form>

            <s:if test="%{prescriptionId neq null}">
            <div class="container" style="margin-top: 30px">
                <div class="card mb-4">
                    <div class="card-header text-white bg-primary"><h4 class="text-center">Livres de la prescription</h4></div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered">
                                <thead>
                                <tr>
                                    <th>EAN</th>
                                    <th>Titre</th>
                                    <th>Auteurs</th>
                                    <th>Disponibilité</th>
                                    <th></th>
                                    <th></th>
                                </tr>
                                </thead>

                                <s:iterator value="booksList" var="books">
                                    <tr>
                                        <td><s:property value="ean"/></td>
                                        <td><s:property value="title"/></td>
                                        <td><s:property value="author"/></td>
                                        <td><s:property value="nameStatus"/></td>
                                        <td>
                                            <s:a class="btn btn-primary text-center" action="bookModification">
                                                <s:param name="bookId" value="bookId"/>
                                                Modifier
                                            </s:a>
                                        </td>
                                        <td>
                                            <s:a class="btn btn-primary text-center" action="deleteBook">
                                                <s:param name="bookId" value="bookId"/>
                                                Supprimer
                                            </s:a>
                                        </td>
                                    </tr>
                                </s:iterator>
                                <tr>
                                    <td>
                                        <s:a class="btn btn-primary text-center" action="newBook">
                                            Nouveau livre
                                        </s:a>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            </s:if>
        </div>
    </div>
</div>

<%@include file="/include/jsp/footer.jsp" %>