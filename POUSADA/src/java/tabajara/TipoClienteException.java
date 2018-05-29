/*
 * TipoClienteException.java
 *
 * Created on 6 de Agosto de 2005, 15:39
 */
package tabajara;
/**
 * Classe referente � exce��o quando se refere a um tipo de cliente inexistente
 *
 * @author D�nis Roberto / Diego Silveira
 */
public class TipoClienteException extends java.lang.Exception {
    
    /** Tipo do cliente*/
    public int tipoCliente;
    
    /**
     * Contrutor da classe de exce��o de tipo de cliente inv�lido
     *
     * @param tipCli Tipo de cliente Ex.: 1 - Comum, 2 - Amigo e 3 - S�cio
     * @see Exception()
     */
    public TipoClienteException(int tipCli) {
        super("Tipo de cliente inv�lido!");
        this.tipoCliente = tipCli;
    }
}
