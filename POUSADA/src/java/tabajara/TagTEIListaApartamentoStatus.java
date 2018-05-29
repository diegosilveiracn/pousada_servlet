package tabajara;

import javax.servlet.jsp.tagext.*;

public class TagTEIListaApartamentoStatus extends TagExtraInfo {
    
    public VariableInfo[] getVariableInfo(TagData data) {
        return new VariableInfo[] {
            new VariableInfo("numero", "java.lang.Integer", true,VariableInfo.NESTED),
            new VariableInfo("tipo", "java.lang.String", true,VariableInfo.NESTED),
            new VariableInfo("valor", "java.lang.Double", true,VariableInfo.NESTED),
            new VariableInfo("modelo", "java.lang.String", true,VariableInfo.NESTED)        
        };
    }
}