/*
 * PousadaSql.java
 *
 * Created on 23 de Julho de 2005, 20:37
 */
package tabajara;

import java.sql.*;
import java.util.Vector;
import java.util.Calendar;
/*
 * Classe que implementa as assinaturas dos m�todos da interface RepositorioApartamento
 *
 * @author D�nis Roberto / Diego Silveira
 */
public class PousadaSql implements RepositorioApartamento {
    
    /** daof � um objeto da classe DAOFactory*/
    DAOFactory daof;
    /** apDao � um objeto da classe ApartamentoDAO */
    ApartamentoDAO apDao;
    
    /**
     * Construtor da classe que representa o pousada que utiliza Banco de dados
     */
    public PousadaSql() {
        daof = DAOFactory.getDAOFactory(DAOFactory.ACCESS);
        apDao = daof.getApartamentoDAO();
    }
    
    /**
     * M�todo que implementa a efetua��o da consulta de um apartamento
     * (Buscar no bacon de dados apartamentos o apartamento com o mesmo n�mero do
     * par�metro especificado)
     *
     * @param int numero N�mero do Apartamento Ex.: 101
     * @return Apartamento Objeto do tipo Apartamento
     * @exception ApInexistenteException Caso o aparamento informado n�o exista
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public Apartamento consultarApartamento(int numero) throws ApInexistenteException, SQLException {
        Apartamento ap;
        ap = apDao.findApartamento(numero);
        if(ap.getNumero() == numero) {
            return ap;
        }
        throw new ApInexistenteException(numero);
    }
    
    /**
     * M�todo que verifica se existe um apartamento cadastrado com um n�mero especificado
     * no par�metro
     *
     * @param int numero N�mero do Apartamento Ex.: 101
     * @return boolean existe Ex.: true - se existe apartamento cadastrado ou false - caso contr�rio
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    private boolean existeApartamento(int numero) throws SQLException{
        boolean existe = false;
        Apartamento ap;
        
        ap = apDao.findApartamento(numero);
        //if(ap.getNumero() == numero)
        if(ap != null) {
            existe = true;
        }
        return existe;
    }
    
    /**
     * M�todo que implementa a efetua��o do cadastramento de um apartamento
     * (Adiciona o objeto ap no banco de dados apartamentos)
     *
     * @param int numero N�mero do Apartamento Ex.: 101
     * @param int modelo Modelo do Apartamento Ex.: 1 - solteiro(ApSolteiro), 2 - duplo(ApDuplo) e 3 - chal�(Chale)
     * @param int tipo Tipo do Apartamento Ex.: 1 - Standart, 2 - Luxo e 3 - Su�te Executiva
     * @param double valorDiaria Valor da Di�ria Ex.: 52,30
     * @see boolean existeApartamento() Verifica se o apartamento j� foi cadastrado ou n�o Ex.: existe true - se existe apartamento cadastrado ou false - caso contr�rio
     * @exception ModeloApartamentoException Caso o modelo do aparamento informado n�o esteja especificado
     * @exception ApExistenteException Caso o aparamento informado j� exista
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public void cadastrarApartamento(int numero,int modelo,int tipo,double valorDiaria) throws ModeloApartamentoException, ApExistenteException, SQLException {
        Apartamento ap;
        /** Verificar se j� existe o apartamento cadastrado. */
        if(!existeApartamento(numero)) {
            if((modelo == ModeloApartamento.SOLTEIRO) || (modelo == ModeloApartamento.DUPLO) || (modelo == ModeloApartamento.CHALE)) {
                apDao.insertApartamento(numero,modelo,tipo,valorDiaria);
            } else {
                throw new ModeloApartamentoException(numero, modelo);
            }
        } else {
            throw new ApExistenteException(numero);
        }
    }
    
    /**
     * M�todo que implementa a efetua��o da ocupa��o do apartamento
     * (Atualiza o objeto ap no banco de dados apartamento)
     *
     * @param int numero N�mero do Apartamento Ex.: 101
     * @param int tipo Tipo do Cliente Ex.: 1 - Comum, 2 - Amigo e 3 - S�cio
     * @param int numDiasOcupacao N�mero de dias de ocupa��o do apartamento Ex.: 3
     * @see consultarApartamento() retorna o objeto do tipo Apartamento caso ele exista
     * @see ocupar() efetua a ocupa��o
     * @exception OcupadoException Caso tente ocupar um apartamento j� ocupado
     * @exception TipoClienteException Caso o tipo do cliente seja diferente dos tipos especificados
     *            Ex.: 1 - Comum, 2 - Amigo e 3 - S�cio
     * @exception ApInexistenteException Caso o aparamento informado n�o exista
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public void ocuparApartamento(int numero,int tipoCliente,int numDiasOcupacao) throws OcupadoException,TipoClienteException,ApInexistenteException, SQLException {
        if((tipoCliente == TipoCliente.AMIGO) || (tipoCliente == TipoCliente.COMUM) || (tipoCliente == TipoCliente.SOCIO)) {
            Apartamento ap;
            ap = consultarApartamento(numero);
            ap.ocupar(tipoCliente, numDiasOcupacao);
            apDao.updateApartamento(ap);
        } else {
            throw new TipoClienteException(tipoCliente);
        }
    }
    
    /**
     * M�todo que implementa a efetua��o da desocupa��o de um apartamento
     * (Atualiza o objeto ap no banco de dados apartamento)
     *
     * @param int numero N�mero do Apartamento Ex.: 101
     * @see consultarApartamento() retorna o objeto do tipo Apartamento caso ele exista
     * @see desocupar() efetua a ocupa��o
     * @exception DesocupadoException DesocupadoException Caso tente desocupar um apartamento j� desocupado
     * @exception ApInexistenteException Caso o aparamento informado n�o exista
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public void desocuparApartamento(int numero) throws DesocupadoException,ApInexistenteException, SQLException {
        Apartamento ap;
        ap = consultarApartamento(numero);
        ap.desocupar();
        apDao.updateApartamento(ap);
    }
    
    /**
     * M�todo que implementa a verifica��o do status de um apartamento
     * (Busca o objeto ap no banco de dados apartamento e retorna o status)
     *
     * @param int numero N�mero do Apartamento Ex.: 101
     * @param boolean Status do Apartamento Ex.: true - ocupado ou false - desocupado
     * @see consultarApartamento() retorna o objeto do tipo Apartamento caso ele exista
     * @exception ApInexistenteException Caso o aparamento informado n�o exista
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public boolean isOcupado(int numero) throws ApInexistenteException, SQLException {
        Apartamento ap;
        ap = consultarApartamento(numero);
        return ap.isOcupado();
    }
    
    /**
     * M�todo implementa a efetua��o da consulta do consumo de um apartamento
     * (Busca o objeto ap no banco de dados apartamento e retorna o consumo)
     *
     * @param int numero N�mero do Apartamento Ex.: 101
     * @return double Valor do Consumo Ex.: 15,50
     * @see consultarApartamento() retorna o objeto do tipo Apartamento caso ele exista
     * @exception ApInexistenteException Caso o aparamento informado n�o exista
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public double consultarConsumo(int numero) throws ApInexistenteException, SQLException {
        Apartamento ap;
        ap = consultarApartamento(numero);
        return ap.getValorConsumo();
    }
    
    /**
     * M�todo que implementa a efetua��o da exclus�o de um apartamento
     * (Remover o objeto no banco de dados apartamento)
     *
     * @param int numero N�mero do Apartamento Ex.: 101
     * @see consultarApartamento() retorna o objeto do tipo Apartamento caso ele exista
     * @exception ApInexistenteException Caso o aparamento informado n�o exista
     * @exception ApOcupadoException Caso tente remover um apartamento j� ocupado
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public void removerApartamento(int numero) throws ApInexistenteException, ApOcupadoException, SQLException {
        Apartamento ap;
        ap = consultarApartamento(numero);
        if(!ap.isOcupado()) {
            apDao.deleteApartamento(numero);
        } else {
            throw new ApOcupadoException(numero);
        }
    }
    
    /**
     * M�todo implementa a efetua��o da consulta da despesa de um apartamento
     * (Busca o objeto ap no banco de dados apartamento e retorna da despesa)
     *
     * @param int numero N�mero do Apartamento Ex.: 101
     * @return double Valor da Despesa Ex.: 100,25
     * @see consultarApartamento() retorna o objeto do tipo Apartamento caso ele exista
     * @exception ApInexistenteException Caso o aparamento informado n�o exista
     * @exception TipoApartamentoException Caso o tipo do apartamento seja diferente dos tipos especificados
     *            Ex.: 1 - Standart, 2 - Luxo e 3 - Su�te Executiva
     * @exception TipoClienteException Caso o tipo do cliente seja diferente dos tipos especificados
     *            Ex.: 1 - Comum, 2 - Amigo e 3 - S�cio
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public double consultarDespesa(int numero) throws ApInexistenteException, TipoApartamentoException,TipoClienteException, SQLException {
        Apartamento ap;
        ap = consultarApartamento(numero);
        return ap.consultarDespesa();
    }
    
    
    /**
     * M�todo que implementa a efetua��o da adi��o de consumo a um apartamento
     * (Atualiza o objeto ap no banco de dados apartamento)
     *
     * @param int numero N�mero do Apartamento Ex.: 101
     * @param double despesa Consumo de um H�spede Ex.: 10,90
     * @see consultarApartamento() retorna o objeto do tipo Apartamento caso ele exista
     * @exception ApInexistenteException Caso o aparamento informado n�o exista
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public void adicionarConsumo(int numero,double despesa) throws ApInexistenteException, SQLException {
        Apartamento ap;
        ap = consultarApartamento(numero);
        ap.adicionarConsumo(despesa);
        apDao.updateApartamento(ap);
    }
    
    /**
     * M�todo que implementa a efetua��o da adi��o de camas extras em um chal�
     * (Atualiza o objeto ap no banco de dados apartamento)
     *
     * @param int numero N�mero do Apartamento Ex.: 101
     * @param int numCamasExtras N�mero de Camas Extras Ex.: 2
     * @see consultarApartamento() retorna o objeto do tipo Apartamento caso ele exista
     * @exception ApInexistenteException Caso o aparamento informado n�o exista
     * @exception AdicionarCamasException Caso tente adicionar mais de tr�s camas em um chal�
     * @exception ChaleCamasException Caso tente adicionar camas a um apartamento que n�o � do tipo chal�
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public void adicionarCamasExtras(int numero, int numCamasExtras) throws ApInexistenteException,AdicionarCamasException, ChaleCamasException, SQLException {
        Apartamento ap;
        ap = consultarApartamento(numero);
        if(ap instanceof Chale) {
            ((Chale)ap).adicionarCamasExtras(numCamasExtras);
            apDao.updateApartamento(ap);
        } else {
            /** Gerar um Exception de opera��o n�o se aplica ao tipo de Apartamento */
            throw new ChaleCamasException(numero);
        }
    }
    
    
    /**
     * M�todo que implementa a efetua��o da adi��o de n�meros de dias de ocupa��o
     * (Atualiza o objeto ap no banco de dados apartamento)
     *
     * @param int numero N�mero do Apartamento Ex.: 101
     * @param int qtdDias N�mero de adi��o de dias de ocupa��o do apartamento Ex.: 3
     * @see consultarApartamento() retorna o objeto do tipo Apartamento caso ele exista
     * @exception ApInexistenteException Caso o aparamento informado n�o exista
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public void incrementarOcupacao(int numero,int qtdDias) throws ApInexistenteException, SQLException {
        Apartamento ap;
        ap = consultarApartamento(numero);
        ap.incrementarOcupacao(qtdDias);
        apDao.updateApartamento(ap);
    }
    
    /**
     * M�todo que implementa a listagem dos apartamentos conforme status
     * (Busca no banco de dados apartamento o apartamento com o mesmo status do
     * par�metro especificado)
     *
     * @param boolean ocupado Status do Apartamento Ex.: true - ocupado ou false - desocupado
     * @return Vector Lista de Apartamento
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public Vector listarApartamentos(boolean ocupado) throws SQLException {
        Vector aps = new Vector();
        aps = apDao.getAllApartamentos(ocupado);
        return aps;
    }
    
    /**
     * M�todo que implementa a listagem dos apartamentos conforme status e data
     * (Busca no banco de dados apartamento procurando o apartamento com o mesmo status dos
     * par�metros especificados)
     *
     * @param boolean ocupado Status do Apartamento Ex.: true - ocupado ou false - desocupado
     * @param Calendar data Data que o apartamento pode estar ocupado ou desocupado Ex.: 01/01/2005 (dd/mm/yyyy)
     * @return Vector Lista de Apartamento
     * @exception SQLException Caso ocorra algum erro na execu��o do sql
     */
    public Vector listarApartamentos(boolean ocupado,Calendar data) throws SQLException {
        Vector aps = new Vector();
        aps = apDao.getAllApartamentos(ocupado);
        return aps;
    }
}
