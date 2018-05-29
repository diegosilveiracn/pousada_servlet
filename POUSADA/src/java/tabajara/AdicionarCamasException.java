/*
 * AdicionarCamaException.java
 *
 * Created on 31 de Julho de 2005, 11:11
 */
package tabajara;
/*
 * Classe referente � exce��o de adicionar camas extras � um chal� quando
 * a quantidade � superior a 3 camas
 *
 * @author D�nis Roberto / Diego Silveira
 */
public class AdicionarCamasException extends java.lang.Exception 
{
    
    /**
     * Contrutor da classe de exce��o que adiciona camas extras
     * 
     * @param int maxCamasExtras M�ximo de camas extras pertmitido Ex.: 3
     * @param int numCamasExtras N�mero de camas extras que se deseja adicionar Ex.: 2 
     * @see Exception()
     */
    public AdicionarCamasException(int maxCamasExtras,int numCamasExtras,int qtdAddCamasExtras) 
    {
     super("Limite excedido de camas extras( " + maxCamasExtras + " ). J� existem "+ numCamasExtras + " camas extras e tentaram adicionar " + qtdAddCamasExtras + " camas.");
    }
}
