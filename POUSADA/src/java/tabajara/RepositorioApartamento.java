/*
 * RepositorioApartamento.java
 *
 * Created on 31 de Julho de 2005, 11:44
 */
package tabajara;

import java.util.Vector;
import java.util.Calendar;
import java.sql.SQLException;
/*
 * Interface que possui as assinaturas dos m�todos da classe de controle
 *
 * @author D�nis Roberto / Diego Silveira
 */
public interface RepositorioApartamento {
    /**
     * M�todo abstrato que efetua a consulta de um apartamento
     *
     * @param int numero N�mero do Apartamento Ex.: 101
     * @return Apartamento Objeto do tipo Apartamento
     * @exception ApInexistenteException Caso o aparamento informado n�o exista
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public Apartamento consultarApartamento(int numero) throws ApInexistenteException, SQLException;
    
    /**
     * M�todo abstrato que efetua o cadastramento de um apartamento
     *
     * @param int numero N�mero do Apartamento Ex.: 101
     * @param int modelo Modelo do Apartamento Ex.: 1 - solteiro(ApSolteiro), 2 - duplo(ApDuplo) e 3 - chal�(Chale)
     * @param int tipo Tipo do Apartamento Ex.: 1 - Standart, 2 - Luxo e 3 - Su�te Executiva
     * @param double valorDiaria Valor da Di�ria Ex.: 52,30
     * @exception ModeloApartamentoException Caso o modelo do aparamento informado n�o esteja especificado
     * @exception ApExistenteException Caso o aparamento informado j� exista
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public void cadastrarApartamento(int numero,int modelo,int tipo,double valorDiaria)  throws ModeloApartamentoException, ApExistenteException, SQLException;
    
    /**
     * M�todo abstrado que efetua a ocupa��o do apartamento
     *
     * @param int numero N�mero do Apartamento Ex.: 101
     * @param int tipo Tipo do Cliente Ex.: 1 - Comum, 2 - Amigo e 3 - S�cio
     * @param int numDiasOcupacao N�mero de dias de ocupa��o do apartamento Ex.: 3
     * @exception OcupadoException Caso tente ocupar um apartamento j� ocupado
     * @exception TipoClienteException Caso o tipo do cliente seja diferente dos tipos especificados
     *            Ex.: 1 - Comum, 2 - Amigo e 3 - S�cio
     * @exception ApInexistenteException Caso o aparamento informado n�o exista
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public void ocuparApartamento(int numero,int tipoCliente,int numDiasOcupacao) throws OcupadoException,TipoClienteException,ApInexistenteException, SQLException;
    
    /**
     * M�todo abstrado que efetua a desocupa��o de um apartamento
     *
     * @param int numero N�mero do Apartamento Ex.: 101
     * @exception DesocupadoException DesocupadoException Caso tente desocupar um apartamento j� desocupado
     * @exception ApInexistenteException Caso o aparamento informado n�o exista
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public void desocuparApartamento(int numero) throws DesocupadoException, ApInexistenteException, SQLException;
    
    /**
     * M�todo abstrato que efetua a adi��o de consumo a um apartamento
     *
     * @param int numero N�mero do Apartamento Ex.: 101
     * @param double despesa Consumo de um H�spede Ex.: 10,90
     * @exception ApInexistenteException Caso o aparamento informado n�o exista
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public void adicionarConsumo(int numero,double despesa) throws ApInexistenteException, SQLException;
    
    /**
     * M�todo abstrato que efetua a consulta da despesa de um apartamento
     *
     * @param int numero N�mero do Apartamento Ex.: 101
     * @return double Valor da Despesa Ex.: 100,25
     * @exception ApInexistenteException Caso o aparamento informado n�o exista
     * @exception TipoApartamentoException Caso o tipo do apartamento seja diferente dos tipos especificados
     *            Ex.: 1 - Standart, 2 - Luxo e 3 - Su�te Executiva
     * @exception TipoClienteException Caso o tipo do cliente seja diferente dos tipos especificados
     *            Ex.: 1 - Comum, 2 - Amigo e 3 - S�cio
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public double consultarDespesa(int numero) throws ApInexistenteException, TipoApartamentoException,TipoClienteException, SQLException;
    
    /**
     * M�todo abstrado que efetua a adi��o de camas extras em um chal�
     *
     * @param int numero N�mero do Apartamento Ex.: 101
     * @param int numCamasExtras N�mero de Camas Extras Ex.: 2
     * @exception ApInexistenteException Caso o aparamento informado n�o exista
     * @exception AdicionarCamasException Caso tente adicionar mais de tr�s camas em um chal�
     * @exception ChaleCamasException Caso tente adicionar camas a um apartamento que n�o � do tipo chal�
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public void adicionarCamasExtras(int numero, int numCamasExtras) throws ApInexistenteException,AdicionarCamasException, ChaleCamasException, SQLException;
    
    /**
     * M�todo abstrato que efetua a consulta o consumo de um apartamento
     *
     * @param int numero N�mero do Apartamento Ex.: 101
     * @return double Valor do Consumo Ex.: 15,50
     * @exception ApInexistenteException Caso o aparamento informado n�o exista
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public double consultarConsumo(int numero) throws ApInexistenteException, SQLException;
    
    /**
     * M�todo abstrato que verifica o status de um apartamento
     *
     * @param int numero N�mero do Apartamento Ex.: 101
     * @param boolean Status do Apartamento Ex.: true - ocupado ou false - desocupado
     * @exception ApInexistenteException Caso o aparamento informado n�o exista
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public boolean isOcupado(int numero) throws ApInexistenteException, SQLException;
    
    /**
     * M�todo abstrato que lista os apartamentos conforme status
     *
     * @param boolean ocupado Status do Apartamento Ex.: true - ocupado ou false - desocupado
     * @return Vector Lista de Apartamento
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public Vector listarApartamentos(boolean ocupado) throws SQLException;
    
    /**
     * M�todo abstrato que lista os apartamentos conforme status e data
     *
     * @param boolean ocupado Status do Apartamento Ex.: true - ocupado ou false - desocupado
     * @param Calendar data Data que o apartamento pode estar ocupado ou desocupado Ex.: 01/01/2005 (dd/mm/yyyy)
     * @return Vector Lista de Apartamento
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public Vector listarApartamentos(boolean ocupado,Calendar data) throws SQLException;
    
    /**
     * M�todo abstrado que efetua a exclus�o de um apartamento
     *
     * @param int numero N�mero do Apartamento Ex.: 101
     * @exception ApInexistenteException Caso o aparamento informado n�o exista
     * @exception ApOcupadoException Caso tente remover um apartamento j� ocupado
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public void removerApartamento(int numero) throws ApInexistenteException, ApOcupadoException, SQLException;
    
    /**
     * M�todo abstrato que efetua a adi��o de n�meros de dias de ocupa��o
     *
     * @param int numero N�mero do Apartamento Ex.: 101
     * @param int qtdDias N�mero de adi��o de dias de ocupa��o do apartamento Ex.: 3
     * @exception ApInexistenteException Caso o aparamento informado n�o exista
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public void incrementarOcupacao(int numero,int qtdDias) throws ApInexistenteException, SQLException;
}
