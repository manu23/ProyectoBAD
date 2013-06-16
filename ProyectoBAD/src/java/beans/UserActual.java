/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import beans.util.Auxiliares;
import controladores.UsuarioFacade;
import entidades.Usuario;
import java.util.List;
import javax.ejb.EJB;
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
    @EJB
    private UsuarioFacade ejbFacade; // CONTROLADOR
    
    //Variables del Formulario login
    
    String Username;
    String Password;
    boolean logeado = false;
    
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
    
    
    
    //FUNCIONES PROPIAS DE LA CLASE
    public void login(){
        List<Usuario> userX = ejbFacade.existeUser(Username, Password);
        if(!userX.isEmpty()){
            user = userX.get(0);
            logeado = true;
            new Auxiliares().irA("faces/index.xhtml");
        }else{
            Password = "";
            logeado = false;
            new Auxiliares().setMsj(3, "Usuario o Password NO VALIDO");
        }
    }
    
    public void logout(){
        Username = "";
        Password = "";
        user = null;
        logeado = false;
    }
    
    
}
