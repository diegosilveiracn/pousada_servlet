/*
 * Chale.java
 *
 * Created on 31 de Julho de 2005, 10:56
 */
package tabajara;
/*
 * Classe que descreve as características e as funcionalidade de chalé
 *
 * @author Dênis Roberto / Diego Silveira
 */
public class Chale extends Apartamento {
    
    /** Constate que especifica o número de camas extras máximo que podem ser adicionadas ao chalé */
    public static final int MAXCAMASEXTRAS = 3;
    /** Número de camas extras a serem adicionadas */
    int numCamasExtras;
    
    /**
     * Construtor da classe que representa o chale
     *
     * @param int numero Número do Apartamento Ex.: 102
     */
    public Chale(int numero) {
        numCamasExtras = 0;
        this.setOcupado(false);
        this.setNumero(numero);
    }
    
    /**
     * Método para adicionar camas extras em um apartamento do tipo chale
     *
     * @param int camas Número de Camas Ex.: 2
     * @exception AdicionarCamasException Caso tente adicionar mais de três camas em um chalé
     */
    public void adicionarCamasExtras(int camas) throws AdicionarCamasException {
        if((numCamasExtras + camas) <= MAXCAMASEXTRAS) {
            numCamasExtras += camas;
        } else {
            throw new AdicionarCamasException(this.MAXCAMASEXTRAS,this.numCamasExtras, camas);
        }
    }
    
    /**
     * Método bean getNumCamasExtras
     *
     * @return int getNumCamasExtras Número de Camas Extras Ex.: 2
     */
    public int getNumCamasExtras() {
        return this.numCamasExtras;
    }
    
    
    /**
     * Método bean setNumCamasExtras
     *
     * @param int numCamasExtras Número de Camas Extras Ex.: 2
     */
    public void setNumCamasExtras(int numCamasExtras) {
        this.numCamasExtras = numCamasExtras;
    }
    
    /**
     * Método que implementa a efetuação do cálculo referente ao total a pagar pelo cliente
     *
     * @return double consultaDespesa O Valor da Despesa Total Ex.: 100,25
     */
    public double consultarDespesa() {
        return (getValorDiaria() * getNumDiasOcupacao()) + getValorConsumo() + (getValorDiaria() * 0.25 * getNumCamasExtras() * getNumDiasOcupacao());
    }
    
    /**
     * Método que sobre escreve o método desocupar apartamento, pois é necessário inicializar o número de camas
     *
     * @see super.desocupar() Método especificado na classe apartamento
     */
    public void desocupar()  throws DesocupadoException {
        super.desocupar();
        this.setNumCamasExtras(0);
    }
}
