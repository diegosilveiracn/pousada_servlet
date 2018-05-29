/*
 * ModeloApartamento.java
 *
 * Created on 6 de Agosto de 2005, 16:09
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package tabajara;

/**
 *
 * @author Roberto Cesar
 */
public class ModeloApartamento {
    
     public static final int SOLTEIRO = 1;
     public static final int DUPLO = 2;
     public static final int CHALE = 3;
     
    /** Creates a new instance of ClasseApartamento */
    public ModeloApartamento() {
    }
    
    public static String getDescricao(int modelo)
    {
     switch(modelo)
     {
       case(1): return new String("Solteiro");
       case(2): return new String("Duplo");
       case(3): return new String("Chalé");
       default: return new String("Não Especificado");
     }
    }
    
    public static String getDescricao(Apartamento ap)
    {
       if(ap instanceof ApSolteiro) return new String("Solteiro");
       else if(ap instanceof ApDuplo) return new String("Duplo");
       else if(ap instanceof Chale) return new String("Chalé");
       else return new String("Não Especificado");
    }
    
}
