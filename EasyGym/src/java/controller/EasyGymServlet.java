package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.Plano;
import modelo.PlanoDAO;

@WebServlet(name = "EasyGym", urlPatterns = {"/EasyGym", 
    "/novoPlano", "/editarPlano", "/salvarPlano",
    "/novoCliente", "/editarCliente", "/salvarCliente", "/listarClientes"})
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
        return null;
    }
    
    private Plano carregarPlano(HttpServletRequest request){
        Integer codigo = Integer.parseInt(request.getParameter("codigo"));
        String descricao = request.getParameter("descricao");
        Double valor = Double.parseDouble("valor");
        
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
        return null;
    }
    
    private Cliente carregarCliente(HttpServletRequest request){
        Cliente cli = new Cliente();
        
        Integer codigo = Integer.parseInt(request.getParameter("codigo"));
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String Endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        Integer plano = Integer.parseInt(request.getParameter("plano"));
        Date dataCadastro = new Date();
        String situacao = request.getParameter("situacao");
                    
        cli.setCodigo(codigo);
        cli.setNome(nome);
        cli.setTelefone(telefone);
        cli.setEndereco(Endereco);
        cli.setEmail(email);
        cli.setPlano(plano);
        cli.setDatacadastro(dataCadastro);
        cli.setSituacao(situacao);
        
        return cli;
    }
    
    private String processaListaClientes(HttpServletRequest request){
        String filtroNome = request.getParameter("filtroNome");
        request.setAttribute("clientesCadatrados", ClienteDAO.getListaClientes(filtroNome));
        return "/filtroCliente.jsp";
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
