/*
 * DesocupadoException.java
 *
 * Created on 30 de Julho de 2005, 14:55
 */
package tabajara;
/*
 * Classe referente à exceção quando se tenta desocupar um apartamento 
 * já desocupado
 *
 * @author Dênis Roberto / Diego Silveira
 */
public class DesocupadoException extends java.lang.Exception {
    
    /** Número do apartamento*/
    private int numero;
    
    /**
     * Contrutor da classe de exceção que desocupar apartamento
     *
     * @param int num Número do apartamento Ex.: 101
     * @see Exception()
     */
    public DesocupadoException(int num) 
    {
     super("O apartamento " + num + " já está desocupado!");
     this.numero = num;
    }
}
