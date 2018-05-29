/*
 * AccessApartamentoDAO.java
 *
 * Created on 3 de Junho de 2005, 17:09
 */
package tabajara;

import java.sql.*;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import java.util.*;
/*
 * Classe que implementa os métodos da classe ApartamentoDAO
 * responsáveis pela persistência dos dados
 *
 * @author Dênis Roberto / Diego Silveira
 */
public class AccessApartamentoDAO  implements ApartamentoDAO{
    
    /** atributo que irá armazenar o objto do tipo JBDCConnection */
    JDBCConnection connection;
    /** atributo que irá armazenar o resultado das operações aplicadas sobre o banco de dados */
    ResultSet rs;
    
    /**
     * Construtor da classe AccessApartamentoDAO que realiza a conexão com
     * o banco de dados ACCESS
     */
    public AccessApartamentoDAO() {
        connection =  new JDBCConnection();
    }
    
    /**
     * Método que efetua a inserção de um apartamento no banco de dados
     *
     * @param int numero Número do Apartamento Ex.: 101
     * @param int modelo Modelo do Apartamento Ex.: 1 - solteiro(ApSolteiro), 2 - duplo(ApDuplo) e 3 - chalé(Chale)
     * @param int tipo Tipo do Cliente Ex.: 1 - Comum, 2 - Amigo e 3 - Sócio
     * @param double valorDiaria Valor da Diária Ex.: 52,30
     * @exception SQLException Caso ocorra algum erro na execução do sql
     */
    public void  insertApartamento(int numero,int modelo,int tipo, double valorDiaria) throws SQLException{
        /** Construção da clausula de inserção que será executado no banco de dados */
        String clausula = "insert into apartamento(numero, modelo, tipo, valorDiaria, ocupado) " +
                " values('" + numero + "','" + modelo + "','" + tipo + "','" + valorDiaria + "','false')";
        
        connection.sendUpdate(clausula);
    }
    
    /**
     * Método que efetua a inserção de um apartamento no banco de dados
     *
     * @param Apartamento ap Objeto do tipo Apartamento
     * @exception SQLException Caso ocorra algum erro na execução do sql
     */
    public void  insertApartamento(Apartamento ap) throws SQLException{
        /** Construção da clausula de inserção que será executado no banco de dados */
        String clausula = "insert into apartamento(numero, tipo, valorDiaria, tipoCliente, ocupado, dataInicialOcupacao, numDiasOcupacao, valorConsumo) " +
                "values(" + ap.getNumero() + ", " +
                ap.getTipo() + ", " +
                ap.getValorDiaria() + ", " +
                ap.getTipoCliente() + ", " +
                ap.isOcupado() + ", " +
                ap.getDataInicialOcupacao() + ", " +
                ap.getNumDiasOcupacao() + ", " +
                ap.getValorConsumo() + ")";
        
        connection.sendUpdate(clausula);
    }
    
