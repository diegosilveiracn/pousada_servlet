/*
 * TipoClienteException.java
 *
 * Created on 6 de Agosto de 2005, 15:39
 */
package tabajara;
/**
 * Classe referente à exceção quando se refere a um tipo de cliente inexistente
 *
 * @author Dênis Roberto / Diego Silveira
 */
public class TipoClienteException extends java.lang.Exception {
    
    /** Tipo do cliente*/
    public int tipoCliente;
    
    /**
     * Contrutor da classe de exceção de tipo de cliente inválido
     *
     * @param tipCli Tipo de cliente Ex.: 1 - Comum, 2 - Amigo e 3 - Sócio
     * @see Exception()
     */
    public TipoClienteException(int tipCli) {
        super("Tipo de cliente inválido!");
        this.tipoCliente = tipCli;
    }
}
