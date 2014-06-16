<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Financeiro - Filtro Cliente</title>

        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />
        <link rel="stylesheet" href="css/datepicker.css" media="screen"/>
        <script type="text/javascript" src="https://code.jquery.com/jquery.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/bootstrap-datepicker.js"></script>
        <script type="text/javascript" src="js/bootstrap-datepicker.pt-BR.js"></script>
            <!-- Custom styles for this template -->
    <link href="http://getbootstrap.com/examples/starter-template/starter-template.css" rel="stylesheet">
    </head>
    
    <body>
        <script type="text/javascript">
            $(function(){
             var options = new Array();
             options['language'] = 'pt-BR';
             options['viewMode'] = 'months';
             options['format'] = 'mm-yyyy';
             options['minViewMode'] = "months";
             $('#datepicker').datepicker(options);
            });
        </script>
            
        <div class="container">
            <jsp:include page="cabecalho.jsp"> 
                <jsp:param name="indiceMenu" value="2"/>
            </jsp:include>
                          
            <!-- Criando a estrutura abaixo do menu -->
            </br>
                <!-- PANEL DO RESULTADO DOS CLIENTES-->
                
                <div class="row">
                    <div class="form-group col-lg-10">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                              <h3 class="panel-title">Financeiro Pendente</h3>
                            </div>
                            <div class="panel-body">
                                <form role="form" action="listarFinanceiro" method="POST">
                                    <div class="row">

                                        <div class="form-group col-sm-8">
                                            <label for="lTexto" class="control-label">Nome</label>
                                            <input type="text" class="form-control" placeholder="Digite o nome do cliente" name="filtroNome" value="${filtroNome}"> 	
                                        </div>  
                                        
                                        <div class="form-group col-md-8">
                                            <label for="lTexto" class="control-label">Mês/Ano</label>
                                            <div class="input-append date" id="datepicker" data-date="${filtroData}" data-date-format="mm-yyyy">
                                                <input  type="text" readonly="true" name="filtroData" value="${filtroData}">                                                
                                                <span class="addon"><i class="glyphicon glyphicon-calendar"></i></span>
                                            </div>
                                        </div>         
                                    </div>
                                                                           
                                    <div class="form-group">
                                        <input class="btn btn-lg btn-primary" type="submit" name="btnFiltrar" value="Pesquisar">
                                    </div>
                                <!-- FIM FORM DO CLIENTE -->
                                </form>
                                <!-- Parte de dentro do PANEL, Resultados dos clientes da busca -->
                                <table class="table table-striped">
                                    
                                    <!-- criando linha por linha com o TR-->
                                    <tr>
                                        <th>Nome do Cliente</th>
                                        <th>Valor A Pagar</th>
                                        <th>Pagar</th>
                                    </tr>
                                    
                                    <c:if test="${empty financeiroAberto}">
                                        <tr bgcolor="#f0f0f0">
                                        <td colspan="3"><i>Não há financeiro pendente para os filtros informados.</i></td>
                                    </c:if>
                                        
                                    <c:forEach var="finan" items="${financeiroAberto}" varStatus="a">
                                        <tr bgcolor="#f0f0f0">
                                        <td>${finan.descricao}</td>
                                        <td>${finan.valorpago}</td>
                                        <td><a href="selecionarFinanceiro?codigo=${finan.cliente.codigo}&data=${filtroData}&valor=${finan.valorpago}"><span class="glyphicon glyphicon-ok"></a></td>
                                    </c:forEach>        
                                    
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

            </div><!-- /.container -->
           
    </body>
</html>
