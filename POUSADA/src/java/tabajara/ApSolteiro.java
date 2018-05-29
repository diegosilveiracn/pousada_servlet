/*
 * ApSolteiro.java
 *
 * Created on 31 de Julho de 2005, 08:07
 */
package tabajara;
/*
 * Classe que descreve as caracter�sticas e as funcionalidade de apartamento solteiro
 *
 * @author D�nis Roberto / Diego Silveira
 */
public class ApSolteiro extends Apartamento{
    
    /**
     * Construtor da classe que representa o apartamento solteiro
     *
     * @param int numero N�mero do Apartamento
     */
    public ApSolteiro(int numero) {
        this.setOcupado(false);
        this.setNumero(numero);
    }
    
    /**
     * M�todo que sobre escreve o m�todo desocupar apartamento, pois � necess�rio inicializar o n�mero de camas
     *
     * @see super.desocupar() M�todo especificado na classe apartamento
     */
    public double consultarDespesa() {
        return getValorDiaria() * getNumDiasOcupacao() + getValorConsumo();
    }
}
