/*
 * ModeloApartamentoException.java
 *
 * Created on 6 de Agosto de 2005, 16:30
 */
package tabajara;
/**
 * Classe referente � exce��o quando � informado um modelo de apartamento que n�o existe
 *
 * @author D�nis Roberto / Diego Silveira
 */
public class ModeloApartamentoException extends java.lang.Exception {
    
    /** N�mero do apartamento*/
    public int numero;
    /**Modelo do apartamento*/
    public int modelo;
    
    /**
     * Contrutor da classe de exce��o do modelo do apartamento
     *
     * @param int num N�mero do apartamento Ex.: 101
     * @param int mod Modelo do apartamento Ex.: 1 - solteiro(ApSolteiro), 2 - duplo(ApDuplo) e 3 - chal�(Chale)
     * @see Exception()
     */
    public ModeloApartamentoException(int num, int mod) {
        super("Modelo de apartamento inv�lida!");
        this.numero = num;
        this.modelo = mod;
    }
}
