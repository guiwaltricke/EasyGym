package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.Mensalidade;
import modelo.MensalidadeDAO;
import modelo.Plano;
import modelo.PlanoDAO;

@WebServlet(name = "EasyGym", urlPatterns = {"/EasyGym", 
    "/novoPlano", "/editarPlano", "/salvarPlano",
    "/novoCliente", "/editarCliente", "/salvarCliente", "/listarClientes",
    "/listarFinanceiro", "/selecionarFinanceiro", "/pagarFinanceiro"})
public class EasyGymServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String jsp = null; 
        
        if(request.getRequestURI().endsWith("/novoPlano")){
            jsp = processaNovoPlano(request);
        }else if(request.getRequestURI().endsWith("/editarPlano")){
            jsp = processaEditarPlano(request);
        }else if(request.getRequestURI().endsWith("/salvarPlano")){
            jsp = processaSalvarPlano(request);
        }else if(request.getRequestURI().endsWith("/novoCliente")){
            jsp = processaNovoCliente(request);
        }else if(request.getRequestURI().endsWith("/editarCliente")){
            jsp = processaEditarCliente(request);
        }else if(request.getRequestURI().endsWith("/salvarCliente")){
            jsp = processaSalvarCliente(request);
        }else if(request.getRequestURI().endsWith("/listarClientes")){
            jsp = processaListaClientes(request);
        }else if(request.getRequestURI().endsWith("/listarFinanceiro")){
            jsp = processaListaFinanceiro(request);
        }else if(request.getRequestURI().endsWith("/selecionarFinanceiro")){
            jsp = processaSelecionarFinanceiro(request);
        }else if(request.getRequestURI().endsWith("/pagarFinanceiro")){
            jsp = processaPagarFinanceiro(request);
        }else{
            jsp = null;
        }
        
        if(jsp == null){
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }else{
            request.getRequestDispatcher(jsp).forward(request, response);
        }
    }
        
    private String processaNovoPlano(HttpServletRequest request){
        request.setAttribute("planosCadastrados", PlanoDAO.getListaPlanos());
        return "/cadastroPlano.jsp";
    }
    
    private String processaEditarPlano(HttpServletRequest request){
        request.setAttribute("planosCadastrados", PlanoDAO.getListaPlanos());
        String codigo = request.getParameter("codigo");
        Plano plan = PlanoDAO.getPlano(Integer.parseInt(codigo));
        request.setAttribute("plano", plan);
        return "/cadastroPlano.jsp";
    }
    
    private String processaSalvarPlano(HttpServletRequest request){
        Plano plan = carregarPlano(request); 
        PlanoDAO.salvarPlano(plan);       
        return "/novoPlano";
    }
    
    private Plano carregarPlano(HttpServletRequest request){
        String cod = request.getParameter("codigo");
        
        if (cod.equals("")) {
            cod = "0";
        }
        
        Integer codigo = Integer.parseInt(cod);
        String descricao = request.getParameter("descricao");
        Double valor = Double.parseDouble(request.getParameter("valor"));
        
        Plano plan = new Plano(codigo, descricao, valor);
        
        return plan;
    }
    
    private String processaNovoCliente(HttpServletRequest request){
        return "/cadastroCliente.jsp";
    }
    
    private String processaEditarCliente(HttpServletRequest request){
        String codigo = request.getParameter("codigo");
        Cliente cli = ClienteDAO.getCliente(Integer.parseInt(codigo));
        request.setAttribute("cliente", cli);
        return "/cadastroCliente.jsp";
    }
    
    private String processaSalvarCliente(HttpServletRequest request){
        Cliente cli = carregarCliente(request); 
        ClienteDAO.salvarCliente(cli);       
        return "/listarClientes";
    }
    
    private Cliente carregarCliente(HttpServletRequest request){
        Cliente cli = new Cliente();
        
        String cod = request.getParameter("codigo");
        
        if (cod.equals("")) {
            cod = "0";
        }
        
        Integer codigo = Integer.parseInt(cod);
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String Endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        Integer plano = 2;//Integer.parseInt(request.getParameter("plano"));
        Date dataCadastro = new Date();
        String situacao = request.getParameter("situacao");
                    
        cli.setCodigo(codigo);
        cli.setNome(nome);
        cli.setTelefone(telefone);
        cli.setEndereco(Endereco);
        cli.setEmail(email);
        cli.setPlano(PlanoDAO.getPlano(plano));
        cli.setDatacadastro(dataCadastro);
        cli.setSituacao(situacao);
        
        return cli;
    }
    
    private String processaListaClientes(HttpServletRequest request){
        String filtroNome = request.getParameter("filtroNome");
        request.setAttribute("clientesCadatrados", ClienteDAO.getListaClientes(filtroNome));
         
        String botao = request.getParameter("btnNovo");
        
        if (botao != null) {
            return "/novoCliente";
        } else {
            request.setAttribute("filtroNome", filtroNome);
            return "/filtroCliente.jsp";
        }
    }

   private String processaListaFinanceiro(HttpServletRequest request){
        String filtroNome = request.getParameter("filtroNome");
        String filtroDataStr = request.getParameter("filtroData");
        
        if (filtroDataStr == null){
            filtroDataStr = new SimpleDateFormat("MM-yyyy").format(new Date());
        }
        
        if (filtroDataStr.equals("") && request.getAttribute("filtroData") != null){
            filtroDataStr = request.getAttribute("filtroData").toString();
        }
        
        Date filtroData = null;
        
        if (filtroDataStr != null) {
            try {
                filtroData = new SimpleDateFormat("MM-yyyy").parse(filtroDataStr);
            } catch (ParseException ex) {
                Logger.getLogger(EasyGymServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        request.setAttribute("financeiroAberto", MensalidadeDAO.getListaMensalidadeEmAberto(filtroNome, filtroData));
        request.setAttribute("filtroNome", filtroNome);
        request.setAttribute("filtroData", filtroDataStr);
        return "/filtroFinanceiro.jsp";
    }
   
    private String processaSelecionarFinanceiro(HttpServletRequest request){
        String codigo = request.getParameter("codigo");
        String data = request.getParameter("data");
        String valor = request.getParameter("valor");
        
        Mensalidade mens = new Mensalidade();
        mens.setCliente(ClienteDAO.getCliente(Integer.parseInt(codigo)));        
        mens.setValorpago(Double.parseDouble(valor));
        
        request.setAttribute("mens", mens);
        request.setAttribute("filtroData", data);
        return "/pagamentoMensalidade.jsp";
    }
    
    private Mensalidade carregarMensalidade(HttpServletRequest request){
        Integer codigo = Integer.parseInt(request.getParameter("codigo"));
        String descricao = request.getParameter("descricao");
        Date datapagto = new Date();
        Date dataRef = null;
        String dataRefstr = request.getParameter("datapagto");
        Double valorPago = Double.parseDouble(request.getParameter("valorpago"));
            
        if (dataRefstr != null) {
            try {
                dataRef = new SimpleDateFormat("MM-yyyy").parse(dataRefstr);
            } catch (ParseException ex) {
                Logger.getLogger(EasyGymServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        Mensalidade mens = new Mensalidade();
        
        mens.setCodigo(0);
        mens.setDescricao(descricao);
        mens.setCliente(ClienteDAO.getCliente(codigo));
        mens.setDataRef(dataRef);
        mens.setDatapagto(datapagto);
        mens.setValorpago(valorPago);
        
        request.setAttribute("filtroData", dataRefstr);
               
        return mens;
    }
    
    private String processaPagarFinanceiro(HttpServletRequest request){
        Mensalidade mens = carregarMensalidade(request); 
        MensalidadeDAO.salvarMensalidade(mens);       
        return "/listarFinanceiro";
    }

    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
