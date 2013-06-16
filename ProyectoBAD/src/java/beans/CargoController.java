package beans;

import entidades.Cargo;
import controladores.CargoFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "cargoController")
@ViewScoped
public class CargoController extends AbstractController<Cargo> implements Serializable {

    @EJB
    private CargoFacade ejbFacade;

    public CargoController() {
        super(Cargo.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getCargoPK().setIddepartamento(this.getSelected().getDepartamento().getIddepartamento());
        this.getSelected().getCargoPK().setIddocente(this.getSelected().getDocente().getIddocente());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setCargoPK(new entidades.CargoPK());
    }
}
