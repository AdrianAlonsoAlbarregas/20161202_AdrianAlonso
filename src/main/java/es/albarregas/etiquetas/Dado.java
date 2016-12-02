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

public class Dado extends TagSupport {

    public int caras;

    public void setCaras(int caras) {
        this.caras = caras;
    }

    @Override
    public int doStartTag() throws JspException {
        Writer out = pageContext.getOut();
        Random tirada = new Random();
        try {
            out.write("<p>La tirada de un dado de " + caras + " caras es: <b>" + (1 + tirada.nextInt(caras))+"</b>");
        } catch (IOException ex) {
            Logger.getLogger(Dado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Tag.SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        Writer out = pageContext.getOut();
        try {
            out.write("</p>");
        } catch (IOException ex) {
            Logger.getLogger(Dado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Tag.EVAL_PAGE;
    }
}
