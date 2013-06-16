package beans;

import entidades.Propuesta;
import controladores.PropuestaFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "propuestaController")
@ViewScoped
public class PropuestaController extends AbstractController<Propuesta> implements Serializable {

    @EJB
    private PropuestaFacade ejbFacade;

    public PropuestaController() {
        super(Propuesta.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
