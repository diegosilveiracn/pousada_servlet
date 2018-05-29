/*
 * AdicionarConsumoCommand.java
 *
 * Created on 10 de Fevereiro de 2006, 21:07
 *
 * @author Denis Roberto / Diego Silveira
 */

package tabajara;

import javax.servlet.http.*;
import javax.servlet.*;

public class AdicionarConsumoCommand implements Command{
    public Object execute(HttpServletRequest request, HttpServletResponse response){
        
        PousadaSql pousada = new PousadaSql();
        String resultado = new String();
        try{
            int numeroAp = Integer.parseInt(request.getParameter("txtNumeroAp"));
            int consumoAp = Integer.parseInt(request.getParameter("txtQuantidadeConsumo"));
            pousada.adicionarConsumo(numeroAp, consumoAp);
            resultado = "Consumo%20de%20"+consumoAp+"%20adicionado%20com%20sucesso%20no%20apartamento%20"+numeroAp+"!";

        } catch(Exception e){
            resultado = e.getMessage();
        }
        return resultado;
    }
}