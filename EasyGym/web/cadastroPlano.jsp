<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Planos</title>

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
                              <h3 class="panel-title">Novo Plano</h3>
                            </div>
                            <div class="panel-body">
                              
                                <!-- Parte de dentro do PANEL, com os dados do plano -->
                                <form role="form" action="salvarPlano" method="POST">
               
                                    <div class="row">
                                        <input type="hidden" name="codigo" value=${plano.codigo}>
                                        <div class="form-group col-sm-8">
                                            <label for="lTexto" class="control-label">Descrição</label>
                                            <input type="text" class="form-control" placeholder="Digite uma descrição" name="descricao" value="${plano.descricao}">
                                        </div>
                                        <div class="form-group col-sm-8">
                                            <label for="lTexto" class="control-label">Valor</label>
                                            <input type="text" class="form-control" placeholder="Digite o valor do plano" name="valor" value=${plano.valor}>
                                        </div>
                                       
                                    </div>

                                    <div class="form-group">
                                        <input class="btn btn-lg btn-primary" type="submit" value="Confirmar">
                                    </div>

                                <!-- FIM FORM DO PLANO -->
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            <div class="row">
                    <div class="form-group col-lg-10">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                              <h3 class="panel-title">Planos cadastrados</h3>
                            </div>
                            <div class="panel-body">
                              
                                <!-- Parte de dentro do PANEL, com os dados do plano -->
                                <table class="table table-striped">
                                    
                                    <!-- criando linha por linha com o TR-->
                                    <tr>
                                        <th>Descrição</th>
                                        <th>Valor</th>
                                        <th>Editar</th>
                                    </tr>
                                    
                                    <c:if test="${empty planosCadastrados}">
                                        <tr bgcolor="#f0f0f0">
                                        <td colspan="3"><i>Não há planos cadastrados.</i></td>
                                    </c:if>
                                    
                                    
                                    <c:forEach var="p" items="${planosCadastrados}" varStatus="a">
                                        <tr bgcolor="#f0f0f0">
                                        <td>${p.descricao}</td>
                                        <td>${p.valor}</td>
                                        <td><a href="editarPlano?codigo=${p.codigo}"><span class="glyphicon glyphicon-pencil"></span></a></td>                                    
                                
                                    </c:forEach>         
                                        
                                </table>
                                            
                                <!-- FIM FORM DO PLANO -->
                               
                            </div>
                        </div>
                    </div>
                </div>
            
            
            </div><!-- /.container -->
           
    </body>
</html>
