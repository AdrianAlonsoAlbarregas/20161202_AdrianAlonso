package es.albarregas.etiquetas;

/**
 *
 * @author Adrian
 */
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class Codificar extends TagSupport {
    private String cadena;
    private int numero;

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    @Override
    public int doStartTag() throws JspException{
        String cadenaCodificada="";
        Writer out = pageContext.getOut();
        try {
            out.write("<p>La frase \""+cadena+"\" codificada con la clave "+ numero+ " sera: ");
        } catch (IOException ex) {
            Logger.getLogger(Codificar.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i=0;i<cadena.length();i++){
            if (Character.isWhitespace(cadena.charAt(i))){
                cadenaCodificada= cadenaCodificada+" ";
            } else{
                cadenaCodificada = cadenaCodificada + Character.toString((char) (((int) cadena.charAt(i))+ numero));
            }
        }
        cadena=cadenaCodificada;
        return Tag.SKIP_BODY;
    }
    @Override
    public int doEndTag() throws JspException{
        Writer out= pageContext.getOut();
        try {
            out.write("<b>"+cadena+ "</b></p>");
        } catch (IOException ex) {
            Logger.getLogger(Codificar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Tag.EVAL_PAGE;
    }
}
