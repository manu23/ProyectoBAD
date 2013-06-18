package beans;

import entidades.Propuesta;
import controladores.PropuestaFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "propuestaController")
@ViewScoped
public class PropuestaController extends AbstractController<Propuesta> implements Serializable {

    private int correlativo = 0;
    @EJB
    private PropuestaFacade ejbFacade;

    public PropuestaController() {
        super(Propuesta.class);
    }

    
    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
    
    public void guardar(ActionEvent e){
        super.getSelected().setIdpropuesta("idAuto" + correlativo);
        correlativo++;
        super.saveNew(e);
    }
}
