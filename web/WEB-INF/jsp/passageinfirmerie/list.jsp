
<%@page import="java.util.Date"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EDUCATION SUPPORT</title>

        <!-- Fichiers CSS pour le dataTable-->
        <link href="<c:url value="css/dataTables.semanticui.min.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="css/responsive.semanticui.min.css"/>" rel="stylesheet" type="text/css"/>        
        <link href="<c:url value="css/buttons.dataTables.min.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="css/jquery.dataTables.min.css"/>" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <h1 class="titre">Liste des passages à l'infirmeries</h1>

        <table id="dataTableUtilisateur" class="ui celled table responsive nowrap" style="width:100%">
            <thead>
                <tr>
                    <th>PASSAGE INFIRMERIE</th>
                    <th>ELEVE</th>
                    <th>Code</th>
                    <th>Date Passage</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${passageinfirmeries}" var="passageinfirmerie">
                <c:if test="${!passageinfirmerie.deleted}">    
                <tr class="pointeur" onclick="window.location.href='start#!/passageinfirmerie/${passageinfirmerie.idpassageinfirmerie}'">
                    <td>
                        <h4 class="ui image header">
                            <div class="content">
                                Crée le <fmt:formatDate value="${passageinfirmerie.created}" pattern="yyyy-MM-dd"/>
                                <div class="sub header">
                                    Modifié le <fmt:formatDate value="${passageinfirmerie.modified}" pattern="yyyy-MM-dd"/>
                                </div>
                            </div>
                        </h4>
                    </td>
                    <td>
                        <h4 class="ui image header">
                            <div class="content">
                                ${passageinfirmerie.eleveIdeleve.individuIdindividu.noms} ${passageinfirmerie.eleveIdeleve.individuIdindividu.prenoms}
                                <div class="sub header">
                                    ${passageinfirmerie.eleveIdeleve.individuIdindividu.matricule}
                                </div>
                            </div>
                        </h4>
                    </td>
                    <td>
                        <h4 class="ui image header">
                            <div class="content">
                                ${passageinfirmerie.code}</div>
                            </div>
                        </h4>
                    </td>
                    <td>
                        <h4 class="ui image header">
                            <div class="content">
                                ${passageinfirmerie.dateJour}</div>
                            </div>
                        </h4>
                    </td>
                </tr>
                </c:if>
                </c:forEach>
            </tbody>
        </table>




        <!-- Datatable -->
        <script src="<c:url value="js/jquery.dataTables.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="js/jszip.js"/>" type="text/javascript"></script>
        <script src="<c:url value="js/pdf.js.js"/>" type="text/javascript"></script>
        <script src="<c:url value="js/dataTables.buttons.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="js/buttons.flash.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="js/buttons.html5.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="js/buttons.print.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="js/pdfmake.min.js"/>" type="text/javascript"></script>
        <script>
            var titre = 'Bonjour';
            $(document).ready(function () {
                
                //ouvrirMenuCorrespondant("#section_params", "bouton_params", "passageinfirmerie");
                
                $('#dataTableUtilisateur').DataTable({
                    
                    dom: '<"top"fB>rt<"bottom"lp><"clear">',
                    buttons: [
                        {
                            text: "Nouveau",
                            title: titre,
                            message: '',
                            className: 'ui gris mini button',
                            action: function (e, dt, node, config) {
                                window.location.href='start#!/passageinfirmerie'
                            }
                        },
                        {
                            extend: 'excelHtml5',
                            text: "Exporter vers Excel",
                            title: titre,
                            message: '',
                            className: 'ui gris mini basic button'
                        },
                        {
                            extend: 'pdfHtml5',
                            text: "Exporter en PDF",
                            title: titre,
                            message: '',
                            className: 'impressionPDF ui gris basic mini button'
                        },
                        {
                            extend: 'print',
                            text: "Imprimer",
                            title: titre,
                            message: '',
                            className: 'impression ui gris basic mini button'
                        }
                    ],
                    "language": {
                        "sEmptyTable": "Aucune donnée disponible",
                        "sInfo": "Affiche _START_ à _END_ sur _TOTAL_ entrées",
                        "sLengthMenu": "Afficher _MENU_ lignes par page",
                        "sSearch": "Rechercher : ",
                        "zeroRecords": "Aucun résultat",
                        "info": "Page _PAGE_ sur _PAGES_",
                        "infoEmpty": "Aucun résultat disponible",
                        "sProcessing": "Veuillez patienter...",
                        "infoFiltered": "(sur les _MAX_ disponibles)",
                        "paginate": {
                            "previous": "Précédent",
                            "next": "Suivant"
                        }
                    }
                });
            });
        </script>

    </body>
</html>
