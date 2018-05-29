/*
 * ApSolteiro.java
 *
 * Created on 31 de Julho de 2005, 08:07
 */
package tabajara;
/*
 * Classe que descreve as características e as funcionalidade de apartamento solteiro
 *
 * @author Dênis Roberto / Diego Silveira
 */
public class ApSolteiro extends Apartamento{
    
    /**
     * Construtor da classe que representa o apartamento solteiro
     *
     * @param int numero Número do Apartamento
     */
    public ApSolteiro(int numero) {
        this.setOcupado(false);
        this.setNumero(numero);
    }
    
    /**
     * Método que sobre escreve o método desocupar apartamento, pois é necessário inicializar o número de camas
     *
     * @see super.desocupar() Método especificado na classe apartamento
     */
    public double consultarDespesa() {
        return getValorDiaria() * getNumDiasOcupacao() + getValorConsumo();
    }
}
