package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    
    public static Cliente getCliente(int codigo) {
        Connection conn = Conexao.getConexao();       
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        
        try {
                String sql = "Select Nome, Telefone, Endereco, Email, Plano, DataCadastro, Situacao " +
                             "from Clientes where Codigo = ?";
                
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, codigo);
                rs = stmt.executeQuery();
                
                if (rs.next()) {
                    cliente = new Cliente();
                    cliente.setCodigo(codigo);
                    cliente.setNome(rs.getString("Nome"));
                    cliente.setTelefone(rs.getString("Telefone"));
                    cliente.setEndereco(rs.getString("Endereco"));
                    cliente.setEmail(rs.getString("Email"));
                    cliente.setPlano(PlanoDAO.getPlano(rs.getInt("Plano")));
                    cliente.setDatacadastro(rs.getDate("DataCadastro"));
                    cliente.setSituacao(rs.getString("Situacao"));
                }
                
        } catch (SQLException e) {
                System.out.println("ERRO: " + e.getMessage());
        } finally {
                if(stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {
                        System.out.println("ERRO: " + e.getMessage());
                    }
                }
                if(conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        System.out.println("ERRO: " + e.getMessage());
                    }
                }	
        } 
        
        return cliente;
    }
            
    public static List<Cliente> getListaClientes(String nome){
        List<Cliente> lista = new ArrayList();

        Connection conn = Conexao.getConexao();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
       
        try {
                String sql = "Select Codigo, Nome, Telefone, Endereco, Email, Plano, " +
                             "DataCadastro, Situacao from Clientes ";
                
                if (nome != null) {
                    sql += " where upper(nome) like '%" + nome.toUpperCase() + "%'";
                }
                
                sql += " Order by Nome";
                
                stmt = conn.prepareStatement(sql);
                rs = stmt.executeQuery();
                
                while (rs.next()) {
                    cliente = new Cliente();
                    cliente.setCodigo(rs.getInt("Codigo"));
                    cliente.setNome(rs.getString("Nome"));
                    cliente.setTelefone(rs.getString("Telefone"));
                    cliente.setEndereco(rs.getString("Endereco"));
                    cliente.setEmail(rs.getString("Email"));
                    cliente.setPlano(PlanoDAO.getPlano(rs.getInt("Plano")));
                    cliente.setDatacadastro(rs.getDate("DataCadastro"));
                    cliente.setSituacao(rs.getString("Situacao"));  

                    lista.add(cliente);
                }
        } catch (SQLException e) {
                System.out.println("ERRO: " + e.getMessage());
        } finally {
                if(stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {
                        System.out.println("ERRO: " + e.getMessage());
                    }
                }
                if(conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        System.out.println("ERRO: " + e.getMessage());
                    }
                }	
        } 
               
        return lista;
    }
    
    public static void salvarCliente(Cliente cliente) {
        Connection conn = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
                String sql;                
                
                if (getCliente(cliente.getCodigo()) == null) {
                    Integer codigo = 0;
                    
                    sql = "Select coalesce(Max(Codigo), 0) ultimo from Clientes";
                    stmt = conn.prepareStatement(sql);
                    
                    rs = stmt.executeQuery();

                    if (rs.next()) {
                        codigo = rs.getInt("ultimo") + 1;
                    }
                    
                    sql = "insert into Clientes values (?, ?, ?, ?, ?, ?, ?, ?)";
                    stmt = conn.prepareStatement(sql);
                    stmt.setInt(1, codigo);
                    stmt.setString(2, cliente.getNome());
                    stmt.setString(3, cliente.getTelefone());
                    stmt.setString(4, cliente.getEmail());
                    stmt.setString(5, cliente.getEndereco());            
                    stmt.setString(6, cliente.getSituacao());
                    stmt.setInt(7, cliente.getPlano().getCodigo());        
                    stmt.setDate(8, new java.sql.Date(cliente.getDatacadastro().getTime()));
                    stmt.executeUpdate();
                } else {
                    sql = "update Clientes set Nome = ?, Telefone = ?, Endereco = ?, Email = ?, Plano = ?, Situacao = ?" +
                          "where Codigo = ?";  
                    
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, cliente.getNome());
                    stmt.setString(2, cliente.getTelefone());
                    stmt.setString(3, cliente.getEndereco());
                    stmt.setString(4, cliente.getEmail());
                    stmt.setInt(5, cliente.getPlano().getCodigo());                    
                    stmt.setString(6, cliente.getSituacao());  
                    stmt.setInt(7, cliente.getCodigo());
                    stmt.executeUpdate();
                }
                               
        } catch (SQLException e) {
                System.out.println("ERRO: " + e.getMessage());
        } finally {
                if(stmt != null) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {
                        System.out.println("ERRO: " + e.getMessage());
                    }
                }
                if(conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        System.out.println("ERRO: " + e.getMessage());
                    }
                }	
        }         
    }
}
