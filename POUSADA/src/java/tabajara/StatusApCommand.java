/*
 * ListarStatusCommand.java
 *
 * Created on 10 de Fevereiro de 2006, 21:07
 *
 * @author Denis Roberto / Diego Silveira
 */

package tabajara;

import javax.servlet.http.*;
import javax.servlet.*;

public class StatusApCommand implements Command{
    public Object execute(HttpServletRequest request, HttpServletResponse response){
        
        PousadaSql pousada = new PousadaSql();
        String resultado = new String();
        try{
            int numeroAp = Integer.parseInt(request.getParameter("txtNumeroAp"));
            boolean status = pousada.isOcupado(numeroAp);
            resultado = "Apartamento%20"+numeroAp+"%20"+((status)?"Ocupado":"Desocupado")+"!";

        } catch(Exception e){
            resultado = e.getMessage();
        }
        return resultado;
    }
}