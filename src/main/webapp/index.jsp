<%-- 
    Document   : index
    Created on : 02-dic-2016, 0:54:29
    Author     : Adrian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/WEB-INF/tlds/etiquetas.tld" prefix="ea" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/estilo.css" rel="stylesheet" type="text/css"/>
        <title>Etiquetas</title>
    </head>
    <body>
        <h1>Etiquetas Personalizadas</h1>
        <table>
            <tr>
                <th>Significado</th>
                <th>Etiqueta</th>
                <th>Atributos</th>
                <th>Requerido</th>
                <th>Ejemplo</th>
                <th>Salida</th>
            </tr>
            <tr>
                <td>Simula la tirada de un dado de tantas caras como se especifique en el atributo</td>
                <td class="etiqueta">dado</td>
                <td><em>caras</em></td>
                <td>
                    S&iacute;
                </td>
                <td><pre>&lt;ea:dado caras="20">&lt;/ea:dado></pre></td>

                <td>
                    <ea:dado caras="20"></ea:dado>
                    </td>
                </tr>
                <tr>
                    <td>Le da la vuelta a una cadena de caracteres</td>
                    <td class="etiqueta">darvuelta</td>
                    <td><em>cadena</em></td>
                    <td>
                        S&iacute;
                    </td>
                    <td><pre>&lt;ea:darvuelta cadena="Vamos a darle la vuelta a esta oracion">&lt;/ea:darvuelta></pre></td>

                    <td>
                    <ea:darvuelta cadena="Vamos a darle la vuelta a esta oracion"></ea:darvuelta>
                    </td>
                </tr>
                <tr>
                    <td>Codifica una cadena de caracteres usando el codigo cesar con la clave especificada</td>
                    <td class="etiqueta">codificar</td>
                    <td><em>cadena</em><br/>
                        <em>numero</em></td>
                    <td>
                        S&iacute;<br/>
                        S&iacute;
                    </td>
                    <td><pre>&lt;ea:codificar cadena="Prueba de codificacion" numero="3">&lt;/ea:codificar></pre></td>

                    <td>
                    <ea:codificar cadena="Prueba de codificacion" numero="3"></ea:codificar>
                    </td>
                </tr>
                <tr>
                    <td>Realiza las operaciones que se especifiquen sobre dos numeros</td>
                    <td class="etiqueta">Operaciones</td>
                    <td><em>primerNumero</em><br/>
                        <em>segundoNumero</em><br/>
                        <em>operacion</em></td>
                    <td>
                        S&iacute;<br/>
                        S&iacute;<br/>
                        No;
                    </td>
                    <td><pre>&lt;c:set var="operaciones" value="suma,resta,multiplicacion,division" />
&lt;c:forTokens var="token" items="\${operaciones}" delims=",">
&lt;ea:operaciones primerNumero="20" segundoNumero="5" operacion="${token}">&lt;/ea:operaciones>
&lt;/c:forTokens></pre></td>

                <td>
                    <c:set var="operaciones" value="suma,resta,multiplicacion,division" />
                    <c:forTokens var="token" items="${operaciones}" delims=",">
                        <ea:operaciones primerNumero="20" segundoNumero="5" operacion="${token}"></ea:operaciones>
                    </c:forTokens>
                </td>
            </tr>
        </table>
    </body>
</html>
