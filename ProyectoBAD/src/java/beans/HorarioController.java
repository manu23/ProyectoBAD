package beans;

import entidades.Horario;
import controladores.HorarioFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "horarioController")
@ViewScoped
public class HorarioController extends AbstractController<Horario> implements Serializable {

    @EJB
    private HorarioFacade ejbFacade;

    public HorarioController() {
        super(Horario.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
