/*
 * TipoApartamento.java
 *
 * Created on 30 de Julho de 2005, 13:07
 */
package tabajara;
/*
 * Classe que possui possui as constantes est�ticas para representar as
 * inst�ncias da classe Apartamento
 *
 * @author D�nis Roberto / Diego Silveira
 */
public class TipoApartamento {
    
    /**Constante que represante o tipo de apartamento standard*/
    public static final int STANDARD = 1;
    /**Constante que represante o tipo de apartamento luxo*/
    public static final int LUXO = 2;
    /**Constante que represante o tipo de apartamento executivo*/
    public static final int EXECUTIVO = 3;
    
    /**
     * Construtor da classe tipo apartamento
     */
    public TipoApartamento() {
    }
    
    /**
     * M�todo para retornar a descri��o do tipo do apartamento
     *
     * @param int tipoApartamento Ex.: 1 - Standart, 2 - Luxo e 3 - Su�te Executiva
     */
    public static String getDescricao(int tipoApartamento) {
        switch(tipoApartamento) {
            case(1): return new String("Standard");
            case(2): return new String("Luxo");
            case(3): return new String("Executivo");
            default: return new String("N�o Especificado");
        }
    }
}
