package beans;

import entidades.Local;
import controladores.LocalFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "localController")
@ViewScoped
public class LocalController extends AbstractController<Local> implements Serializable {

    @EJB
    private LocalFacade ejbFacade;

    public LocalController() {
        super(Local.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