    /**
     * Método que busca um apartamento no banco de dados com o mesmo número do parâmetro especificado
     *
     * @param int numero Número do Apartamento Ex.: 101
     * @exception SQLException Caso ocorra algum erro na execução do sql
     */
    public Apartamento findApartamento(int numero) throws SQLException{
        Apartamento ap = null;
        double saldo;
        /** Construção da clausula de consulta que será executado no banco de dados */
        String clausula = "select * from apartamento where numero = " + numero ;
        rs = connection.sendRequest(clausula);
        if (rs.next()) {
            /** Recuperação os valores do resultado da consulta */
            int tipo           = rs.getInt("tipo");
            double valorDiaria = rs.getDouble("valorDiaria");
            int tipoCliente    = rs.getInt("tipoCliente");
            boolean ocupado    = (rs.getString("ocupado").equals("true")) ? true : false ;
            //Calendar dataInicialOcupacao = new Calendar(rs.getDate("dataInicialOcupacao"));
            int numDiasOcupacao = rs.getInt("numDiasOcupacao");
            double valorConsumo = rs.getDouble("valorConsumo");
            int modelo = rs.getInt("modelo");
            int numCamasExtras = rs.getInt("numCamasExtras");
            /** Verificando o modelo do apartamento recuperado */
            switch(modelo){
                /** Caso o apartamento recuperado seja do modelo Solteiro (modelo = 1)
                 * será instanciado um objeto do tipo ApSolteiro
                 */
                case 1: ap = new ApSolteiro(numero);
                break;
                /** Caso o apartamento recuperado seja do modelo Duplo (modelo = 2)
                 * será instanciado um objeto do tipo ApDuplo
                 */
                case 2: ap = new ApDuplo(numero);
                break;
                /** Caso o apartamento recuperado seja do modelo Chalé (modelo = 3)
                 * será instanciado um objeto do tipo Chale
                 */
                case 3: ap = new Chale(numero);
                ((Chale)ap).setNumCamasExtras(numCamasExtras);
                break;
            }
            /** inicializando os atributos do ap instanciado acima com os valores recuperados do banco de dados */
            ap.setTipo(tipo);
            ap.setValorDiaria(valorDiaria);
            ap.setTipoCliente(tipoCliente);
            ap.setOcupado(ocupado);
            ap.setNumDiasOcupacao(numDiasOcupacao);
            ap.setValorConsumo(valorConsumo);
            
            return ap;
        }
        return ap;
    }
    
    /**
     * Método que retorna todos os Apartamentos de acordo com o status especificado no parametro
     *
     * @param boolean ocupado Status do Apartamento Ex.: true - ocupado ou false - desocupado
     * @exception SQLException Caso ocorra algum erro na execução do sql
     */
    public Vector getAllApartamentos(boolean status) throws SQLException{
        /** aps é o Vector que contem o retorno do método */
        Vector aps = new Vector();
        Apartamento ap = null;
        /** Construção da clausula de consulta que será executado no banco de dados */
        String clausula = "select * from apartamento where ocupado='" + String.valueOf(status) + "' and numero is not null ";
        
        rs = connection.sendRequest(clausula);
        while(rs.next()) {
            /** Inicalizando os atributos com os valores recuperados do banco de dados */
            int numero         = rs.getInt("numero");
            int tipo           = rs.getInt("tipo");
            int modelo         = rs.getInt("modelo");
            double valorDiaria = Double.parseDouble(rs.getString("valorDiaria"));
            int tipoCliente    = rs.getInt("tipoCliente");
            boolean ocupado    = (rs.getString("ocupado").equals("true")) ? true : false ;
            //Calendar dataInicialOcupacao = new Calendar(rs.getDate("dataInicialOcupacao"));
            int numDiasOcupacao = rs.getInt("numDiasOcupacao");
            double valorConsumo = Double.parseDouble(rs.getString("valorConsumo"));
            
            /** Verificando  o modelo do aprtamento recuperado do banco de dados */
            switch(modelo){
                /** Instanciando um ApSolteiro caso o modelo de ap seja 1(Solteiro)*/
                case 1: ap = new ApSolteiro(numero);
                break;
                /** Instanciando um ApDuplo caso o modelo de ap seja 2(Duplo)*/
                case 2: ap = new ApDuplo(numero);
                break;
                /** Instanciando um Chale caso o modelo de ap seja 3(Chale)*/
                case 3: ap = new Chale(numero);
                break;
            }
            /** Incializando os atributos de ap instanciado acima */
            ap.setTipo(tipo);
            ap.setValorDiaria(valorDiaria);
            ap.setTipoCliente(tipoCliente);
            ap.setOcupado(ocupado);
            ap.setNumDiasOcupacao(numDiasOcupacao);
            ap.setValorConsumo(valorConsumo);
            /** Adicionando o objeto ap no Vector*/
            aps.addElement(ap);
            
        }
        return aps;
    }
    
