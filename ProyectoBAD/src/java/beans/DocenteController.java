package beans;

import entidades.Docente;
import controladores.DocenteFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "docenteController")
@ViewScoped
public class DocenteController extends AbstractController<Docente> implements Serializable {

    @EJB
    private DocenteFacade ejbFacade;

    public DocenteController() {
        super(Docente.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
    
    public void guardar(ActionEvent e){
        super.getSelected().setIddocente("idAuto");
        super.saveNew(e);
    }
}
