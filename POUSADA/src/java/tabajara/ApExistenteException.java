/*
 * ApExistenteException.java
 *
 * Created on 6 de Agosto de 2005, 16:36
 */
package tabajara;
/**
 * Classe referenete � exce��o de adicionar um apartamento j� existente
 *
 * @author D�nis Roberto / Diego Silveira
 */
public class ApExistenteException extends java.lang.Exception {
    
    /** N�mero do apartamento*/
    public int numero;
    
    /**
     * Contrutor da classe de exce��o que adiciona apartamentos
     *
     * @param int num N�mero do apartamento Ex.: 101
     * @see Exception() 
     */
    public ApExistenteException(int num) {
        super("Apartamento " + num + " j� casdastrado!");
        this.numero = num;
    }
}