    /**
     * Método que efetua a atualização dos dados de um apartamento no banco de dados
     *
     * @param Apartamento ap Objeto do tipo Apartamento
     * @exception SQLException Caso ocorra algum erro na execução do sql
     */
    public boolean updateApartamento(Apartamento ap) throws SQLException{
        /** sucesso é um atributo do tipo boolean que retorna true se a exclusão for executada
         * sem problemas no banco de dados, caso contrário é retornado false.
         */
        boolean sucesso = false;
        /** O atributo numCamasExtras é aplicável somente ao apartamento do modelo Chale,
         * Desta forma, se ap não for uma instancia de Chale numCamasExtras será atualizado
         * com o valor 0 (zero), senão será atualizado com o valor retornado por getNumCamasExtras
         */
        int numCamasExtras = 0;
        if(ap instanceof Chale) {
            numCamasExtras = ((Chale)ap).getNumCamasExtras();
        }
        /** Construção da clausula de atualização que será executado no banco de dados */
        String clausula = "update apartamento " +
                " set tipo = " + ap.getTipo() + "," +
                " valorDiaria = '" + String.valueOf(ap.getValorDiaria()) + "'," +
                " tipoCliente = " + ap.getTipoCliente() + "," +
                " ocupado = '" + String.valueOf(ap.isOcupado()) + "'," +
                " numDiasOcupacao = " + ap.getNumDiasOcupacao() + "," +
                " numCamasExtras = " + numCamasExtras + "," +
                " valorConsumo = '" + String.valueOf(ap.getValorConsumo()) + "'" +
                " where numero = " + ap.getNumero() ;
        //" dataInicialOcupacao = '" + ap.getDataInicialOcupacao() + "'," +
        connection.sendUpdate(clausula);
        sucesso = true;
        return sucesso;
    }
    
    /**
     * Método que efetua a atalização de um apartamento no banco de dados
     *
     * @param int numero Número do Apartamento Ex.: 101
     * @param int tipo Tipo do Apartamento Ex.: 1 - Standart, 2 - Luxo e 3 - Suíte Executiva
     * @exception SQLException Caso ocorra algum erro na execução do sql
     */
    public boolean updateApartamento(int numero, int tipo) throws SQLException{
        /** sucesso é um atributo do tipo boolean que retorna true se a atualização for executada
         * sem problemas no banco de dados, caso contrário é retornado false.
         */
        boolean sucesso = false;
        /** Construção da clausula de atualização que será executado no banco de dados */
        String clausula = "update apartamento " +
                " set tipo = " + tipo +
                " where numero = " + "\'" + numero + "\'";
        connection.sendUpdate(clausula);
        sucesso = true;
        return sucesso;
    }
    
    /**
     * Método que remove um apartamento no banco de dados com o mesmo número do parâmetro especificado
     *
     * @param int numero Número do Apartamento Ex.: 101
     * @exception SQLException Caso ocorra algum erro na execução do sql
     */
    public boolean deleteApartamento(int numero) throws SQLException{
        /** sucesso é um atributo do tipo boolean que retorna true se a exclusão for executada
         * sem problemas no banco de dados, caso contrário é retornado false.
         */
        boolean sucesso = false;
        /** Construção da clausula de remoção que será executado no banco de dados */
        String clausula = "delete from apartamento where numero = " + numero;
        connection.sendUpdate(clausula);
        return sucesso;
    }
    
    /**
     * Método que remove um apartamento no banco de dados
     *
     * @param Apartamento ap Objeto do tipo Apartamento
     * @exception SQLException Caso ocorra algum erro na execução do sql
     * @exception Exception Caso ocorra algum erro não realcionado diretamente com o sql
     */
    public boolean deleteApartamento(Apartamento ap) throws SQLException{
        /** sucesso é um atributo do tipo boolean que retorna true se a exclusão for executada
         * sem problemas no banco de dados, caso contrário é retornado false.
         */
        boolean sucesso = false;
        /** Construção da clausula de remoção que será executado no banco de dados */
        String clausula = "delete from apartamento where numero = " + "\'" + ap.getNumero() + "\'";
        
        connection.sendUpdate(clausula);
        return sucesso;
    }
}
