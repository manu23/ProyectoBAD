package beans;

import beans.util.Auxiliares;
import entidades.Prerrequisito;
import controladores.PrerrequisitoFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

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
    
     //FUNCION MEJORADA CREAR LOCAL
    public void CrearNew(ActionEvent e) {
        List<Prerrequisito> R = ejbFacade.existePrerrequisito(super.getSelected().getPrerrequisitoPK().getCodigomateria(), super.getSelected().getNombreprerrequisito());
        if(R.isEmpty()){
            super.saveNew(e);
            new Auxiliares().setMsj(3,"MATERIA :"+super.getSelected().getPrerrequisitoPK().getCodigomateria()+"\nPRE: "+super.getSelected().getNombreprerrequisito());
        }else{
            new Auxiliares().setMsj(3,"PRERREQUISITO YA EXISTE");
        }
    }
}
