/*
 * AccessDAOFactory.java
 *
 * Created on 3 de Junho de 2005, 17:10
 */

package tabajara;
/*
 * Classe que herda a classe abstrata DAOFacotry e implementa o
 * metódo abstrato getApartamentoDAO retornado uma nova instância da
 * classe AccessApartamentoDAO
 *
 * @author Dênis Roberto / Diego Silveira
 */
public class AccessDAOFactory extends DAOFactory{
    
    /**
     * Método que implementa o método abstrato getApartamentoDAO definido em DAOFactory
     *
     * @return new AccessApartamentoDAO Instância de AccessApartamentoDAO
     */
    public ApartamentoDAO getApartamentoDAO() {
        return new AccessApartamentoDAO();
    }
}
