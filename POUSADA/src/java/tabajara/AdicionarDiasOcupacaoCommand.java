/*
 * AdicionarDiasOcupacaoCommand.java
 *
 * Created on 10 de Fevereiro de 2006, 21:07
 *
 * @author Denis Roberto / Diego Silveira
 */

package tabajara;

import javax.servlet.http.*;
import javax.servlet.*;

public class AdicionarDiasOcupacaoCommand implements Command{
    public Object execute(HttpServletRequest request, HttpServletResponse response){
        
        PousadaSql pousada = new PousadaSql();
        String resultado = new String();
        try{
            int numeroAp = Integer.parseInt(request.getParameter("txtNumeroAp"));
            int qtdDiasAp = Integer.parseInt(request.getParameter("txtQuantidadeDiasAp"));
            pousada.incrementarOcupacao(numeroAp, qtdDiasAp);
            resultado = "Dias%20de%20ocupação%20adicionados%20com%20sucesso%20no%20apartamento%20"+numeroAp+"!";

        } catch(Exception e){
            resultado = e.getMessage();
        }
        return resultado;
    }
}