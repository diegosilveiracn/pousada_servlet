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
 * Classe que implementa os m�todos da classe ApartamentoDAO
 * respons�veis pela persist�ncia dos dados
 *
 * @author D�nis Roberto / Diego Silveira
 */
public class AccessApartamentoDAO  implements ApartamentoDAO{
    
    /** atributo que ir� armazenar o objto do tipo JBDCConnection */
    JDBCConnection connection;
    /** atributo que ir� armazenar o resultado das opera��es aplicadas sobre o banco de dados */
    ResultSet rs;
    
    /**
     * Construtor da classe AccessApartamentoDAO que realiza a conex�o com
     * o banco de dados ACCESS
     */
    public AccessApartamentoDAO() {
        connection =  new JDBCConnection();
    }
    
    /**
     * M�todo que efetua a inser��o de um apartamento no banco de dados
     *
     * @param int numero N�mero do Apartamento Ex.: 101
     * @param int modelo Modelo do Apartamento Ex.: 1 - solteiro(ApSolteiro), 2 - duplo(ApDuplo) e 3 - chal�(Chale)
     * @param int tipo Tipo do Cliente Ex.: 1 - Comum, 2 - Amigo e 3 - S�cio
     * @param double valorDiaria Valor da Di�ria Ex.: 52,30
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public void  insertApartamento(int numero,int modelo,int tipo, double valorDiaria) throws SQLException{
        /** Constru��o da clausula de inser��o que ser� executado no banco de dados */
        String clausula = "insert into apartamento(numero, modelo, tipo, valorDiaria, ocupado) " +
                " values('" + numero + "','" + modelo + "','" + tipo + "','" + valorDiaria + "','false')";
        
        connection.sendUpdate(clausula);
    }
    
    /**
     * M�todo que efetua a inser��o de um apartamento no banco de dados
     *
     * @param Apartamento ap Objeto do tipo Apartamento
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public void  insertApartamento(Apartamento ap) throws SQLException{
        /** Constru��o da clausula de inser��o que ser� executado no banco de dados */
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
     * M�todo que busca um apartamento no banco de dados com o mesmo n�mero do par�metro especificado
     *
     * @param int numero N�mero do Apartamento Ex.: 101
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public Apartamento findApartamento(int numero) throws SQLException{
        Apartamento ap = null;
        double saldo;
        /** Constru��o da clausula de consulta que ser� executado no banco de dados */
        String clausula = "select * from apartamento where numero = " + numero ;
        rs = connection.sendRequest(clausula);
        if (rs.next()) {
            /** Recupera��o os valores do resultado da consulta */
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
                 * ser� instanciado um objeto do tipo ApSolteiro
                 */
                case 1: ap = new ApSolteiro(numero);
                break;
                /** Caso o apartamento recuperado seja do modelo Duplo (modelo = 2)
                 * ser� instanciado um objeto do tipo ApDuplo
                 */
                case 2: ap = new ApDuplo(numero);
                break;
                /** Caso o apartamento recuperado seja do modelo Chal� (modelo = 3)
                 * ser� instanciado um objeto do tipo Chale
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
     * M�todo que retorna todos os Apartamentos de acordo com o status especificado no parametro
     *
     * @param boolean ocupado Status do Apartamento Ex.: true - ocupado ou false - desocupado
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public Vector getAllApartamentos(boolean status) throws SQLException{
        /** aps � o Vector que contem o retorno do m�todo */
        Vector aps = new Vector();
        Apartamento ap = null;
        /** Constru��o da clausula de consulta que ser� executado no banco de dados */
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
     * M�todo que efetua a atualiza��o dos dados de um apartamento no banco de dados
     *
     * @param Apartamento ap Objeto do tipo Apartamento
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public boolean updateApartamento(Apartamento ap) throws SQLException{
        /** sucesso � um atributo do tipo boolean que retorna true se a exclus�o for executada
         * sem problemas no banco de dados, caso contr�rio � retornado false.
         */
        boolean sucesso = false;
        /** O atributo numCamasExtras � aplic�vel somente ao apartamento do modelo Chale,
         * Desta forma, se ap n�o for uma instancia de Chale numCamasExtras ser� atualizado
         * com o valor 0 (zero), sen�o ser� atualizado com o valor retornado por getNumCamasExtras
         */
        int numCamasExtras = 0;
        if(ap instanceof Chale) {
            numCamasExtras = ((Chale)ap).getNumCamasExtras();
        }
        /** Constru��o da clausula de atualiza��o que ser� executado no banco de dados */
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
     * M�todo que efetua a ataliza��o de um apartamento no banco de dados
     *
     * @param int numero N�mero do Apartamento Ex.: 101
     * @param int tipo Tipo do Apartamento Ex.: 1 - Standart, 2 - Luxo e 3 - Su�te Executiva
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public boolean updateApartamento(int numero, int tipo) throws SQLException{
        /** sucesso � um atributo do tipo boolean que retorna true se a atualiza��o for executada
         * sem problemas no banco de dados, caso contr�rio � retornado false.
         */
        boolean sucesso = false;
        /** Constru��o da clausula de atualiza��o que ser� executado no banco de dados */
        String clausula = "update apartamento " +
                " set tipo = " + tipo +
                " where numero = " + "\'" + numero + "\'";
        connection.sendUpdate(clausula);
        sucesso = true;
        return sucesso;
    }
    
    /**
     * M�todo que remove um apartamento no banco de dados com o mesmo n�mero do par�metro especificado
     *
     * @param int numero N�mero do Apartamento Ex.: 101
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public boolean deleteApartamento(int numero) throws SQLException{
        /** sucesso � um atributo do tipo boolean que retorna true se a exclus�o for executada
         * sem problemas no banco de dados, caso contr�rio � retornado false.
         */
        boolean sucesso = false;
        /** Constru��o da clausula de remo��o que ser� executado no banco de dados */
        String clausula = "delete from apartamento where numero = " + numero;
        connection.sendUpdate(clausula);
        return sucesso;
    }
    
    /**
     * M�todo que remove um apartamento no banco de dados
     *
     * @param Apartamento ap Objeto do tipo Apartamento
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     * @exception Exception Caso ocorra algum erro n�o realcionado diretamente com o sql
     */
    public boolean deleteApartamento(Apartamento ap) throws SQLException{
        /** sucesso � um atributo do tipo boolean que retorna true se a exclus�o for executada
         * sem problemas no banco de dados, caso contr�rio � retornado false.
         */
        boolean sucesso = false;
        /** Constru��o da clausula de remo��o que ser� executado no banco de dados */
        String clausula = "delete from apartamento where numero = " + "\'" + ap.getNumero() + "\'";
        
        connection.sendUpdate(clausula);
        return sucesso;
    }
}
