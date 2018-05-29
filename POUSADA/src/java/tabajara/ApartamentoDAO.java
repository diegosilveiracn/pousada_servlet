/*
 * ApartamentoDAO.java
 *
 * Created on 23 de Julho de 2005, 19:06
 */
package tabajara;

import java.util.Vector;
import java.sql.SQLException;
/*
 * Interface que possui as assinaturas dos métodos das classes
 * responsáveis pela persistência dos dados
 *
 * @author Dênis Roberto / Diego Silveira
 */
public interface ApartamentoDAO {

    /**
     * Método abstrato que efetua a inserção de um apartamento no banco de dados
     *
     * @param int numero Número do Apartamento Ex.: 101
     * @param int modelo Modelo do Apartamento Ex.: 1 - solteiro(ApSolteiro), 2 - duplo(ApDuplo) e 3 - chalé(Chale)
     * @param int tipo Tipo do Cliente Ex.: 1 - Comum, 2 - Amigo e 3 - Sócio
     * @param double valorDiaria Valor da Diária Ex.: 52,30
     * @exception SQLException Caso ocorra algum erro na execução do sql
     */
    public void  insertApartamento(int numero,int modelo,int tipo,double valorDiaria) throws SQLException;

    /**
     * Método abstrato que efetua a inserção de um apartamento no banco de dados
     *
     * @param Apartamento ap Objeto do tipo Apartamento
     * @exception SQLException Caso ocorra algum erro na execução do sql
     */
    public void  insertApartamento(Apartamento ap) throws SQLException;

    /**
     * Método abstrado que busca um apartamento no banco de dados com o mesmo número do parâmetro especificado
     *
     * @param int numero Número do Apartamento Ex.: 101
     * @exception SQLException Caso ocorra algum erro na execução do sql
     */
    public Apartamento findApartamento(int numero) throws SQLException;

    /**
     * Método abstrado que retorna todos os Apartamentos de acordo com o status especificado no parametro
     *
     * @param boolean ocupado Status do Apartamento Ex.: true - ocupado ou false - desocupado
     * @exception SQLException Caso ocorra algum erro na execução do sql
     */
    public Vector getAllApartamentos(boolean ocupado) throws SQLException;

    /**
     * Método abstrato que efetua a atualização dos dados de um apartamento no banco de dados
     *
     * @param Apartamento ap Objeto do tipo Apartamento
     * @exception SQLException Caso ocorra algum erro na execução do sql
     */
    public boolean updateApartamento(Apartamento ap) throws SQLException;

    /**
     * Método abstrato que efetua a atalização de um apartamento no banco de dados
     *
     * @param int numero Número do Apartamento Ex.: 101
     * @param int tipo Tipo do Apartamento Ex.: 1 - Standart, 2 - Luxo e 3 - Suíte Executiva
     * @exception SQLException Caso ocorra algum erro na execução do sql
     */
    public boolean updateApartamento(int numero, int tipo) throws SQLException;

    /**
     * Método abstrado que remove um apartamento no banco de dados com o mesmo número do parâmetro especificado
     *
     * @param int numero Número do Apartamento Ex.: 101
     * @exception SQLException Caso ocorra algum erro na execução do sql
     */
    public boolean deleteApartamento(int numero) throws SQLException;

    /**
     * Método abstrato que remove um apartamento no banco de dados
     *
     * @param Apartamento ap Objeto do tipo Apartamento
     * @exception SQLException Caso ocorra algum erro na execução do sql
     */
    public boolean deleteApartamento(Apartamento ap) throws SQLException;
    
}
