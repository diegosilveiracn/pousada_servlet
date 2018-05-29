/*
 * Chale.java
 *
 * Created on 31 de Julho de 2005, 10:56
 */
package tabajara;
/*
 * Classe que descreve as caracter�sticas e as funcionalidade de chal�
 *
 * @author D�nis Roberto / Diego Silveira
 */
public class Chale extends Apartamento {
    
    /** Constate que especifica o n�mero de camas extras m�ximo que podem ser adicionadas ao chal� */
    public static final int MAXCAMASEXTRAS = 3;
    /** N�mero de camas extras a serem adicionadas */
    int numCamasExtras;
    
    /**
     * Construtor da classe que representa o chale
     *
     * @param int numero N�mero do Apartamento Ex.: 102
     */
    public Chale(int numero) {
        numCamasExtras = 0;
        this.setOcupado(false);
        this.setNumero(numero);
    }
    
    /**
     * M�todo para adicionar camas extras em um apartamento do tipo chale
     *
     * @param int camas N�mero de Camas Ex.: 2
     * @exception AdicionarCamasException Caso tente adicionar mais de tr�s camas em um chal�
     */
    public void adicionarCamasExtras(int camas) throws AdicionarCamasException {
        if((numCamasExtras + camas) <= MAXCAMASEXTRAS) {
            numCamasExtras += camas;
        } else {
            throw new AdicionarCamasException(this.MAXCAMASEXTRAS,this.numCamasExtras, camas);
        }
    }
    
    /**
     * M�todo bean getNumCamasExtras
     *
     * @return int getNumCamasExtras N�mero de Camas Extras Ex.: 2
     */
    public int getNumCamasExtras() {
        return this.numCamasExtras;
    }
    
    
    /**
     * M�todo bean setNumCamasExtras
     *
     * @param int numCamasExtras N�mero de Camas Extras Ex.: 2
     */
    public void setNumCamasExtras(int numCamasExtras) {
        this.numCamasExtras = numCamasExtras;
    }
    
    /**
     * M�todo que implementa a efetua��o do c�lculo referente ao total a pagar pelo cliente
     *
     * @return double consultaDespesa O Valor da Despesa Total Ex.: 100,25
     */
    public double consultarDespesa() {
        return (getValorDiaria() * getNumDiasOcupacao()) + getValorConsumo() + (getValorDiaria() * 0.25 * getNumCamasExtras() * getNumDiasOcupacao());
    }
    
    /**
     * M�todo que sobre escreve o m�todo desocupar apartamento, pois � necess�rio inicializar o n�mero de camas
     *
     * @see super.desocupar() M�todo especificado na classe apartamento
     */
    public void desocupar()  throws DesocupadoException {
        super.desocupar();
        this.setNumCamasExtras(0);
    }
}
