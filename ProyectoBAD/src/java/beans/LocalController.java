package beans;

import beans.util.Auxiliares;
import entidades.Local;
import controladores.LocalFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "localController")
@ViewScoped
public class LocalController extends AbstractController<Local> implements Serializable {

    @EJB
    private LocalFacade ejbFacade;

    public LocalController() {
        super(Local.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
    
    //FUNCION MEJORADA CREAR LOCAL
    public void CrearNew(ActionEvent e) {
        List<Local> R = ejbFacade.existeLocal(super.getSelected().getIdlocal());
        if(R.isEmpty()){
            super.saveNew(e);
        }else{
            new Auxiliares().setMsj(3,"LOCAL YA EXISTE");
        }
    }
}
