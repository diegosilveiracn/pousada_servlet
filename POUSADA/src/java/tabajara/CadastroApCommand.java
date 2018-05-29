package tabajara;

import javax.servlet.http.*;
import javax.servlet.*;

public class CadastroApCommand implements Command{
    public Object execute(HttpServletRequest request, HttpServletResponse response){
        
        PousadaSql pousada = new PousadaSql();
        String resultado = new String();
        try{
            if(request.getParameter("acao").equals("Cadastrar")){
                int numeroAp = Integer.parseInt(request.getParameter("txtNumeroAp"));
                int modeloAp = Integer.parseInt(request.getParameter("cmbModeloAp"));
                int tipoAp = Integer.parseInt(request.getParameter("cmbTipoAp"));
                double valorDiariaAp = Double.parseDouble(request.getParameter("txtValorDiaria"));
                pousada.cadastrarApartamento(numeroAp, modeloAp, tipoAp, valorDiariaAp);
                resultado = "Apartamento%20cadastrado%20com%20sucesso!";
            }
            if(request.getParameter("acao").equals("Excluir")){
                int numeroAp = Integer.parseInt(request.getParameter("cmbNumeroAp"));
                pousada.removerApartamento(numeroAp);
                resultado = "Apartamento%20"+numeroAp+"%20excluido%20com%20sucesso!";
            }
        } catch(Exception e){
            resultado = e.getMessage();
        }
        return resultado;
    }
}