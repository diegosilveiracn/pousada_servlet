/*
 * ApDuplo.java
 *
 * Created on 31 de Julho de 2005, 08:13
 */
package tabajara;
/*
 * Classe que descreve as caracter�sticas e as funcionalidade de apartamento duplo
 *
 * @author D�nis Roberto / Diego Silveira
 */
public class ApDuplo extends Apartamento {
    
    /**
     * Construtor da classe que representa o apartamento duplo
     *
     * @param int numero N�mero do Apartamento
     */
    public ApDuplo(int numero) {
        this.setOcupado(false);
        this.setNumero(numero);
    }
    
    
    /**
     * M�todo que implementa a efetua��o do c�lculo referente ao total a pagar pelo cliente
     *
     * @return double consultaDespesa O Valor da Despesa Total Ex.: 100,25
     * @exception TipoApartamentoException Caso o tipo do apartamento seja diferente dos tipos especificados
     *            Ex.: 1 - Standart, 2 - Luxo e 3 - Su�te Executiva
     * @exception TipoClienteException TipoClienteException Caso o tipo do cliente seja diferente dos tipos especificados
     *            Ex.: 1 - Comum, 2 - Amigo e 3 - S�cio
     */
    public double consultarDespesa() throws TipoApartamentoException,TipoClienteException {
        double despesa;
        if(getTipoCliente() == TipoCliente.SOCIO) {
            switch(getTipo()) {
                case(TipoApartamento.STANDARD):
                {
                    /** Se o cliente for s�cio e estiver hospedado em um apartamento do tipo standard 
                     *  ter� um desconto de 10% sobre o valor da di�ria
                     */
                    despesa = (getValorDiaria() * 0.9 * getNumDiasOcupacao()) + getValorConsumo();
                    return despesa;
                }
                case(TipoApartamento.LUXO):
                {
                    /** Se o cliente for s�cio e estiver hospedado em um apartamento do tipo luxo 
                     *  ter� um desconto de 20% sobre o valor da di�ria
                     */
                    despesa = (getValorDiaria() * 0.8 * getNumDiasOcupacao()) + getValorConsumo();
                    return despesa;
                }
                case(TipoApartamento.EXECUTIVO):
                {
                    /** Se o cliente for s�cio e estiver hospedado em um apartamento do tipo executivo 
                     *  ter� um desconto de 30% sobre o valor da di�ria
                     */                    
                    despesa = (getValorDiaria() * 0.7 * getNumDiasOcupacao()) + getValorConsumo();
                    return despesa;
                }
                default:
                {
                    throw new TipoApartamentoException(getTipo());
                }
            }
        } else {
            if((getTipoCliente() == TipoCliente.AMIGO) || (getTipoCliente() == TipoCliente.COMUM)) {
                despesa = getValorDiaria() * getNumDiasOcupacao() + getValorConsumo();
                return despesa;
            } else {
                throw new TipoClienteException(getTipoCliente());
            }
        }
    }
}
