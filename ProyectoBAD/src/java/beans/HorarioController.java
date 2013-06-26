package beans;

import beans.util.Auxiliares;
import entidades.Horario;
import controladores.HorarioFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "horarioController")
@ViewScoped
public class HorarioController extends AbstractController<Horario> implements Serializable {

    @EJB
    private HorarioFacade ejbFacade;

    public HorarioController() {
        super(Horario.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
    
    //FUNCION MEJORADA CREAR HORARIO
    public void CrearNew(ActionEvent e) {
        List<Horario> R = ejbFacade.existeHorarioID(super.getSelected().getIdhorario());
        if(R.isEmpty()){
            super.saveNew(e);
        }else{
            new Auxiliares().setMsj(3,"HORARIO ID YA EXISTE");
        }
    }
}
