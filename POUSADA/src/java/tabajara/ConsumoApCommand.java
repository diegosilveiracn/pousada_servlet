/*
 * ConsumoApCommand.java
 *
 * Created on 10 de Fevereiro de 2006, 21:07
 *
 * @author Denis Roberto / Diego Silveira
 */

package tabajara;

import javax.servlet.http.*;
import javax.servlet.*;

public class ConsumoApCommand implements Command{
    public Object execute(HttpServletRequest request, HttpServletResponse response){
        
        PousadaSql pousada = new PousadaSql();
        String resultado = new String();
        try{
            int numeroAp = Integer.parseInt(request.getParameter("txtNumeroAp"));
            double total = pousada.consultarConsumo(numeroAp);
            resultado = "Total%20consumo%20R$%20"+total+"!";

        } catch(Exception e){
            resultado = e.getMessage();
        }
        return resultado;
    }
}