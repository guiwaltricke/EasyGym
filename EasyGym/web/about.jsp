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
            <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
              <div class="container">
                <div class="navbar-header">
                  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                  </button>
                  <a class="navbar-brand" href="index.jsp">EasyGym</a>
                </div>
                <div class="collapse navbar-collapse">
                  <ul class="nav navbar-nav">
                      
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Cadastro <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                          <li><a href="cadastroCliente.jsp">Clientes</a></li>
                          <li><a href="cadastroPlano.jsp">Planos</a></li>
                        </ul>
                    </li>
                    <li><a href="filtroCliente.jsp">Financeiro</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Relatórios <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                          <li><a href="#">Á Receber</a></li>
                          <li><a href="#">Mensalidade Pagas</a></li>
                          <li><a href="#">Clientes</a></li>
                        </ul>
                    </li>
                    <li class="active"><a href="#">Sobre</a></li>
                  </ul>
                </div><!--/.nav-collapse -->
              </div>
            </div>
 
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
