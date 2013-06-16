package beans;

import entidades.Prerrequisito;
import controladores.PrerrequisitoFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "prerrequisitoController")
@ViewScoped
public class PrerrequisitoController extends AbstractController<Prerrequisito> implements Serializable {

    @EJB
    private PrerrequisitoFacade ejbFacade;

    public PrerrequisitoController() {
        super(Prerrequisito.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getPrerrequisitoPK().setCodigomateria(this.getSelected().getMateria().getMateriaPK().getCodigomateria());
        this.getSelected().getPrerrequisitoPK().setIdpropuesta(this.getSelected().getMateria().getMateriaPK().getIdpropuesta());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setPrerrequisitoPK(new entidades.PrerrequisitoPK());
    }
}
