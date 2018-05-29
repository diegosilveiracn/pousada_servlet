/*
 * ModeloApartamentoException.java
 *
 * Created on 6 de Agosto de 2005, 16:30
 */
package tabajara;
/**
 * Classe referente à exceção quando é informado um modelo de apartamento que não existe
 *
 * @author Dênis Roberto / Diego Silveira
 */
public class ModeloApartamentoException extends java.lang.Exception {
    
    /** Número do apartamento*/
    public int numero;
    /**Modelo do apartamento*/
    public int modelo;
    
    /**
     * Contrutor da classe de exceção do modelo do apartamento
     *
     * @param int num Número do apartamento Ex.: 101
     * @param int mod Modelo do apartamento Ex.: 1 - solteiro(ApSolteiro), 2 - duplo(ApDuplo) e 3 - chalé(Chale)
     * @see Exception()
     */
    public ModeloApartamentoException(int num, int mod) {
        super("Modelo de apartamento inválida!");
        this.numero = num;
        this.modelo = mod;
    }
}
