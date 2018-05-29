/*
 * ChaleCamasException.java
 *
 * Created on 6 de Agosto de 2005, 16:59
 */
package tabajara;
/**
 * Classe referente à exceção quando se tenta adicionar camas extras aos apartamentos qua não são do
 * tipo chalé
 *
 * @author Dênis Roberto / Diego Silveira
 */
public class ChaleCamasException extends java.lang.Exception {
    
    /** Número do apartamento*/
    public int numero;
    
    /**
     * Contrutor da classe de exceção que adiciona camas
     *
     * @param int num Numéro do apartamento Ex.: 101
     * @see Exception()
     */
    public ChaleCamasException(int num) {
        super("Camas só podem ser adicionadas em apartemantos do tipo chalé!");
        this.numero = num;
    }
}
