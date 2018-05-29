/*
 * DAOFactory.java
 *
 * Created on 23 de Julho de 2005, 20:32
 */
package tabajara;
/*
 * Classe abstrata DAOFacotry responsável por delegar o tipo de banco
 * de dados que usamos na aplicação.
 *
 * @author Dênis Roberto / Diego Silveira
 */
public abstract class DAOFactory {
    /** Constante que identifica o tipo de banco de dados ACCESS*/
    public static final int ACCESS = 1;
    /**
     * Método abstrato getApartamentoDAO
     *
     * @return new ApartamentoDAO Objeto do tipo ApartamentoDAO
     */
    public abstract ApartamentoDAO getApartamentoDAO();
    /**
     * Método estático que retorna uma instância de uma das subclasses de DAOFactory
     *
     * @param int db Tipo de banco de dados Ex.: 1(ACCESS)
     * @return new DAOFactory Objeto do tipo DAOFactory
     */
    public static DAOFactory getDAOFactory(int db) {
        /** Verficando qual o tipo de banco de dados foi passado no parâmetro*/
        switch(db) {
            /** Caso db seja igual a 1, ou seja, o banco utilizado é o ACCESS */
            case ACCESS: return new AccessDAOFactory();
            default: return null;
        }
    }
}
