<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>

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
                  <a class="navbar-brand active" href="index.jsp">EasyGym</a>
                </div>
                <div class="collapse navbar-collapse">
                  <ul class="nav navbar-nav">
                      
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Cadastro <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                          <li><a href="/listarClientes">Clientes</a></li>
                          <li><a href="/novoPlano">Planos</a></li>
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
                    <li><a href="about.jsp">Sobre</a></li>
                  </ul>
                </div><!--/.nav-collapse -->
              </div>
            </div>
 
            <!-- Criando a estrutura abaixo do menu -->
            </br>
                
                 
                    <h3>Seja bem vindo ao EasyGym</h3>
                    <p>
                        Este sistema visa atender a demanda de academias por um controle de seus clientes,
                        com o EasyGym o proprietário vai conseguir controlar o fluxo de dinheiro proveniente de
                        mensalidades pagas e ainda verificar os relátorios de clientes ativos.
                     
                    </p>
                

            </div>
           
    </body>
</html>
