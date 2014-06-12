package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlanoDAO {
    public static Plano getPlano(int codigo) {
        Connection conn = Conexao.getConexao();       
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Plano plano = null;
        
        try {
                String sql = "Select Descricao, Valor from Planos where Codigo = ?";
                
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, codigo);
                rs = stmt.executeQuery();
                
                if (rs.next()) {
                    plano = new Plano(codigo, rs.getString("Descricao"), rs.getDouble("Valor"));
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
        
        return plano;
    }
    
    public static List<Plano> getListaPlanos(){
        List<Plano> lista = new ArrayList();

        Connection conn = Conexao.getConexao();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Plano plano = null;
       
        try {
                String sql = "Select Codigo, Descricao, Valor from Planos";
                
                stmt = conn.prepareStatement(sql);
                rs = stmt.executeQuery();
                
                while (rs.next()) {
                    plano = new Plano(rs.getInt("Codigo"), rs.getString("Descricao"), rs.getDouble("Valor"));

                    lista.add(plano);
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
    
    public static void salvarPlano(Plano plano) {
       Connection conn = Conexao.getConexao();
       PreparedStatement stmt = null;
       
        try {
                String sql;                
                
                if (getPlano(plano.getCodigo()) == null) {
                    sql = "insert into Planos values (?, ?, ?)";
                    stmt = conn.prepareStatement(sql);
                    stmt.setInt(1, plano.getCodigo());
                    stmt.setString(2, plano.getDescricao());
                    stmt.setDouble(3, plano.getValor());
                    stmt.executeUpdate();
                } else {
                    sql = "update Planos set Descricao = ?, Valor = ? where Codigo = ?";  
                    
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, plano.getDescricao());
                    stmt.setDouble(2, plano.getValor());
                    stmt.setInt(3, plano.getCodigo());
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
