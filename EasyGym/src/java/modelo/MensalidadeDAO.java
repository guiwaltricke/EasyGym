package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MensalidadeDAO {
    public static Mensalidade getMensalidade(int codigo) {
        Connection conn = Conexao.getConexao();       
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Mensalidade mens = null;
        
        try {
                String sql = "Select Cliente, Descricao, DataPagto, ValorPago, DataRef from MensalidadesPagas where Codigo = ?";
                
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
                    mens.setDataRef(rs.getDate("DataRef"));
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
    
    public static List<Mensalidade> getListaMensalidade(String nome, Date data){
        List<Mensalidade> lista = new ArrayList();

        Connection conn = Conexao.getConexao();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Mensalidade mens = null;
       
        try {
                String sql = "Select M.Codigo, M.Cliente, M.Descricao, M.DataPagto, M.ValorPago, M.DataRef from MensalidadesPagas M, Clientes C" +
                             " where C.Codigo = M.Cliente";
                
                if (nome != null) {
                    sql += " and C.Nome like '%" + nome + "%'";
                }

                if (data != null) {
                    sql += " and M.DataRef = ?"; 
                }
                
                sql += " Order by C.Nome";
                
                stmt = conn.prepareStatement(sql);
                
                if (data != null) {
                    stmt.setDate(1, new java.sql.Date(data.getTime()));
                }
                
                rs = stmt.executeQuery();
                
                while (rs.next()) {
                    mens = new Mensalidade(); 
                    mens.setCodigo(rs.getInt("Codigo"));                    
                    mens.setCliente(ClienteDAO.getCliente(rs.getInt("Cliente")));
                    mens.setDescricao(rs.getString("Descricao"));
                    mens.setDatapagto(rs.getDate("DataPagto"));
                    mens.setValorpago(rs.getDouble("ValorPago")); 
                    mens.setDataRef(rs.getDate("DataRef"));

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
    
    public static List<Mensalidade> getListaMensalidadeEmAberto(String nome, Date data){
        List<Mensalidade> lista = new ArrayList();

        Connection conn = Conexao.getConexao();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Mensalidade mens = null;
       
        try {
                String sql = "Select C.Codigo, C.Nome, P.Valor from Clientes C, Planos P " +
                             "where P.Codigo = C.Plano and C.DataCadastro <= ?";
               
                if (nome != null) {
                    sql += " and C.Nome like '%" + nome + "%'";
                }
                
                if (data != null) {
                    sql += " and (not C.Codigo in (Select M.Cliente from MensalidadesPagas M " +
                           " where M.DataRef = ?))"; 
                           //" where Extract(Month from M.DataRef) = Extract(Month from ?) and " +
                           //"       Extract(Year from M.DataRef) = Extract(Year from ?)))";
                }
                
                sql += " Order by C.Nome";
                
                stmt = conn.prepareStatement(sql);
                
                if (data != null) {
                    stmt.setDate(1, new java.sql.Date(data.getTime()));
                    stmt.setDate(2, new java.sql.Date(data.getTime()));
                    //stmt.setDate(3, new java.sql.Date(data.getTime()));
                }
                
                rs = stmt.executeQuery();
                
                while (rs.next()) {
                    mens = new Mensalidade(); 
                    mens.setCodigo(rs.getInt("Codigo"));                    
                    mens.setCliente(ClienteDAO.getCliente(rs.getInt("codigo")));
                    mens.setValorpago(rs.getDouble("Valor")); 

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
                    sql = "Select coalesce(Max(Codigo), 0) ultimo from MensalidadesPagas";
                    stmt = conn.prepareStatement(sql);
                    
                    Integer codigo = 0;
                    
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        codigo = rs.getInt("ultimo") + 1;
                    }
                    
                    sql = "insert into MensalidadesPagas values (?, ?, ?, ?, ?, ?)";
                    stmt = conn.prepareStatement(sql);
                    stmt.setInt(1, codigo);
                    stmt.setInt(2, mens.getCliente().getCodigo());
                    stmt.setString(3, mens.getDescricao());
                    stmt.setDate(4, new java.sql.Date(mens.getDatapagto().getTime()));
                    stmt.setDouble(5, mens.getValorpago());
                    stmt.setDate(6, new java.sql.Date(mens.getDataRef().getTime()));
                    stmt.executeUpdate();
                } else {
                    sql = "update MensalidadesPagas set Cliente = ?, Descricao = ?, DataPagto = ?, ValorPago = ?, DataRef = ?" +
                          " where Codigo = ?";  
                    
                    stmt = conn.prepareStatement(sql);
                    stmt.setInt(1, mens.getCliente().getCodigo());
                    stmt.setString(2, mens.getDescricao());
                    stmt.setDate(3, new java.sql.Date(mens.getDatapagto().getTime()));
                    stmt.setDouble(4, mens.getValorpago());
                    stmt.setInt(5, mens.getCodigo());
                    stmt.setDate(6, new java.sql.Date(mens.getDataRef().getTime()));
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
