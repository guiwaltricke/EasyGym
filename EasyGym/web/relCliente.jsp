<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cliente - Filtro Cliente</title>

        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen" />
        <script type="text/javascript" src="https://code.jquery.com/jquery.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        
            <!-- Custom styles for this template -->
    <link href="http://getbootstrap.com/examples/starter-template/starter-template.css" rel="stylesheet">
    </head>
    
    <body>
        <div class="container">            
            <jsp:include page="cabecalho.jsp"> 
                <jsp:param name="indiceMenu" value="3"/>
            </jsp:include>
 
            <!-- Criando a estrutura abaixo do menu -->
            </br>
                <!-- PANEL DO RESULTADO DOS CLIENTES-->
                
                <div class="row">
                    <div class="form-group col-lg-10">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                              <h3 class="panel-title">Clientes cadastrados</h3>
                            </div>
                            <div class="panel-body">
                                <form role="form" action="relClientes" method="POST">
                                    <div class="row">
                                        <div class="form-group col-sm-8">
                                            <label for="lTexto" class="control-label">Nome</label>
                                            <input type="text" class="form-control" placeholder="Digite o nome do cliente" name="filtroNome" value="${filtroNome}">
                                        </div>  
                                        <div class="form-group col-sm-5">
                                            <div class="input-group">
                                                <span class="input-group-addon">
                                                    <input type="checkbox" name="filtroSituacao" ${filtroSituacao == "A" ? "checked='true'" : ""}>
                                                </span>
                                                <input type="text" class="form-control" readonly="true" value="Somente clientes ativos">
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
                                        <th>Telefone</th>
                                        <th>Email</th>
                                    </tr>
                                    
                                    <c:if test="${empty clientesCadatrados}">
                                        <tr bgcolor="#f0f0f0">
                                        <td colspan="4"><i>Não há clientes cadastrados.</i></td>
                                    </c:if>
                                        
                                    <c:forEach var="cliente" items="${clientesCadatrados}" varStatus="a">
                                        <tr bgcolor="#f0f0f0">
                                        <td>${cliente.nome}</td>
                                        <td>${cliente.telefone}</td>
                                        <td>${cliente.email}</td>
                                    </c:forEach>        
                                    
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

            </div><!-- /.container -->
           
    </body>
</html>
