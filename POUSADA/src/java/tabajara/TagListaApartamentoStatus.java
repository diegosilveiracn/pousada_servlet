package tabajara;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;
import java.io.*;

import java.util.Vector;
import java.util.Calendar;

import javax.servlet.jsp.PageContext;

public class TagListaApartamentoStatus extends BodyTagSupport{
    
    private StringBuffer sb  = new StringBuffer();
    private int index        = 0;
    private RepositorioApartamento repositorio;
    private Vector                 apartamentos;

    public int doStartTag(){ 
        try{
            ServletRequest servletRequest = super.pageContext.getRequest();
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
                        
            repositorio  = new PousadaSql();
            
            apartamentos = repositorio.listarApartamentos((httpServletRequest.getParameter("lstStatus").equals("O"))?true:false);
            
        }catch(Exception e){
            System.out.println("Erro do StartTag: "+e.getMessage());
        }
        if (apartamentos == null){
            return SKIP_BODY;
        }else{
            try{
                this.setVariaveis();
            }catch(Exception e){
                
            }
        } //EVAL_BODY_BUFFERED;
        return EVAL_BODY_TAG;
    }
    
    private boolean setVariaveis() throws JspTagException {
        
        if ( index < apartamentos.size() ) {
            
            super.pageContext.setAttribute("numero",Integer.valueOf(((Apartamento) apartamentos.elementAt(index)).getNumero()));
            super.pageContext.setAttribute("tipo",TipoApartamento.getDescricao(((Apartamento) apartamentos.elementAt(index)).getTipo()));
            super.pageContext.setAttribute("valor",Double.valueOf(((Apartamento) apartamentos.elementAt(index)).getValorDiaria()));
            super.pageContext.setAttribute("modelo",ModeloApartamento.getDescricao(((Apartamento) apartamentos.elementAt(index))));
            index++;
            return true;
        } else {
            return false;
        }
        
    }
    
    public int doAfterBody() throws JspException {
        try {
            sb.append(super.getBodyContent().getString());
            super.getBodyContent().clear();
        } catch (IOException e) {
            throw new JspTagException("Erro fatal: IOException!");
        }
        
        if(setVariaveis()) {
            return EVAL_BODY_TAG;
        }
        
        try {
            super.getBodyContent().getEnclosingWriter().write(sb.toString());
        } catch (IOException e) {
            throw new JspTagException("Erro fatal: IOException!");
        }
        return SKIP_BODY;
        
    }
   
    public int doEndTag() throws JspException {
         this.index = 0;
         this.sb    = new StringBuffer();
         return EVAL_PAGE;
    }

}