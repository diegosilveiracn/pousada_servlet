/*
 * JDBCConnection.java
 *
 * Created on 4 de Fevereiro de 2006, 21:10
 */
package tabajara;

import java.sql.*;

/**
 * Classe chama e execupa as operações de banco de dados
 *
 * @author Dênis Roberto / Diego Silveira
 */
public class JDBCConnection{
    
   private JDBCPool connectionPool = null;
    
    /**
     * Construtor para uma instância de JDBCConnection
     */
    public JDBCConnection(){
        connectionPool = JDBCPool.getInstance();
    }
    
    /**
     * Método para tratar as operações de select
     *
     * @exception SQLException
     */
    public ResultSet sendRequest(String sqlCommand) throws SQLException{
        ResultSet rs = null;
        JDBCConnectionImpl impl = null;
        //Solução por espera ocupada
        while (impl == null) {
            impl = connectionPool.acquireImpl();
        }
        rs = impl.sendRequest(sqlCommand);
        connectionPool.releaseImpl(impl);
        return rs;
    }
    
    /**
     * Método para tratar as operações de insert, update e delete
     *
     * @exeception SQLException
     */
    public void sendUpdate(String sqlCommand) throws SQLException{
        JDBCConnectionImpl impl = null;
        
        while (impl == null) {
            impl = connectionPool.acquireImpl();
        }
        impl.sendUpdate(sqlCommand);
        connectionPool.releaseImpl(impl);
    }
    
}