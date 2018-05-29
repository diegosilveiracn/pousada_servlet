/*
 * ApInexistenteException.java
 *
 * Created on 6 de Agosto de 2005, 10:02
 */
package tabajara;
/*
 * Classe referente � exce��o quando � buscado um apartamento n�o existente
 *
 * @author D�nis Roberto / Diego Silveira
 */
public class ApInexistenteException extends java.lang.Exception {
    
    /** N�mero do apartamento*/
    public int numero;
    
    /**
     * Contrutor da classe de exce��o que busca apartamentos
     * 
     * @param int num N�mero do apartamento Ex.: 101
     * @see Exception()
     */
    public ApInexistenteException(int num) {
        super("Apartamento " + num + " n�o encontrado!");
        this.numero = num;
    }  
}
