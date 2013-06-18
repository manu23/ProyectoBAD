package beans;

import beans.util.Auxiliares;
import beans.util.JsfUtil;
import entidades.Usuario;
import controladores.UsuarioFacade;
import java.io.Serializable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "usuarioController")
@ViewScoped
public class UsuarioController extends AbstractController<Usuario> implements Serializable {

    @EJB
    private UsuarioFacade ejbFacade;
    
    public UsuarioController() {
        super(Usuario.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
    
    public void resetPassword(){
        String nuevoPassword ="";
        try {
         nuevoPassword = new Auxiliares().getMD5("fiaues");
       }catch (Exception ex){}
         
        super.getSelected().setPassword(nuevoPassword);
        ejbFacade.edit(super.getSelected());
        JsfUtil.addSuccessMessage("Password Cambiado Correctamente");
                   
    }
    
    
}
