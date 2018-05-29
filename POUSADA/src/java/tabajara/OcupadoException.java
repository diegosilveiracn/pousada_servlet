/*
 * OcupadoException.java
 *
 * Created on 30 de Julho de 2005, 14:48
 */
package tabajara;
/*
 * Classe referente � exce��o quando tenta ocupar um apartamento j� ocupado
 *
 * @author D�nis Roberto / Diego Silveira
 */
public class OcupadoException extends java.lang.Exception {
    
    /** N�mero do apartamento*/
    private int numero;
    
    /**
     * Contrutor da classe de exce��o de apartamento j� ocupado
     *
     * @param int num N�mero do apartamento Ex.: 101
     * @see Exception()
     */
    public OcupadoException(int num) {
        super("O apartamento " + num + " j� est� ocupado.");
        this.numero = num;
    }
}
