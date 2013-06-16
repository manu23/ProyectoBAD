package beans;

import entidades.Recursos;
import controladores.RecursosFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "recursosController")
@ViewScoped
public class RecursosController extends AbstractController<Recursos> implements Serializable {

    @EJB
    private RecursosFacade ejbFacade;

    public RecursosController() {
        super(Recursos.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
