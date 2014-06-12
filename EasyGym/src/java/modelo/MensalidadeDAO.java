package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MensalidadeDAO {
    public static Mensalidade getMensalidade(int codigo) {
        Connection conn = Conexao.getConexao();       
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Mensalidade mens = null;
        
        try {
                String sql = "Select Cliente, Descricao, DataPagto, ValorPago from MensalidadesPagas where Codigo = ?";
                
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, codigo);
                rs = stmt.executeQuery();
                
                if (rs.next()) {
                    mens = new Mensalidade();                    
                    mens.setCodigo(codigo);                    
                    mens.setCliente(ClienteDAO.getCliente(rs.getInt("Cliente")));
                    mens.setDescricao(rs.getString("Descricao"));
                    mens.setDatapagto(rs.getDate("DataPagto"));
                    mens.setValorpago(rs.getDouble("ValorPago"));
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
        
        return mens;
    }
    
    public static List<Mensalidade> getListaMensalidade(){
        List<Mensalidade> lista = new ArrayList();

        Connection conn = Conexao.getConexao();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Mensalidade mens = null;
       
        try {
                String sql = "Select Codigo, Cliente, Descricao, DataPagto, ValorPago from MensalidadesPagas";
                
                stmt = conn.prepareStatement(sql);
                rs = stmt.executeQuery();
                
                while (rs.next()) {
                    mens = new Mensalidade(); 
                    mens.setCodigo(rs.getInt("Codigo"));                    
                    mens.setCliente(ClienteDAO.getCliente(rs.getInt("Cliente")));
                    mens.setDescricao(rs.getString("Descricao"));
                    mens.setDatapagto(rs.getDate("DataPagto"));
                    mens.setValorpago(rs.getDouble("ValorPago")); 

                    lista.add(mens);
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
    
    public static void salvarMensalidade(Mensalidade mens) {
       Connection conn = Conexao.getConexao();
       PreparedStatement stmt = null;
       
        try {
                String sql;                
                
                if (getMensalidade(mens.getCodigo()) == null) {
                    sql = "insert into MensalidadesPagas values (?, ?, ?, ?, ?)";
                    stmt = conn.prepareStatement(sql);
                    stmt.setInt(1, mens.getCodigo());
                    stmt.setInt(2, mens.getCliente().getCodigo());
                    stmt.setString(3, mens.getDescricao());
                    stmt.setDate(4, new java.sql.Date(mens.getDatapagto().getTime()));
                    stmt.setDouble(5, mens.getValorpago());
                    stmt.executeUpdate();
                } else {
                    sql = "update MensalidadesPagas set Cliente = ?, Descricao = ?, DataPagto = ?, ValorPago = ?" +
                          " where Codigo = ?";  
                    
                    stmt = conn.prepareStatement(sql);
                    stmt.setInt(1, mens.getCliente().getCodigo());
                    stmt.setString(2, mens.getDescricao());
                    stmt.setDate(3, new java.sql.Date(mens.getDatapagto().getTime()));
                    stmt.setDouble(4, mens.getValorpago());
                    stmt.setInt(5, mens.getCodigo());
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
