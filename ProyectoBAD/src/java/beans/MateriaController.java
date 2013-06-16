package beans;

import entidades.Materia;
import controladores.MateriaFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "materiaController")
@ViewScoped
public class MateriaController extends AbstractController<Materia> implements Serializable {

    @EJB
    private MateriaFacade ejbFacade;

    public MateriaController() {
        super(Materia.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getMateriaPK().setIdpropuesta(this.getSelected().getPropuesta().getIdpropuesta());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setMateriaPK(new entidades.MateriaPK());
    }
}
