/*
 * JDBCPool.java
 *
 * Created on 4 de Fevereiro de 2006, 21:49
 */
package tabajara;

import java.sql.*;
import java.util.*;
/**
 * Classe que controla o acesso ao banco usando poll
 *
 * @author Dênis Roberto / Diego Silveira
 */
public class JDBCPool{
    
    private Vector pool;
    
    public static JDBCPool instance;
    
    /**
     * Método construtor para uma
     *
     * @param numConn Número de conexões Ex.: 5
     * @param dbName Nome do banco de dados Ex.: Access
     */
    private JDBCPool(int numConn, String dbName){
        pool = new Vector();
        try{
            
            for (int i = 1; i <= numConn; i++){
                pool.addElement(new JDBCConnectionImpl(dbName));
            }
        } catch(SQLException e){}
    }
    
    /**
     * Método para conseguir uma instância de JDBCPool
     *
     * @return JDBCPool instance Instância de JDBCPool
     */
    public static synchronized JDBCPool getInstance(){
        if (instance == null){
            instance = new JDBCPool(5, "Access");
        }
        return instance;
    }
    
    /**
     * Método para obter um pool de conexão
     *
     * @exception SQLException
     */
    public synchronized JDBCConnectionImpl acquireImpl() throws SQLException{
        JDBCConnectionImpl impl = null;
        int size = pool.size();
        if (size > 0){
            impl = (JDBCConnectionImpl) pool.elementAt(size-1);
            pool.removeElementAt(size-1);
        }
        
        return impl;        
    }
    
    /**
     * Método para desolver o pool de conexão
     */
    public synchronized void releaseImpl(JDBCConnectionImpl impl){
        
        if (impl != null){
            pool.addElement(impl);
        }
    }
}