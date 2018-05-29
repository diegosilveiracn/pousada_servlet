/*
 * ApInexistenteException.java
 *
 * Created on 6 de Agosto de 2005, 10:02
 */
package tabajara;
/*
 * Classe referente à exceção quando é buscado um apartamento não existente
 *
 * @author Dênis Roberto / Diego Silveira
 */
public class ApInexistenteException extends java.lang.Exception {
    
    /** Número do apartamento*/
    public int numero;
    
    /**
     * Contrutor da classe de exceção que busca apartamentos
     * 
     * @param int num Número do apartamento Ex.: 101
     * @see Exception()
     */
    public ApInexistenteException(int num) {
        super("Apartamento " + num + " não encontrado!");
        this.numero = num;
    }  
}
