/*
 * JDBCConnection.java
 *
 * Created on 4 de Fevereiro de 2006, 21:10
 */
package tabajara;

import java.sql.*;

/**
 * Classe chama e execupa as opera��es de banco de dados
 *
 * @author D�nis Roberto / Diego Silveira
 */
public class JDBCConnection{
    
   private JDBCPool connectionPool = null;
    
    /**
     * Construtor para uma inst�ncia de JDBCConnection
     */
    public JDBCConnection(){
        connectionPool = JDBCPool.getInstance();
    }
    
    /**
     * M�todo para tratar as opera��es de select
     *
     * @exception SQLException
     */
    public ResultSet sendRequest(String sqlCommand) throws SQLException{
        ResultSet rs = null;
        JDBCConnectionImpl impl = null;
        //Solu��o por espera ocupada
        while (impl == null) {
            impl = connectionPool.acquireImpl();
        }
        rs = impl.sendRequest(sqlCommand);
        connectionPool.releaseImpl(impl);
        return rs;
    }
    
    /**
     * M�todo para tratar as opera��es de insert, update e delete
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