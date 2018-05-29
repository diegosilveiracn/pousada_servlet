/*
 * DesocupadoException.java
 *
 * Created on 30 de Julho de 2005, 14:55
 */
package tabajara;
/*
 * Classe referente � exce��o quando se tenta desocupar um apartamento 
 * j� desocupado
 *
 * @author D�nis Roberto / Diego Silveira
 */
public class DesocupadoException extends java.lang.Exception {
    
    /** N�mero do apartamento*/
    private int numero;
    
    /**
     * Contrutor da classe de exce��o que desocupar apartamento
     *
     * @param int num N�mero do apartamento Ex.: 101
     * @see Exception()
     */
    public DesocupadoException(int num) 
    {
     super("O apartamento " + num + " j� est� desocupado!");
     this.numero = num;
    }
}
