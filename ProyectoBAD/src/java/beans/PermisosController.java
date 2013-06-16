package beans;

import entidades.Permisos;
import controladores.PermisosFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "permisosController")
@ViewScoped
public class PermisosController extends AbstractController<Permisos> implements Serializable {

    @EJB
    private PermisosFacade ejbFacade;

    public PermisosController() {
        super(Permisos.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
