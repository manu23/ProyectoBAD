package beans;

import entidades.Departamento;
import controladores.DepartamentoFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "departamentoController")
@ViewScoped
public class DepartamentoController extends AbstractController<Departamento> implements Serializable {

    @EJB
    private DepartamentoFacade ejbFacade;

    public DepartamentoController() {
        super(Departamento.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
