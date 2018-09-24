
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
        <link href="<c:url value="/resources/css/dataTables.semanticui.min.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/resources/css/responsive.semanticui.min.css"/>" rel="stylesheet" type="text/css"/>        
        <link href="<c:url value="/resources/css/buttons.dataTables.min.css"/>" rel="stylesheet" type="text/css"/>
        <link href="<c:url value="/resources/css/jquery.dataTables.min.css"/>" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <h1 class="titre">Liste des moratoires</h1>

        <table id="dataTableUtilisateur" class="ui celled table responsive nowrap" style="width:100%">
            <thead>
                <tr>
                    <th>Elève</th>
                    <th>Code</th>
                    <th>Date Fin Validité</th>
                    <th>Reponse</th>
                    <th>Etat</th>
                    <th>Edition</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${moratoires}" var="moratoire">
                <c:if test="${!moratoire.deleted}">    
                <tr class="pointeur" onclick="window.location.href='start#!/moratoire/${moratoire.idmoratoire}'">
                    <td>
                        <h4 class="ui image header">
                            <div class="content">
                                ${moratoire.eleveIdeleve.individuIdindividu.noms}
                                <div class="sub header">
                                    ${moratoire.eleveIdeleve.individuIdindividu.prenoms}
                                </div>
                            </div>
                        </h4>
                    </td>
                    <td>
                        <h4 class="ui image header">
                            <div class="content">
                                ${moratoire.code}</div>
                            </div>
                        </h4>
                    </td>
                    <td>
                        <h4 class="ui image header">
                            <div class="content">
                                <fmt:formatDate value="${moratoire.dateFinValidite}" pattern="yyyy-MM-dd"/></div>
                            </div>
                        </h4>
                    </td>
                    <td>
                        <h4 class="ui image header">
                            <div class="content">
                                ${moratoire.reponse}</div>
                            </div>
                        </h4>
                    </td>
                    <td>
                        <h4 class="ui image header">
                            <div class="content">
                                ${moratoire.etat}</div>
                            </div>
                        </h4>
                    </td>
                    <td>
                        <h4 class="ui image header">
                            <div class="content">
                                Crée le <fmt:formatDate value="${moratoire.created}" pattern="yyyy-MM-dd"/>
                                <div class="sub header">
                                    Modifié le <fmt:formatDate value="${moratoire.modified}" pattern="yyyy-MM-dd"/>
                                </div>
                            </div>
                        </h4>
                    </td>
                </tr>
                </c:if>
                </c:forEach>
            </tbody>
        </table>




        <!-- Datatable -->
        <script src="<c:url value="/resources/js/jquery.dataTables.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/jszip.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/pdf.js.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/dataTables.buttons.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/buttons.flash.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/buttons.html5.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/buttons.print.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/pdfmake.min.js"/>" type="text/javascript"></script>
        <script>
            var titre = 'Moratoire';
            $(document).ready(function () {
                
                //ouvrirMenuCorrespondant("#section_params", "bouton_params", "moratoire");
                
                $('#dataTableUtilisateur').DataTable({
                    
                    dom: '<"top"fB>rt<"bottom"lp><"clear">',
                    buttons: [
                        {
                            text: "Nouveau",
                            title: titre,
                            message: '',
                            className: 'ui gris mini button',
                            action: function (e, dt, node, config) {
                                window.location.href='start#!/moratoire'
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
