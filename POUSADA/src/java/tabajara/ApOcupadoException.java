/*
 * ApOcupadoException.java
 *
 * Created on 6 de Agosto de 2005, 16:51
 */
package tabajara;
/**
 * Classe referente � exce��o quando se tenta remover um apartamento que est� ocupado
 *
 * @author D�nis Roberto / Diego Silveira
 */
public class ApOcupadoException extends java.lang.Exception {
    
    /** N�mero do apartamento*/
    public int numero;
    
    /**
     * Contrutor da classe de exce��o que remove apartamento
     *
     * @param int num N�mero do apartamento Ex.: 101
     * @see Exception()
     */
    public ApOcupadoException(int num) {
        super("Apartamento " + num + " ocupado! N�o � poss�vel remov�-lo.");
        this.numero = num;
    }
}
