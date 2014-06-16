<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sobre</title>

        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />
        <script type="text/javascript" src="https://code.jquery.com/jquery.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        
            <!-- Custom styles for this template -->
    <link href="http://getbootstrap.com/examples/starter-template/starter-template.css" rel="stylesheet">
    </head>
    
    <body>
        <div class="container">            
            <jsp:include page="cabecalho.jsp"> 
                <jsp:param name="indiceMenu" value="4"/>
            </jsp:include>
 
            <!-- Criando a estrutura abaixo do menu -->
            </br>
                
                 
                    <h3>Sobre o EasyGym</h3>
                    <p>
                        Trabalho realizado para a disciplina de Tópicos Especiais II</br>
                        
                        Professor: Fabrício Giordani</br>
                        Alunos: Guilherme Waltricke e Paulo Henrique Machado Galatto
                     
                    </p>
                

            </div>
           
    </body>
</html>
