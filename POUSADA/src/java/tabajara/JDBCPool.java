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
 * @author D�nis Roberto / Diego Silveira
 */
public class JDBCPool{
    
    private Vector pool;
    
    public static JDBCPool instance;
    
    /**
     * M�todo construtor para uma
     *
     * @param numConn N�mero de conex�es Ex.: 5
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
     * M�todo para conseguir uma inst�ncia de JDBCPool
     *
     * @return JDBCPool instance Inst�ncia de JDBCPool
     */
    public static synchronized JDBCPool getInstance(){
        if (instance == null){
            instance = new JDBCPool(5, "Access");
        }
        return instance;
    }
    
    /**
     * M�todo para obter um pool de conex�o
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
     * M�todo para desolver o pool de conex�o
     */
    public synchronized void releaseImpl(JDBCConnectionImpl impl){
        
        if (impl != null){
            pool.addElement(impl);
        }
    }
}