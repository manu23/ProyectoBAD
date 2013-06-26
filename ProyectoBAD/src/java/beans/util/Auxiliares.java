/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.util;

import beans.UserActual;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ALEX
 */
@ManagedBean(name = "auxiliares")
@SessionScoped
public class Auxiliares {
    
       
    
    /**
     * *****************Inicio de FUNCION******************* 
     *      Nombre de la Funcion:
     *          - irA 
     *      Autor: 
     *          - Alex Palacios 
     *      Objetivo: 
     *          - Redirige la pagina actual de navegación, a una ingresada
     *            por el usuario, la cual debe ser parte de la estructura
     *            de navegación de la aplicación.
     *      Parámetros de entrada:
     *          - String urlRelat, representa la url relativa a la que se desea
     *            redirigir. ejemplo: 
     *               * faces/pages/bienvenida.xhtml.
     *      Parámetros de retorno: 
     *          - no hay
     */
    public void irA(String urlRelat) {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();
            /*Objetivo:
            *      almacena el contexto de la intancia actual de navegación
            */
            contex.getExternalContext().redirect("/ProyectoBAD/" + urlRelat);
        } catch (Exception e) {
            /*acción a realizar:
             *      no se realizará ninguna acción, ya que es un error que muy
             *      raras veces sucede.
             */
        }
    }
    
    
    /* *****************Inicio de FUNCION******************* 
     *      Nombre de la Funcion:
     *          - setMsj 
     *      Autor: 
     *          - Alex Palacios
     *      Objetivo: 
     *          - despliega un mensaje utilizando PrimeFaces, segun el 
     *            tipo de mensaje seleccionado por el usuario. 
     *      Parámetros de entrada:
     *          - int tipo, representa el tipo de mensaje a imprimir, los 
     *            valores validos son: 
     *               1 :mensaje de informacion.
     *               2 :mensaje de advertencia. 
     *               3 :mensaje de error. 
     *               4 :mensaje de error fatal. 
     *          - String msj, contiene el mensaje a mostrar 
     *      Parámetros de retorno: 
     *          - no hay
     */
    public void setMsj(int tipo, String msj) {
        FacesContext context = FacesContext.getCurrentInstance();
        /*Objetivo:
         *      almacena el contexto de la intancia actual de navegación
         */
        FacesMessage.Severity tipoMsj;
        /*Objetivo:
         *      sirve para seleccionar entre los diferentes tipos de mensajes
         *      ya definiddos
         */
        switch (tipo) {
            case 1:
                tipoMsj = FacesMessage.SEVERITY_INFO;
                break;
            case 2:
                tipoMsj = FacesMessage.SEVERITY_WARN;
                break;
            case 3:
                tipoMsj = FacesMessage.SEVERITY_ERROR;
                break;
            default:
                tipoMsj = FacesMessage.SEVERITY_FATAL;
                break;
        }
        context.addMessage(null, new FacesMessage(tipoMsj, msj, ""));
    }
    
    
    
    //Esta funcion es para usarla en los labels o datatable 
    //convierte un valor EJ:tipo BOOLEAN(BASE) o BigInteger(Programa)
    //Para que en lugar de su valor original aparesca un string con significado
    //Ejemplo en los booleanos en lugar que aparesca 0 y 1 aparecen NO y SI
    //Note que se pasa la tabla porque el valor tiene distintos significados en c/u
    
    public String converterToString(String tabla,BigInteger valor){
        String c="VALOR NO ENCONTRADO";
        
        if(tabla.equals("Permisos")){
            switch(valor.intValue()){
            case 0: return "NO";
            case 1: return "SI";
            }
        }else if(tabla.equals("Usuarios")){
            switch(valor.intValue()){
            case 0: return "INACTIVO";
            case 1: return "ACTIVO";
            }
        }            
        return c;        
    }
    
    
    //FUNCION DE ENCRIPTACION DE PASSWORD A MD5
    public String getMD5(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        final MessageDigest algorithm = MessageDigest.getInstance("MD5");
        algorithm.reset();
        algorithm.update(text.getBytes("utf-8"));
        final StringBuilder hexStringBuilder = new StringBuilder();
        final byte[] digest = algorithm.digest();
        for (byte digestItem : digest) {
            String hex = Integer.toHexString(0xFF & digestItem);
            if (hex.length() == 1) {
                hexStringBuilder.append('0');
            }
            hexStringBuilder.append(hex.toUpperCase());
	}
        return hexStringBuilder.toString();
    }
    
    
    /**
     * *****************Inicio de modulo******************* 
     *      Nombre del módulo:
     *          - getSesion
     *      Objetivo: 
     *          - Obtener la instancia de la sesion actual de la aplicacion
     *      Parámetros de entrada:
     *          - no hay
     *      Parámetros de retorno: 
     *          - (HttpSession) context.getExternalContext().getSession(false);
     *             retorna la sesion actual del sistema
     *      Módulos de la clase utilizados: 
     *          - no hay
     */
    public HttpSession getSesion(){
        FacesContext context = javax.faces.context.FacesContext.getCurrentInstance();
        /*Objetivo:
         *      almacena el contexto de la intancia actual de navegación
         */
        return (HttpSession) context.getExternalContext().getSession(false);
    }
    /**
     * *****************Inicio de modulo******************* 
     *      Nombre del módulo:
     *          - getUserActual
     *      Objetivo: 
     *          - Obtener la variable ddkClientes almacenada en el Bean 
     *            ddkClientesController el cual es un bean del tipo sessionScope
     *      Parámetros de entrada:
     *          - no hay
     *      Parámetros de retorno: 
     *          - ddkClientesController.getDdkClientes(), retorna la Entity 
     *            DdkClientes con los valores establecidos el Bean 
     *            ddkClientesController
     *      Módulos de la clase utilizados: 
     *          - no hay
     */
        
    public UserActual getUserActual() {
        
        UserActual usuario = (UserActual) getSesion().getAttribute("UserActual");
        /*Objetivo:
         *      obtiene el controlador ddkClientesController almacenado en la 
         *      sesión actual de la aplicación
         */
        return usuario;
    }
    
}
