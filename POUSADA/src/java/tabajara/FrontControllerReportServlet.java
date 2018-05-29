/*
 * FrontControllerReportServlet.java
 *
 * Created on 4 de Fevereiro de 2006, 11:21
 *
 * @author Dênis Roberto / Diego Silveira
 */
package tabajara;

import java.io.*;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class FrontControllerReportServlet extends HttpServlet  {
    
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/main/menu/listagemAp.jsp");
        dispatcher.forward(req, res);
    }
    
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
        doGet(req, res);
    }
}