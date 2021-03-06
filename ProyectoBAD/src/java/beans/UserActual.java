/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.util.Auxiliares;
import beans.util.JsfUtil;
import controladores.UsuarioFacade;
import entidades.Permisos;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Shella
 */
@ManagedBean(name = "userActual")
@SessionScoped
public class UserActual {
    //Variables
    private Usuario user;     //Entidad USUARIO (DE SESION)
    private List<Permisos> userPermisos; //Guarda los permisos del usuario actual
    @EJB
    private UsuarioFacade ejbFacade; // CONTROLADOR
    
    //Variables del Formulario login
    
    String Username;
    String Password;
    boolean logeado = false;
    boolean esAdmin=false;
    boolean userActivo=true;
    
    //variables de cambio de password
    String actualPass;
    String nuevoPass;
    String confirmPass;
    
    
    //Constructor del BEAN
    public UserActual() {
    }
    
    //GETTER y SETTER
    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public List<Permisos> getUserPermisos() {
        return userPermisos;
    }

    public void setUserPermisos(List<Permisos> userPermisos) {
        this.userPermisos = userPermisos;
    }

    public UsuarioFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFade(UsuarioFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public boolean isLogeado() {
        return logeado;
    }

    public void setLogeado(boolean logeado) {
        this.logeado = logeado;
    }

    public boolean isEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    public boolean isUserActivo() {
        return userActivo;
    }

    public void setUserActivo(boolean userActivo) {
        this.userActivo = userActivo;
    }
    
    

    public String getActualPass() {
        return actualPass;
    }

    public void setActualPass(String actualPass) {
        this.actualPass = actualPass;
    }

    public String getNuevoPass() {
        return nuevoPass;
    }

    public void setNuevoPass(String nuevoPass) {
        this.nuevoPass = nuevoPass;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }

        
    //FUNCIONES PROPIAS DE LA CLASE
    
    //FUNCION INICIAR SESION
    public void login(){
        try {
         Password = new Auxiliares().getMD5(Password);
       }catch (Exception ex){new Auxiliares().setMsj(3, "ERROR AL ENCRIPTAR");}
        List<Usuario> userX = ejbFacade.existeUser(Username, Password);
        if(!userX.isEmpty()){
            user = userX.get(0);
            logeado = true;
            actualPass = "";
            nuevoPass = "";
            confirmPass = "";
            //Verifica si es un usuario del tipo Administrador
            if(user.getTipousuario().equals("Admin")){
                esAdmin = true;
            }else{
                esAdmin = false;
            }
            //Verifica si es un usuario Activo
            if(user.getEstado().intValue() == 1){
                userActivo = true;
            }else{
                userActivo = false;
            }
            //Guardo los permisos del usuario
            userPermisos = new ArrayList<Permisos>(user.getPermisosCollection()); // Crea un ArrayList en base a la colección de permisos
            new Auxiliares().irA("faces/index.xhtml");
        }else{
            Password = "";
            logeado = false;
            new Auxiliares().setMsj(3, "Usuario o Password NO VALIDO ");
            
        }
    }
    
    //FUNCION DE CERRAR SESION
    public void logout(){
        Username = "";
        Password = "";
        user = null;
        userPermisos=null;
        logeado = false;
        esAdmin = false;
        userActivo = true;
        actualPass = "";
        nuevoPass = "";
        confirmPass = "";
        new Auxiliares().irA("faces/login.xhtml");
    }
    
    //FUNCION que retorna los permisos de LEER del usuario actual de una tabla especifica
    // NOTA: nombre de la tabla debe ir en MAYUSCULA de lo contrario siempre devolvera false
    public boolean puedeLeer(String tabla){
        boolean permiso = true;
        for(int i=0; i< userPermisos.size();i++){
            if(userPermisos.get(i).getTabla().equals(tabla)){
                if(userPermisos.get(i).getLeer().intValue() == 1)
                    permiso = true;
                else
                    permiso =false;
            }
        }
        return permiso;
    }
    
    //FUNCION que retorna los permisos de ACTUALIZAR del usuario actual de una tabla especifica
    // NOTA: nombre de la tabla debe ir en MAYUSCULA de lo contrario siempore devolvera false
    public boolean puedeActualizar(String tabla){
        boolean permiso = true;
        for(int i=0; i< userPermisos.size();i++){
            if(userPermisos.get(i).getTabla().equals(tabla)){
                if(userPermisos.get(i).getActualizar().intValue() == 1)
                    permiso = true;
                else
                    permiso =false;
            }
        }
        return permiso;
    }
    
    //FUNCION que retorna los permisos de CREAR del usuario actual de una tabla especifica
    // NOTA: nombre de la tabla debe ir en MAYUSCULA de lo contrario siempore devolvera false
    public boolean puedeCrear(String tabla){
        boolean permiso = true;
        for(int i=0; i< userPermisos.size();i++){
            if(userPermisos.get(i).getTabla().equals(tabla)){
                if(userPermisos.get(i).getCrear().intValue() == 1)
                    permiso = true;
                else
                    permiso =false;
            }
        }
        return permiso;
    }
    
    //FUNCION que retorna los permisos de ELIMINAR del usuario actual de una tabla especifica
    // NOTA: nombre de la tabla debe ir en MAYUSCULA de lo contrario siempore devolvera false
    public boolean puedeEliminar(String tabla){
        boolean permiso = true;
        for(int i=0; i< userPermisos.size();i++){
            if(userPermisos.get(i).getTabla().equals(tabla)){
                if(userPermisos.get(i).getEliminar().intValue() == 1)
                    permiso = true;
                else
                    permiso =false;
            }
        }
        return permiso;
    }
    
    //FUNCION PARA CAMBIAR CONTRASEÑA
    public void cambiarPassword(){
        try {
         actualPass = new Auxiliares().getMD5(actualPass);
       }catch (Exception ex){}
        try{
            if(user.getPassword().equals(actualPass)){
                if(confirmPass.equals(nuevoPass)){
                    nuevoPass = new Auxiliares().getMD5(nuevoPass);
                    user.setPassword(nuevoPass);
                    ejbFacade.edit(user);
                    JsfUtil.addSuccessMessage("Password Cambiado Correctamente");
                    actualPass = "";
                    nuevoPass = "";
                    confirmPass = "";
            }else{
                actualPass = "";
                nuevoPass = "";
                confirmPass = "";
                new Auxiliares().setMsj(3,"Confirmacion de Password Incorrecta");
            }
            }else{
                actualPass = "";
                nuevoPass = "";
                confirmPass = "";
                new Auxiliares().setMsj(3,"Password Actual Incorrecto");
            }
        }catch (EJBException ex) {
                String msg = "";
                Throwable cause = JsfUtil.getRootCause(ex.getCause());
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/MyBundle").getString("PersistenceErrorOccured"));
                }
                actualPass = "";
                nuevoPass = "";
                confirmPass = "";
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/MyBundle").getString("PersistenceErrorOccured"));
                actualPass = "";
                nuevoPass = "";
                confirmPass = "";
            }
        
    }
    
    
}
