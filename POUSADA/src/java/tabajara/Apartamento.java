/*
 * Apartamento.java
 *
 * Created on 30 de Julho de 2005, 13:05
 */
package tabajara;

import java.util.*;
/*
 * Classe que descreve as características e as funcionalidade de apartamento
 *
 * @author Dênis Roberto / Diego Silveira
 */
public abstract class Apartamento {
    
    /** Número do apartamento */
    private int numero;
    /** Tipo do apartamento */
    private int tipo;
    /** Valor da diária */
    private double valorDiaria;
    /** Tipo do cliente */
    private int tipoCliente;
    /** Status do apartamento */
    private boolean ocupado;
    /** Data inicial da ocupação do apartamento */
    private Calendar dataInicialOcupacao;
    /** Número de dias de ocupação do apartamento */
    private int numDiasOcupacao;
    /** Valor do consumo do apartamento */
    private double valorConsumo;
    
    
    /**
     * Método bean setNumero()
     *
     * @param int numero Número do Apartamento Ex.: 101
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    /**
     * Método bean getNumero()
     *
     * @return int numero Número do Apartamento Ex.: 101
     */
    public int getNumero() {
        return this.numero;
    }
    
    /**
     * Método bean setNumero()
     *
     * @param int tipo Tipo do Apartamento Ex.: 1 - Standart, 2 - Luxo e 3 - Suíte Executiva
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    /**
     * Método bean getTipo()
     *
     * @return int tipo Tipo do Apartamento Ex.: 1 - Standart, 2 - Luxo e 3 - Suíte Executiva
     */
    public int getTipo() {
        return this.tipo;
    }
    
    /**
     * Método bean setValorDiaria
     *
     * @param double valorDiaria Valor da Diária Ex.: 52,30
     */
    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }
    
    /**
     * Método bean getValorDiaria
     *
     * @return double valorDiaria Valor da Diária Ex.: 52,30
     */
    public double getValorDiaria() {
        return this.valorDiaria;
    }
    
    /**
     * Método bean setTipoCliente
     *
     * @param int tipoCliente Tipo Cliente Ex.: 1 - Comum, 2 - Amigo e 3 - Sócio
     */
    public void setTipoCliente(int tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    
    /**
     * Método bean getTipoCliente
     *
     * @return int tipoCliente Tipo do Cliente Ex.: 1 - Comum, 2 - Amigo e 3 - Sócio
     */
    public int getTipoCliente() {
        return this.tipoCliente;
    }
    
    /**
     * Método bean setOcupado
     *
     * @param boolean ocupado Status do Apartamento Ex.: true - ocupado ou false - desocupado
     */
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    /**
     * Método para verificar o status do apartamento
     *
     * @return boolean ocupado Status do Apartamento Ex.: true - ocupado ou false - desocupado
     */
    public boolean isOcupado() {
        return this.ocupado;
    }
    
    /**
     * Método para inicializar a data da ocupação do apartamento com a data corrente do sistema
     */
    public void setDataInicialOcupacao() {
        this.dataInicialOcupacao = Calendar.getInstance();
        Date date = new Date();
        this.dataInicialOcupacao.setTime(date);
    }
    
    /**
     * Método bean getDataIncialOcupacao
     *
     * @param Calendar dataIncialOcupacao Data da Ocupação Incial
     */
    public Calendar getDataInicialOcupacao() {
        return this.dataInicialOcupacao;
    }
    
    /**
     * Método bean setNumDiasOcupacao
     *
     * @param int numDiasOcupado Número de Dias da Ocupação Ex.: 3
     */
    public void setNumDiasOcupacao(int numDiasOcupacao) {
        this.numDiasOcupacao = numDiasOcupacao;
    }
    
    /**
     * Métedo bean gerNumDiasOcupacao
     *
     * @return int numDiasOcupacao Número de dias de ocupação do apartamento Ex.: 3
     */
    public int getNumDiasOcupacao() {
        return this.numDiasOcupacao;
    }
    
    /**
     * Método bean setValorConsumo
     *
     * @param double valorConsumo Valor do Consumo do Hóspede Ex.: 15,50
     */
    public void setValorConsumo(double valorConsumo) {
        this.valorConsumo = valorConsumo;
    }
    
    /**
     * Método bean getValorConsumo
     *
     * @return double valorConsumo Valor do Consumo do Hóspede Ex.: 15,50
     */
    public double getValorConsumo() {
        return this.valorConsumo;
    }
    
    /**
     * Método para efetuar a ocupação do apartamento caso o apartamento esteja desocupado
     *
     * @param int tipoCliente Tipo do Cliente Ex.: 1 - Comum, 2 - Amigo e 3 - Sócio
     * @param int numDiasOcupacao Número de Dias de Ocupação Ex.: 5
     * @see isOcupado Verifica o status do apartamento
     * @exception OcupadoException Caso tente ocupar um apartamento já ocupado
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
     * Método para efetuar a desocupação de um apartamento caso ele esteja ocupado
     *
     * @see isOcupado Verifica o status do apartamento
     * @exception DesocupadoException Caso tente desocupar um apartamento já desocupado
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
     * Método para adicionar consumo de um hóspede
     *
     * @param double despesa Consumo de um Hóspede Ex.: 10,90
     */
    public void adicionarConsumo(double despesa) {
        this.valorConsumo += despesa;
    }
    
    /**
     * Método incrementar dias de ocupação
     *
     * @param int qrDias Dias de Ocupação Ex.: 2
     */
    public void incrementarOcupacao(int qtdDias) {
        this.numDiasOcupacao += qtdDias;
    }
    
    /**
     * Método abstrado que efetua o cálculo referente ao total a pagar pelo cliente
     *
     * @exception TipoApartamentoException Caso o tipo do apartamento seja diferente dos tipos especificados
     *            Ex.: 1 - Standart, 2 - Luxo e 3 - Suíte Executiva
     * @exception TipoClienteException Caso o tipo do cliente seja diferente dos tipos especificados
     *            Ex.: 1 - Comum, 2 - Amigo e 3 - Sócio
     */
    public abstract double consultarDespesa() throws TipoApartamentoException,TipoClienteException;
    
}
