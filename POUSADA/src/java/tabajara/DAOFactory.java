/*
 * DAOFactory.java
 *
 * Created on 23 de Julho de 2005, 20:32
 */
package tabajara;
/*
 * Classe abstrata DAOFacotry respons�vel por delegar o tipo de banco
 * de dados que usamos na aplica��o.
 *
 * @author D�nis Roberto / Diego Silveira
 */
public abstract class DAOFactory {
    /** Constante que identifica o tipo de banco de dados ACCESS*/
    public static final int ACCESS = 1;
    /**
     * M�todo abstrato getApartamentoDAO
     *
     * @return new ApartamentoDAO Objeto do tipo ApartamentoDAO
     */
    public abstract ApartamentoDAO getApartamentoDAO();
    /**
     * M�todo est�tico que retorna uma inst�ncia de uma das subclasses de DAOFactory
     *
     * @param int db Tipo de banco de dados Ex.: 1(ACCESS)
     * @return new DAOFactory Objeto do tipo DAOFactory
     */
    public static DAOFactory getDAOFactory(int db) {
        /** Verficando qual o tipo de banco de dados foi passado no par�metro*/
        switch(db) {
            /** Caso db seja igual a 1, ou seja, o banco utilizado � o ACCESS */
            case ACCESS: return new AccessDAOFactory();
            default: return null;
        }
    }
}
