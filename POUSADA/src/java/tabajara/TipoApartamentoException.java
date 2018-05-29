/*
 * TipoApartamentoException.java
 *
 * Created on 6 de Agosto de 2005, 15:25
 */
package tabajara;
/**
 * Classe referente � exce��o quando se refere a um tipo de apartamento inexistente
 *
 * @author D�nis Roberto / Diego Silveira
 */
public class TipoApartamentoException extends java.lang.Exception {
    
    /** Tipo do apartamento*/
    public int tipo;
    
    /**
     * Contrutor da classe de exce��o de tipo de apartamento inv�lido
     *
     * @param int tip Tipo do apartamento Ex.: 1 - Standart, 2 - Luxo e 3 - Su�te Executiva
     * @see Exception()
     */
    public TipoApartamentoException(int tip) {
        super("Tipo de Apartamento n�o � de Standard/Luxo/Su�te Executiva!");
        this.tipo = tip;
    }
}
