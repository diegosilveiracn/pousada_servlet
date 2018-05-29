/*
 * AdicionarCamaException.java
 *
 * Created on 31 de Julho de 2005, 11:11
 */
package tabajara;
/*
 * Classe referente à exceção de adicionar camas extras à um chalé quando
 * a quantidade é superior a 3 camas
 *
 * @author Dênis Roberto / Diego Silveira
 */
public class AdicionarCamasException extends java.lang.Exception 
{
    
    /**
     * Contrutor da classe de exceção que adiciona camas extras
     * 
     * @param int maxCamasExtras Máximo de camas extras pertmitido Ex.: 3
     * @param int numCamasExtras Número de camas extras que se deseja adicionar Ex.: 2 
     * @see Exception()
     */
    public AdicionarCamasException(int maxCamasExtras,int numCamasExtras,int qtdAddCamasExtras) 
    {
     super("Limite excedido de camas extras( " + maxCamasExtras + " ). Já existem "+ numCamasExtras + " camas extras e tentaram adicionar " + qtdAddCamasExtras + " camas.");
    }
}
