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
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.TagSupport;

public class Operaciones extends TagSupport implements DynamicAttributes {

    private double primerNumero;
    private double segundoNumero;
    private String operacion;

    public void setPrimerNumero(double primerNumero) {
        this.primerNumero = primerNumero;
    }

    public void setSegundoNumero(double segundoNumero) {
        this.segundoNumero = segundoNumero;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    @Override
    public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
        switch (String.valueOf(value).toLowerCase()) {
            case "suma":
                this.operacion = "suma";
                break;
            case "resta":
                this.operacion = "resta";
                break;
            case "multiplicacion":
                this.operacion = "multiplicacion";
                break;
            case "division":
                this.operacion = "division";
                break;
            default:
                this.operacion = "suma";

        }
    }

    @Override
    public int doStartTag() throws JspException {
        Writer out = pageContext.getOut();
        double resultado = 0;
        if ("suma".equals(operacion)) {
            resultado = primerNumero + segundoNumero;
        }
        if ("resta".equals(operacion)) {
            resultado = primerNumero - segundoNumero;
        }
        if ("multiplicacion".equals(operacion)) {
            resultado = primerNumero * segundoNumero;
        }
        if ("division".equals(operacion)) {
            if (segundoNumero == 0) {
                resultado = 0;
            } else {
                resultado = primerNumero / segundoNumero;
            }
        }
        try {
            out.write("<p>el resultado de la " + operacion + " de " + primerNumero + " y " + segundoNumero + " es: <b>" + resultado+"</b>");
        } catch (IOException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Tag.SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        Writer out = pageContext.getOut();
        try {
            out.write("</p>");
        } catch (IOException ex) {
            Logger.getLogger(Codificar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Tag.EVAL_PAGE;
    }
}
