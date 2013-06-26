package beans;

import beans.util.Auxiliares;
import entidades.Recursos;
import controladores.RecursosFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "recursosController")
@ViewScoped
public class RecursosController extends AbstractController<Recursos> implements Serializable {

    @EJB
    private RecursosFacade ejbFacade;

    public RecursosController() {
        super(Recursos.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
    
    //FUNCION MEJORADA CREAR RECURSOS
    public void CrearNew(ActionEvent e) {
        List<Recursos> R = ejbFacade.existeRecursoID(super.getSelected().getIdrecursos());
        if(R.isEmpty()){
            super.saveNew(e);
        }else{
            new Auxiliares().setMsj(3,"ID DEL RECURSO YA EXISTE");
        }
    }
}
