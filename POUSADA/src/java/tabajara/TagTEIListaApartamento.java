package tabajara;

import javax.servlet.jsp.tagext.*;

public class TagTEIListaApartamento extends TagExtraInfo {
    
    public VariableInfo[] getVariableInfo(TagData data) {
        return new VariableInfo[] {
            new VariableInfo("numero", "java.lang.Integer", true,VariableInfo.NESTED)
        };
    }
}