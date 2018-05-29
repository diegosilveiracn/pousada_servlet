/*
 * Command.java
 *
 * Created on 4 de Fevereiro de 2006, 11:15
 *
 * @author Denis Roberto e Diego Silveira
 */

package tabajara;


import javax.servlet.http.*;
import javax.servlet.*;

  /**
   * Interface do padr�o Command
   *
   * @param HttpServletRequest request Objeto que guarda a requisi��o
   * @param HttpServletResponse response Objeto que guarda a resposta das requisi��es
   * 
   */
    public interface Command{
	public Object execute(HttpServletRequest request, HttpServletResponse response);
    }