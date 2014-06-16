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
                <jsp:param name="indiceMenu" value="2"/>
            </jsp:include>
 
            <!-- Criando a estrutura abaixo do menu -->
            </br>
                <div class="row">
                    <div class="form-group col-lg-10">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                              <h3 class="panel-title">Pagamento de Mensalidade</h3>
                            </div>
                            <div class="panel-body">
                              
                                <!-- Parte de dentro do PANEL, com os dados do cliente -->
                                <form role="form" action="pagarFinanceiro" method="POST">               
                                    <div class="row">
                                        <input type="hidden" name="codigo" value=${mens.cliente.codigo}>
                                        <div class="form-group col-sm-8">
                                            <label for="lTexto" class="control-label">Cliente</label>
                                            <input type="text" readonly="true" class="form-control" name="nomeCliente" value="${mens.cliente.nome}">
                                        </div>          
                                        <div class="form-group col-sm-8">
                                            <label for="lTexto" class="control-label">Plano Atual</label>
                                            <input type="text" readonly="true" class="form-control" name="nomePlano" value="${mens.cliente.plano.descricao}">
                                        </div>                                       
                                        <div class="form-group col-sm-8">
                                            <label for="lTexto" class="control-label">Descrição do Pagamento</label>
                                            <input type="text" class="form-control" name="descricao" value="${mens.descricao}">
                                        </div>
                                        <div class="form-group col-sm-2">
                                            <label for="lTexto" class="control-label">Mês Referente</label>
                                            <input type="text" readonly="true" class="form-control" name="datapagto" style="text-align:center" value="${filtroData}">
                                        </div>
                                        <div class="form-group col-sm-2">
                                            <label for="lTexto" class="control-label">Valor</label>
                                            <input type="text" readonly="true" class="form-control" name="valorpago" style="text-align:right" value="${mens.valorpago}">
                                        </div>                                        
                                    </div>

                                    <div class="form-group">                                         
                                        
                                        <input class="btn btn-lg btn-primary" type="submit" value="Confirmar Pagamento">
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
