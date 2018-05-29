/*
 * OcupadoException.java
 *
 * Created on 30 de Julho de 2005, 14:48
 */
package tabajara;
/*
 * Classe referente à exceção quando tenta ocupar um apartamento já ocupado
 *
 * @author Dênis Roberto / Diego Silveira
 */
public class OcupadoException extends java.lang.Exception {
    
    /** Número do apartamento*/
    private int numero;
    
    /**
     * Contrutor da classe de exceção de apartamento já ocupado
     *
     * @param int num Número do apartamento Ex.: 101
     * @see Exception()
     */
    public OcupadoException(int num) {
        super("O apartamento " + num + " já está ocupado.");
        this.numero = num;
    }
}
