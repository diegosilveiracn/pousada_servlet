/*
 * JDBCConnectionImpl.java
 *
 * Created on 6 de Fevereiro de 2006, 21:20
 */
package tabajara;

import java.util.*;
import java.sql.*;
/**
 * Classe para efeturar as coperações de banco de dados propriamente dita
 *
 * @author Dênis Roberto / Diego Silveira
 */
public class JDBCConnectionImpl{
    
    private String dbName;
    
    private Connection conn;
    
    /**
     * Método para uma instância de JDBCConnectionImpl
     *
     * @param String dbName Nome do banco de dados Ex.: Access
     * @exception SQLException
     */
    JDBCConnectionImpl(String dbName) throws SQLException{
        try{
            this.dbName = dbName;
            if (dbName.equals("Access")){
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                String url = "jdbc:odbc:apartamento";
                conn = DriverManager.getConnection(url,"","");
            }
        }catch(ClassNotFoundException e){
            System.out.println("Drive não encontrado!");
        }
    }
    
    /**
     * Método que executa uma select no bando de dados
     *
     * @param String sqlCommand Comando select Ex.: select * from apartamento
     * @exception SQLException
     */
    ResultSet sendRequest(String sqlCommand) throws SQLException{
        ResultSet rs = null;
        Statement stmt = conn.createStatement();
        rs = stmt.executeQuery(sqlCommand);
        
        return rs;
    }
    
    /**
     * Método para executar um insert, update ou delete no banco de dados
     *
     * @param String sqlCommand Comando insert, update ou delete Ex.: insert into apartamento values (1,'Solteiro')
     * @SQLException SQLException
     */
    void sendUpdate(String sqlCommand) throws SQLException{
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sqlCommand);
        stmt.close();
    }
    
}