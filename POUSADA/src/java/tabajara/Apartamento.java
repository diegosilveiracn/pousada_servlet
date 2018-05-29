/*
 * Apartamento.java
 *
 * Created on 30 de Julho de 2005, 13:05
 */
package tabajara;

import java.util.*;
/*
 * Classe que descreve as caracter�sticas e as funcionalidade de apartamento
 *
 * @author D�nis Roberto / Diego Silveira
 */
public abstract class Apartamento {
    
    /** N�mero do apartamento */
    private int numero;
    /** Tipo do apartamento */
    private int tipo;
    /** Valor da di�ria */
    private double valorDiaria;
    /** Tipo do cliente */
    private int tipoCliente;
    /** Status do apartamento */
    private boolean ocupado;
    /** Data inicial da ocupa��o do apartamento */
    private Calendar dataInicialOcupacao;
    /** N�mero de dias de ocupa��o do apartamento */
    private int numDiasOcupacao;
    /** Valor do consumo do apartamento */
    private double valorConsumo;
    
    
    /**
     * M�todo bean setNumero()
     *
     * @param int numero N�mero do Apartamento Ex.: 101
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    /**
     * M�todo bean getNumero()
     *
     * @return int numero N�mero do Apartamento Ex.: 101
     */
    public int getNumero() {
        return this.numero;
    }
    
    /**
     * M�todo bean setNumero()
     *
     * @param int tipo Tipo do Apartamento Ex.: 1 - Standart, 2 - Luxo e 3 - Su�te Executiva
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    /**
     * M�todo bean getTipo()
     *
     * @return int tipo Tipo do Apartamento Ex.: 1 - Standart, 2 - Luxo e 3 - Su�te Executiva
     */
    public int getTipo() {
        return this.tipo;
    }
    
    /**
     * M�todo bean setValorDiaria
     *
     * @param double valorDiaria Valor da Di�ria Ex.: 52,30
     */
    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
    
    /**
     * M�todo bean getValorDiaria
     *
     * @return double valorDiaria Valor da Di�ria Ex.: 52,30
     */
    public double getValorDiaria() {
        return this.valorDiaria;
    }
    
    /**
     * M�todo bean setTipoCliente
     *
     * @param int tipoCliente Tipo Cliente Ex.: 1 - Comum, 2 - Amigo e 3 - S�cio
     */
    public void setTipoCliente(int tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    
    /**
     * M�todo bean getTipoCliente
     *
     * @return int tipoCliente Tipo do Cliente Ex.: 1 - Comum, 2 - Amigo e 3 - S�cio
     */
    public int getTipoCliente() {
        return this.tipoCliente;
    }
    
    /**
     * M�todo bean setOcupado
     *
     * @param boolean ocupado Status do Apartamento Ex.: true - ocupado ou false - desocupado
     */
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    /**
     * M�todo para verificar o status do apartamento
     *
     * @return boolean ocupado Status do Apartamento Ex.: true - ocupado ou false - desocupado
     */
    public boolean isOcupado() {
        return this.ocupado;
    }
    
    /**
     * M�todo para inicializar a data da ocupa��o do apartamento com a data corrente do sistema
     */
    public void setDataInicialOcupacao() {
        this.dataInicialOcupacao = Calendar.getInstance();
        Date date = new Date();
        this.dataInicialOcupacao.setTime(date);
    }
    
    /**
     * M�todo bean getDataIncialOcupacao
     *
     * @param Calendar dataIncialOcupacao Data da Ocupa��o Incial
     */
    public Calendar getDataInicialOcupacao() {
        return this.dataInicialOcupacao;
    }
    
    /**
     * M�todo bean setNumDiasOcupacao
     *
     * @param int numDiasOcupado N�mero de Dias da Ocupa��o Ex.: 3
     */
    public void setNumDiasOcupacao(int numDiasOcupacao) {
        this.numDiasOcupacao = numDiasOcupacao;
    }
    
    /**
     * M�tedo bean gerNumDiasOcupacao
     *
     * @return int numDiasOcupacao N�mero de dias de ocupa��o do apartamento Ex.: 3
     */
    public int getNumDiasOcupacao() {
        return this.numDiasOcupacao;
    }
    
    /**
     * M�todo bean setValorConsumo
     *
     * @param double valorConsumo Valor do Consumo do H�spede Ex.: 15,50
     */
    public void setValorConsumo(double valorConsumo) {
        this.valorConsumo = valorConsumo;
    }
    
    /**
     * M�todo bean getValorConsumo
     *
     * @return double valorConsumo Valor do Consumo do H�spede Ex.: 15,50
     */
    public double getValorConsumo() {
        return this.valorConsumo;
    }
    
    /**
     * M�todo para efetuar a ocupa��o do apartamento caso o apartamento esteja desocupado
     *
     * @param int tipoCliente Tipo do Cliente Ex.: 1 - Comum, 2 - Amigo e 3 - S�cio
     * @param int numDiasOcupacao N�mero de Dias de Ocupa��o Ex.: 5
     * @see isOcupado Verifica o status do apartamento
     * @exception OcupadoException Caso tente ocupar um apartamento j� ocupado
     */
    public void ocupar(int tipoCliente,int numDiasOcupacao) throws OcupadoException {
        if(!this.isOcupado()) {
            this.setOcupado(true);
            Date date = new Date();
            this.dataInicialOcupacao = Calendar.getInstance();
            this.dataInicialOcupacao.setTime(date);
            this.setTipoCliente(tipoCliente);
            this.setNumDiasOcupacao(numDiasOcupacao);
        } else {
            throw new OcupadoException(numero);
        }
    }
    
    /**
     * M�todo para efetuar a desocupa��o de um apartamento caso ele esteja ocupado
     *
     * @see isOcupado Verifica o status do apartamento
     * @exception DesocupadoException Caso tente desocupar um apartamento j� desocupado
     */
    public void desocupar() throws DesocupadoException {
        if(this.isOcupado()) {
            ocupado = false;
            this.setTipoCliente(0);
            dataInicialOcupacao = null;
            this.setNumDiasOcupacao(0);
            this.setValorConsumo(0.0);
        } else {
            throw new DesocupadoException(this.getNumero());
        }
    }
    
    /**
     * M�todo para adicionar consumo de um h�spede
     *
     * @param double despesa Consumo de um H�spede Ex.: 10,90
     */
    public void adicionarConsumo(double despesa) {
        this.valorConsumo += despesa;
    }
    
    /**
     * M�todo incrementar dias de ocupa��o
     *
     * @param int qrDias Dias de Ocupa��o Ex.: 2
     */
    public void incrementarOcupacao(int qtdDias) {
        this.numDiasOcupacao += qtdDias;
    }
    
    /**
     * M�todo abstrado que efetua o c�lculo referente ao total a pagar pelo cliente
     *
     * @exception TipoApartamentoException Caso o tipo do apartamento seja diferente dos tipos especificados
     *            Ex.: 1 - Standart, 2 - Luxo e 3 - Su�te Executiva
     * @exception TipoClienteException Caso o tipo do cliente seja diferente dos tipos especificados
     *            Ex.: 1 - Comum, 2 - Amigo e 3 - S�cio
     */
    public abstract double consultarDespesa() throws TipoApartamentoException,TipoClienteException;
    
}
