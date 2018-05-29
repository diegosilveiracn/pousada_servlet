/*
 * ApExistenteException.java
 *
 * Created on 6 de Agosto de 2005, 16:36
 */
package tabajara;
/**
 * Classe referenete à exceção de adicionar um apartamento já existente
 *
 * @author Dênis Roberto / Diego Silveira
 */
public class ApExistenteException extends java.lang.Exception {
    
    /** Número do apartamento*/
    public int numero;
    
    /**
     * Contrutor da classe de exceção que adiciona apartamentos
     *
     * @param int num Número do apartamento Ex.: 101
     * @see Exception() 
     */
    public ApExistenteException(int num) {
        super("Apartamento " + num + " já casdastrado!");
        this.numero = num;
    }
}
