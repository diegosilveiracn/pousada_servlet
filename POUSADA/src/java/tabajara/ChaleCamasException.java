/*
 * ChaleCamasException.java
 *
 * Created on 6 de Agosto de 2005, 16:59
 */
package tabajara;
/**
 * Classe referente � exce��o quando se tenta adicionar camas extras aos apartamentos qua n�o s�o do
 * tipo chal�
 *
 * @author D�nis Roberto / Diego Silveira
 */
public class ChaleCamasException extends java.lang.Exception {
    
    /** N�mero do apartamento*/
    public int numero;
    
    /**
     * Contrutor da classe de exce��o que adiciona camas
     *
     * @param int num Num�ro do apartamento Ex.: 101
     * @see Exception()
     */
    public ChaleCamasException(int num) {
        super("Camas s� podem ser adicionadas em apartemantos do tipo chal�!");
        this.numero = num;
    }
}
