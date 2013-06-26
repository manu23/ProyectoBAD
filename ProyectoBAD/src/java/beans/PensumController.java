package beans;

import beans.util.Auxiliares;
import entidades.Pensum;
import controladores.PensumFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

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
    
    //FUNCION MEJORADA CREAR PENSUM
    public void CrearNew(ActionEvent e) {
        List<Pensum> R = ejbFacade.existePensumID(super.getSelected().getIdpensum());
        if(R.isEmpty()){
            super.saveNew(e);
        }else{
            new Auxiliares().setMsj(3,"PENSUM ID YA EXISTE");
        }
    }
}
