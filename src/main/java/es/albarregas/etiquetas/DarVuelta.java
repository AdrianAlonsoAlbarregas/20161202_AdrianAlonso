package es.albarregas.etiquetas;

/**
 *
 * @author Adrian
 */
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class DarVuelta extends TagSupport {
    public String cadena;

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
    
    @Override
    public int doStartTag() throws JspException{
        Writer out = pageContext.getOut();
        try {
            out.write("<p>La cadena \""+cadena+"\" al reves es: ");
        } catch (IOException ex) {
            Logger.getLogger(Codificar.class.getName()).log(Level.SEVERE, null, ex);
        }
        cadena = new StringBuilder(cadena).reverse().toString();
        return Tag.SKIP_BODY;
    }
    @Override
    public int doEndTag() throws JspException{
        Writer out= pageContext.getOut();
        try {
            out.write("<b>"+cadena+"</b></p>");
        } catch (IOException ex) {
            Logger.getLogger(Codificar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Tag.EVAL_PAGE;
    }
}
