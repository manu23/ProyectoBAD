/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.util;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
    
    
    
}
