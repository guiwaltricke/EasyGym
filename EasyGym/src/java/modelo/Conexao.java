package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    public static Connection getConexao() {
        Connection conn = null;
        
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/data","sa","");
            
        } catch (ClassNotFoundException | SQLException e) {
                System.out.println("ERRO: " + e.getMessage());
        } 
        return conn;
    }
}
