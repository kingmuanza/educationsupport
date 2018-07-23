<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Education Support</title>
        <link href="<c:url value="/resources/css/semantic.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/myapp.css"/>" rel="stylesheet">
        <link href="<c:url value="/resources/css/Semantic-UI-Alert.css"/>" rel="stylesheet">
    </head>

    <body>
        <div class="ui fluid four column doubling stackable grid">
            <div class="two wide column ${empty sessionScope.connexionError?'gris':'bg-red' } ">

            </div>
            <div class="four wide column ${empty sessionScope.connexionError?'gris':'bg-red' } ">
                <div class="container" style="padding-top: 80px;">
                    <h1 class="espace_haut" style="line-height: 1; font-size: 3.2em" >
                        Education Support
                    </h1>
                    
                    <div style="padding-top: 20px;">
                        <form class="ui form" method="post" action="ConnexionServlet">
                            <div class="field">
                                <label class="fg-white">Login</label>
                                <input type="text" name="login" placeholder="Login">
                            </div>
                            <div class="field" style="padding-bottom: 20px;">
                                <label class="fg-white">Mot de passe</label>
                                <input type="password" name="passe" >
                            </div>
                            <button class="ui ${empty sessionScope.connexionError?'teal':'' } button" type="submit">Connexion</button>
                        </form>
                    </div>



                </div>
            </div>
            <div class="two wide column ${empty sessionScope.connexionError?'gris':'bg-red' } " style="">

            </div>


            <!--Animation particles-->
            <div class="eight wide column" style="background-color: #fdfdff">
                <div id="hero-wrapper" style="border : 0px solid #000; width: 100%; height: 100vh">
                    <div class="${empty sessionScope.connexionError?'fg-teal':'fg-grey' }" style="position: absolute; bottom: 0; right: 0; padding: 40px;z-index: 159874">
                        &copy;  SIA TECHNOLOGY GROUP
                    </div>
                </div>
            </div>
        </div>


        <!-- Fichiers JS-->
        <script src="<c:url value="/resources/js/jquery-3.3.1.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/semantic.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/particles/particles.min.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/Semantic-UI-Alert.js"/>" type="text/javascript"></script>
        <script src="<c:url value="/resources/js/myapp.js"/>" type="text/javascript"></script>

        <script>
                            
    particlesJS.load('hero-wrapper', '<c:url value="/resources/particles/particles.json"/>', function () {});
                            $(document).ready(function () {
                                $('.ui.dropdown').dropdown();
                                console.log("Moi je comprend pas pas");
            <c:if test="${!empty sessionScope.connexionError}">

                                $.uiAlert({
                                    textHead: "Erreur",
                                    text: "${sessionScope.connexionError}",
                                    bgcolor: '#DB2828',
                                    textcolor: '#fff',
                                    position: 'top-right', // top And bottom ||  left / center / right
                                    icon: 'bell outline icon',
                                    permanent: true
                                });

            </c:if>


                            });
        </script>
    </body>
</html>
