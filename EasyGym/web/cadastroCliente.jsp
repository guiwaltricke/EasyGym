<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de cliente</title>

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
                      
                    <li class="dropdown active">
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
                    <li><a href="about.jsp">Sobre</a></li>
                  </ul>
                </div><!--/.nav-collapse -->
              </div>
            </div>
 
            <!-- Criando a estrutura abaixo do menu -->
            </br>
                <div class="row">
                    <div class="form-group col-lg-10">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                              <h3 class="panel-title">Cliente</h3>
                            </div>
                            <div class="panel-body">
                              
                                <!-- Parte de dentro do PANEL, com os dados do cliente -->
                                <form role="form" action="cadastroCliente" method="POST">
               
                                    <div class="row">
                                        
                                        <div class="form-group col-sm-8">
                                            <label for="lTexto" class="control-label">Nome</label>
                                            <input type="text" class="form-control" placeholder="Digite seu nome">
                                        </div>
                                        <div class="form-group col-sm-8">
                                            <label for="lTexto" class="control-label">Telefone</label>
                                            <input type="text" class="form-control" placeholder="Digite seu telefone">
                                        </div>
                                        <div class="form-group col-sm-8">
                                            <label for="lTexto" class="control-label">Email</label>
                                            <input type="email" class="form-control" placeholder="Digite seu Email">
                                        </div>
                                        <div class="form-group col-sm-8">
                                            <label for="lTexto" class="control-label">Endereco</label>
                                            <input type="text" class="form-control" placeholder="Digite seu endereco completo">
                                        </div>
                                       
                                    </div>

                                    <div class="form-group">
                                        <input class="btn btn-lg btn-primary" type="submit" value="Cadastrar">
                                    </div>

                                <!-- FIM FORM DO CLIENTE -->
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

            </div><!-- /.container -->
           
    </body>
</html>
