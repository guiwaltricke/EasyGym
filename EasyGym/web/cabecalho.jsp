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
          <li class="dropdown ${param.indiceMenu == 1 ? "active" : ""}">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Cadastro <b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="listarClientes">Clientes</a></li>
              <li><a href="novoPlano">Planos</a></li>
            </ul>
        </li>
        <li class="dropdown ${param.indiceMenu == 2 ? "active" : ""}"><a href="listarFinanceiro">Financeiro</a></li>
        <li class="dropdown ${param.indiceMenu == 3 ? "active" : ""}">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Relatórios <b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="relFinanceiroPagar">Á Receber</a></li>
              <li><a href="relFinanceiroPago">Mensalidade Pagas</a></li>
              <li><a href="relClientes">Clientes</a></li>
            </ul>
        </li>
        <li class="${param.indiceMenu == 4 ? "active" : ""}"><a href="about.jsp">Sobre</a></li>
      </ul>
    </div><!--/.nav-collapse -->
  </div>
</div>
