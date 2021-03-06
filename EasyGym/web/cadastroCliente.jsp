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
            <jsp:include page="cabecalho.jsp"> 
                <jsp:param name="indiceMenu" value="1"/>
            </jsp:include>
 
            <!-- Criando a estrutura abaixo do menu -->
            </br>
                <div class="row">
                    <div class="form-group col-lg-10">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                              <h3 class="panel-title">Novo Cliente</h3>
                            </div>
                            <div class="panel-body">
                              
                                <!-- Parte de dentro do PANEL, com os dados do cliente -->
                                <form role="form" action="salvarCliente" method="POST">
               
                                    <div class="row">
                                        <input type="hidden" name="codigo" value=${cliente.codigo}>
                                        <div class="form-group col-sm-8">
                                            <label for="lTexto" class="control-label">Nome</label>
                                            <input type="text" class="form-control" placeholder="Digite seu nome" name="nome" value="${cliente.nome}">
                                        </div>
                                        <div class="form-group col-sm-8">
                                            <label for="lTexto" class="control-label">Telefone</label>
                                            <input type="text" class="form-control" placeholder="Digite seu telefone" name="telefone" value="${cliente.telefone}">
                                        </div>
                                        <div class="form-group col-sm-8">
                                            <label for="lTexto" class="control-label">Email</label>
                                            <input type="email" class="form-control" placeholder="Digite seu Email" name="email" value="${cliente.email}">
                                        </div>
                                        <div class="form-group col-sm-8">
                                            <label for="lTexto" class="control-label">Endereço</label>
                                            <input type="text" class="form-control" placeholder="Digite seu endereco completo" name="endereco" value="${cliente.endereco}">
                                        </div>
                                        <div class="form-group col-sm-8">
                                            <label for="lTexto" class="control-label">Plano</label>  
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
