/*
 * OcuparApCommand.java
 *
 * Created on 10 de Fevereiro de 2006, 21:07
 *
 * @author Denis Roberto / Diego Silveira
 */

package tabajara;

import javax.servlet.http.*;
import javax.servlet.*;

public class AdicionarCamasCommand implements Command{
    public Object execute(HttpServletRequest request, HttpServletResponse response){
        
        PousadaSql pousada = new PousadaSql();
        String resultado = new String();
        try{
            int numeroAp = Integer.parseInt(request.getParameter("txtNumeroAp"));
            int qtdCamasAp = Integer.parseInt(request.getParameter("txtQuantidadeCamasAp"));
            pousada.adicionarCamasExtras(numeroAp, qtdCamasAp);
            resultado = "Camas%20adiconadas%20com%20sucesso%20no%20apartamento%20"+numeroAp+"%20!";

        } catch(Exception e){
            resultado = e.getMessage();
        }
        return resultado;
    }
}