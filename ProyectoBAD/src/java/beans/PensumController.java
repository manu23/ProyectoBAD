package beans;

import entidades.Pensum;
import controladores.PensumFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "pensumController")
@ViewScoped
public class PensumController extends AbstractController<Pensum> implements Serializable {

    @EJB
    private PensumFacade ejbFacade;

    public PensumController() {
        super(Pensum.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
