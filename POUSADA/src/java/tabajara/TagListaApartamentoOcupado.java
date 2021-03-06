/*
 * TagListaApartamentoOcupado.java
 *
 * Created on 27 de Fevereiro de 2006, 08:14
 *
 */
package tabajara;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;
import java.io.*;

import java.util.Vector;

public class TagListaApartamentoOcupado implements BodyTag{
    
    private PageContext pc = null;
    private BodyContent body = null;
    private StringBuffer sb = new StringBuffer();
    private int index = 0;
    private RepositorioApartamento repositorio;
    private Vector apartamentos;
    
    public void setPageContext(PageContext p) {
        pc = p;
    }
    
    public int doStartTag(){
        try{
            repositorio  = new PousadaSql();
            apartamentos = repositorio.listarApartamentos(true);
        }catch(Exception e){
           System.out.println("Erro do StartTag: " + e.getMessage());
        }
        if (apartamentos == null){
            return SKIP_BODY;
        }
        else{
            try{
                this.setVariaveis();
            }catch(Exception e){
                System.out.println("Erro do StartTag: " + e.getMessage());
            }
        }

        return EVAL_BODY_BUFFERED;
    }
    
    private boolean setVariaveis() throws JspTagException {
        if ( index < apartamentos.size() ) {
            Integer num = Integer.valueOf(((Apartamento) apartamentos.elementAt(index)).getNumero());
            Integer tipoCli = Integer.valueOf(((Apartamento) apartamentos.elementAt(index)).getTipoCliente());
            Integer diasOcup = Integer.valueOf(((Apartamento) apartamentos.elementAt(index)).getNumDiasOcupacao());

            pc.setAttribute("numero", num);
            pc.setAttribute("tipoCliente", tipoCli);
            pc.setAttribute("numDiasOcupacao", diasOcup);
            
            index++;
            return true;
        } else {
            return false;
        }
        
    }
    
    public int doAfterBody() throws JspException {
        try {
            sb.append(body.getString());
            body.clear();
        } catch (IOException e) {
            throw new JspTagException("Erro fatal: IOException!");
        }
        if(setVariaveis()) {
            return EVAL_BODY_AGAIN;
        }
        
        try {
            body.getEnclosingWriter().write(sb.toString());
        } catch (IOException e) {
            throw new JspTagException("Erro fatal: IOException!");
        }
        
        return SKIP_BODY;
        
    }
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
    
    public void release() {
        pc = null;
        body = null;
        sb = null;
    }
    
    public void setBodyContent(BodyContent b) {
        body = b;
    }
    
    public void doInitBody() throws JspException 
    {
    }
    
    public void setParent(Tag t) {}
    
    public Tag getParent() {
        return null;
    }
}