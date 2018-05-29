/*
 * TipoApartamentoException.java
 *
 * Created on 6 de Agosto de 2005, 15:25
 */
package tabajara;
/**
 * Classe referente à exceção quando se refere a um tipo de apartamento inexistente
 *
 * @author Dênis Roberto / Diego Silveira
 */
public class TipoApartamentoException extends java.lang.Exception {
    
    /** Tipo do apartamento*/
    public int tipo;
    
    /**
     * Contrutor da classe de exceção de tipo de apartamento inválido
     *
     * @param int tip Tipo do apartamento Ex.: 1 - Standart, 2 - Luxo e 3 - Suíte Executiva
     * @see Exception()
     */
    public TipoApartamentoException(int tip) {
        super("Tipo de Apartamento não é de Standard/Luxo/Suíte Executiva!");
        this.tipo = tip;
    }
}
