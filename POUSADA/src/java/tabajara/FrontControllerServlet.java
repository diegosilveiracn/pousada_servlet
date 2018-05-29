package tabajara;

import java.io.*;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.*;

/*
 * FrontControllerServlet.java
 *
 * Created on 4 de Fevereiro de 2006, 11:21
 *
 * @author Denis Roberto e Diego Silveira
 */
public class FrontControllerServlet extends HttpServlet  {
    
    private HashMap hm = new HashMap();
    
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
        
        String cmd = req.getParameter("cmd");
        Command c = (Command)(hm.get(cmd));
        String retorno = (String)c.execute(req,res);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/main/menu/resultado.jsp?msg="+retorno);
        dispatcher.forward(req, res);
    }
    
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
    
    public FrontControllerServlet() {
        hm.put("cadastrarAp",new CadastroApCommand());
        hm.put("ocuparAp",new OcuparApCommand());
        hm.put("adicionarCamasAp",new AdicionarCamasCommand());
        hm.put("adicionarConsumoAp",new AdicionarConsumoCommand());
        hm.put("adicionarDiasAp",new AdicionarDiasOcupacaoCommand());
        hm.put("statusAp",new StatusApCommand());
        hm.put("consumoAp", new ConsumoApCommand());
        hm.put("totalPagarAp",new TotalPagarApCommand());
        
    }
    
}