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
 * Interface que possui as assinaturas dos métodos da classe de controle
 *
 * @author Dênis Roberto / Diego Silveira
 */
public interface RepositorioApartamento {
    /**
     * Método abstrato que efetua a consulta de um apartamento
     *
     * @param int numero Número do Apartamento Ex.: 101
     * @return Apartamento Objeto do tipo Apartamento
     * @exception ApInexistenteException Caso o aparamento informado não exista
     * @exception SQLException Caso ocorra algum erro na execução do sql
     */
    public Apartamento consultarApartamento(int numero) throws ApInexistenteException, SQLException;
    
    /**
     * Método abstrato que efetua o cadastramento de um apartamento
     *
     * @param int numero Número do Apartamento Ex.: 101
     * @param int modelo Modelo do Apartamento Ex.: 1 - solteiro(ApSolteiro), 2 - duplo(ApDuplo) e 3 - chalé(Chale)
     * @param int tipo Tipo do Apartamento Ex.: 1 - Standart, 2 - Luxo e 3 - Suíte Executiva
     * @param double valorDiaria Valor da Diária Ex.: 52,30
     * @exception ModeloApartamentoException Caso o modelo do aparamento informado não esteja especificado
     * @exception ApExistenteException Caso o aparamento informado já exista
     * @exception SQLException Caso ocorra algum erro na execução do sql
     */
    public void cadastrarApartamento(int numero,int modelo,int tipo,double valorDiaria)  throws ModeloApartamentoException, ApExistenteException, SQLException;
    
    /**
     * Método abstrado que efetua a ocupação do apartamento
     *
     * @param int numero Número do Apartamento Ex.: 101
     * @param int tipo Tipo do Cliente Ex.: 1 - Comum, 2 - Amigo e 3 - Sócio
     * @param int numDiasOcupacao Número de dias de ocupação do apartamento Ex.: 3
     * @exception OcupadoException Caso tente ocupar um apartamento já ocupado
     * @exception TipoClienteException Caso o tipo do cliente seja diferente dos tipos especificados
     *            Ex.: 1 - Comum, 2 - Amigo e 3 - Sócio
     * @exception ApInexistenteException Caso o aparamento informado não exista
     * @exception SQLException Caso ocorra algum erro na execução do sql
     */
    public void ocuparApartamento(int numero,int tipoCliente,int numDiasOcupacao) throws OcupadoException,TipoClienteException,ApInexistenteException, SQLException;
    
    /**
     * Método abstrado que efetua a desocupação de um apartamento
     *
     * @param int numero Número do Apartamento Ex.: 101
     * @exception DesocupadoException DesocupadoException Caso tente desocupar um apartamento já desocupado
     * @exception ApInexistenteException Caso o aparamento informado não exista
     * @exception SQLException Caso ocorra algum erro na execução do sql
     */
    public void desocuparApartamento(int numero) throws DesocupadoException, ApInexistenteException, SQLException;
    
    /**
     * Método abstrato que efetua a adição de consumo a um apartamento
     *
     * @param int numero Número do Apartamento Ex.: 101
     * @param double despesa Consumo de um Hóspede Ex.: 10,90
     * @exception ApInexistenteException Caso o aparamento informado não exista
     * @exception SQLException Caso ocorra algum erro na execução do sql
     */
    public void adicionarConsumo(int numero,double despesa) throws ApInexistenteException, SQLException;
    
    /**
     * Método abstrato que efetua a consulta da despesa de um apartamento
     *
     * @param int numero Número do Apartamento Ex.: 101
     * @return double Valor da Despesa Ex.: 100,25
     * @exception ApInexistenteException Caso o aparamento informado não exista
     * @exception TipoApartamentoException Caso o tipo do apartamento seja diferente dos tipos especificados
     *            Ex.: 1 - Standart, 2 - Luxo e 3 - Suíte Executiva
     * @exception TipoClienteException Caso o tipo do cliente seja diferente dos tipos especificados
     *            Ex.: 1 - Comum, 2 - Amigo e 3 - Sócio
     * @exception SQLException Caso ocorra algum erro na execução do sql
     */
    public double consultarDespesa(int numero) throws ApInexistenteException, TipoApartamentoException,TipoClienteException, SQLException;
    
    /**
     * Método abstrado que efetua a adição de camas extras em um chalé
     *
     * @param int numero Número do Apartamento Ex.: 101
     * @param int numCamasExtras Número de Camas Extras Ex.: 2
     * @exception ApInexistenteException Caso o aparamento informado não exista
     * @exception AdicionarCamasException Caso tente adicionar mais de três camas em um chalé
     * @exception ChaleCamasException Caso tente adicionar camas a um apartamento que não é do tipo chalé
     * @exception SQLException Caso ocorra algum erro na execução do sql
     */
    public void adicionarCamasExtras(int numero, int numCamasExtras) throws ApInexistenteException,AdicionarCamasException, ChaleCamasException, SQLException;
    
    /**
     * Método abstrato que efetua a consulta o consumo de um apartamento
     *
     * @param int numero Número do Apartamento Ex.: 101
     * @return double Valor do Consumo Ex.: 15,50
     * @exception ApInexistenteException Caso o aparamento informado não exista
     * @exception SQLException Caso ocorra algum erro na execução do sql
     */
    public double consultarConsumo(int numero) throws ApInexistenteException, SQLException;
    
    /**
     * Método abstrato que verifica o status de um apartamento
     *
     * @param int numero Número do Apartamento Ex.: 101
     * @param boolean Status do Apartamento Ex.: true - ocupado ou false - desocupado
     * @exception ApInexistenteException Caso o aparamento informado não exista
     * @exception SQLException Caso ocorra algum erro na execução do sql
     */
    public boolean isOcupado(int numero) throws ApInexistenteException, SQLException;
    
    /**
     * Método abstrato que lista os apartamentos conforme status
     *
     * @param boolean ocupado Status do Apartamento Ex.: true - ocupado ou false - desocupado
     * @return Vector Lista de Apartamento
     * @exception SQLException Caso ocorra algum erro na execução do sql
     */
    public Vector listarApartamentos(boolean ocupado) throws SQLException;
    
    /**
     * Método abstrato que lista os apartamentos conforme status e data
     *
     * @param boolean ocupado Status do Apartamento Ex.: true - ocupado ou false - desocupado
     * @param Calendar data Data que o apartamento pode estar ocupado ou desocupado Ex.: 01/01/2005 (dd/mm/yyyy)
     * @return Vector Lista de Apartamento
     * @exception SQLException Caso ocorra algum erro na execução do sql
     */
    public Vector listarApartamentos(boolean ocupado,Calendar data) throws SQLException;
    
    /**
     * Método abstrado que efetua a exclusão de um apartamento
     *
     * @param int numero Número do Apartamento Ex.: 101
     * @exception ApInexistenteException Caso o aparamento informado não exista
     * @exception ApOcupadoException Caso tente remover um apartamento já ocupado
     * @exception SQLException Caso ocorra algum erro na execução do sql
     */
    public void removerApartamento(int numero) throws ApInexistenteException, ApOcupadoException, SQLException;
    
    /**
     * Método abstrato que efetua a adição de números de dias de ocupação
     *
     * @param int numero Número do Apartamento Ex.: 101
     * @param int qtdDias Número de adição de dias de ocupação do apartamento Ex.: 3
     * @exception ApInexistenteException Caso o aparamento informado não exista
     * @exception SQLException Caso ocorra algum erro na execução do sql
     */
    public void incrementarOcupacao(int numero,int qtdDias) throws ApInexistenteException, SQLException;
}
