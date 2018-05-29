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

public class OcuparApCommand implements Command{
    public Object execute(HttpServletRequest request, HttpServletResponse response){
        
        PousadaSql pousada = new PousadaSql();
        String resultado = new String();
        try{
            if(request.getParameter("acao").equals("Ocupar")){
                 int numeroAp = Integer.parseInt(request.getParameter("txtNumeroAp"));
                 int tipoClienteAp = Integer.parseInt(request.getParameter("cmbTipoClienteAp"));
                 int qtdDiasAp = Integer.parseInt(request.getParameter("txtQtdDias"));
                 pousada.ocuparApartamento(numeroAp, tipoClienteAp, qtdDiasAp);
                 resultado = "Apartamento%20"+numeroAp+"%20ocupado%20com%20sucesso!";
           }
           if(request.getParameter("acao").equals("Desocupar")){
                int numeroAp = Integer.parseInt(request.getParameter("cmbNumeroAp"));
                pousada.desocuparApartamento(numeroAp);
                resultado = "Apartamento%20"+numeroAp+"%20desocupado%20com%20sucesso!";
           }
            
        } catch(Exception e){
            resultado = e.getMessage();
        }
        return resultado;
    }
}