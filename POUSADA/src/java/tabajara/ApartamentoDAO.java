/*
 * ApartamentoDAO.java
 *
 * Created on 23 de Julho de 2005, 19:06
 */
package tabajara;

import java.util.Vector;
import java.sql.SQLException;
/*
 * Interface que possui as assinaturas dos m�todos das classes
 * respons�veis pela persist�ncia dos dados
 *
 * @author D�nis Roberto / Diego Silveira
 */
public interface ApartamentoDAO {

    /**
     * M�todo abstrato que efetua a inser��o de um apartamento no banco de dados
     *
     * @param int numero N�mero do Apartamento Ex.: 101
     * @param int modelo Modelo do Apartamento Ex.: 1 - solteiro(ApSolteiro), 2 - duplo(ApDuplo) e 3 - chal�(Chale)
     * @param int tipo Tipo do Cliente Ex.: 1 - Comum, 2 - Amigo e 3 - S�cio
     * @param double valorDiaria Valor da Di�ria Ex.: 52,30
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public void  insertApartamento(int numero,int modelo,int tipo,double valorDiaria) throws SQLException;

    /**
     * M�todo abstrato que efetua a inser��o de um apartamento no banco de dados
     *
     * @param Apartamento ap Objeto do tipo Apartamento
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public void  insertApartamento(Apartamento ap) throws SQLException;

    /**
     * M�todo abstrado que busca um apartamento no banco de dados com o mesmo n�mero do par�metro especificado
     *
     * @param int numero N�mero do Apartamento Ex.: 101
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public Apartamento findApartamento(int numero) throws SQLException;

    /**
     * M�todo abstrado que retorna todos os Apartamentos de acordo com o status especificado no parametro
     *
     * @param boolean ocupado Status do Apartamento Ex.: true - ocupado ou false - desocupado
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public Vector getAllApartamentos(boolean ocupado) throws SQLException;

    /**
     * M�todo abstrato que efetua a atualiza��o dos dados de um apartamento no banco de dados
     *
     * @param Apartamento ap Objeto do tipo Apartamento
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public boolean updateApartamento(Apartamento ap) throws SQLException;

    /**
     * M�todo abstrato que efetua a ataliza��o de um apartamento no banco de dados
     *
     * @param int numero N�mero do Apartamento Ex.: 101
     * @param int tipo Tipo do Apartamento Ex.: 1 - Standart, 2 - Luxo e 3 - Su�te Executiva
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public boolean updateApartamento(int numero, int tipo) throws SQLException;

    /**
     * M�todo abstrado que remove um apartamento no banco de dados com o mesmo n�mero do par�metro especificado
     *
     * @param int numero N�mero do Apartamento Ex.: 101
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public boolean deleteApartamento(int numero) throws SQLException;

    /**
     * M�todo abstrato que remove um apartamento no banco de dados
     *
     * @param Apartamento ap Objeto do tipo Apartamento
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public boolean deleteApartamento(Apartamento ap) throws SQLException;
    
}
