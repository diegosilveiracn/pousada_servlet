/*
 * ApOcupadoException.java
 *
 * Created on 6 de Agosto de 2005, 16:51
 */
package tabajara;
/**
 * Classe referente à exceção quando se tenta remover um apartamento que está ocupado
 *
 * @author Dênis Roberto / Diego Silveira
 */
public class ApOcupadoException extends java.lang.Exception {
    
    /** Número do apartamento*/
    public int numero;
    
    /**
     * Contrutor da classe de exceção que remove apartamento
     *
     * @param int num Número do apartamento Ex.: 101
     * @see Exception()
     */
    public ApOcupadoException(int num) {
        super("Apartamento " + num + " ocupado! Não é possível removê-lo.");
        this.numero = num;
    }
}
