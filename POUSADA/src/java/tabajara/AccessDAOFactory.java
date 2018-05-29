/*
 * AccessDAOFactory.java
 *
 * Created on 3 de Junho de 2005, 17:10
 */

package tabajara;
/*
 * Classe que herda a classe abstrata DAOFacotry e implementa o
 * met�do abstrato getApartamentoDAO retornado uma nova inst�ncia da
 * classe AccessApartamentoDAO
 *
 * @author D�nis Roberto / Diego Silveira
 */
public class AccessDAOFactory extends DAOFactory{
    
    /**
     * M�todo que implementa o m�todo abstrato getApartamentoDAO definido em DAOFactory
     *
     * @return new AccessApartamentoDAO Inst�ncia de AccessApartamentoDAO
     */
    public ApartamentoDAO getApartamentoDAO() {
        return new AccessApartamentoDAO();
    }
}
