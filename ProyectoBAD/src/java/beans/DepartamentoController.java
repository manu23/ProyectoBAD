package beans;

import beans.util.Auxiliares;
import entidades.Departamento;
import controladores.DepartamentoFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "departamentoController")
@ViewScoped
public class DepartamentoController extends AbstractController<Departamento> implements Serializable {

    @EJB
    private DepartamentoFacade ejbFacade;

    public DepartamentoController() {
        super(Departamento.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
    
    //FUNCION MEJORADA CREAR DEPTO
    public void CrearNew(ActionEvent e) {
        List<Departamento> R1 = ejbFacade.existeDeptoID(super.getSelected().getIddepartamento());
        List<Departamento> R2 = ejbFacade.existeDeptoNOM(super.getSelected().getNombredepartamento());
        if(R1.isEmpty()){
            if(R2.isEmpty()){
                super.saveNew(e);
            }else{
                new Auxiliares().setMsj(3,"EL NOMBRE DEL DEPARTAMENTO YA EXISTE");
            }
        }else{
            new Auxiliares().setMsj(3,"EL ID DEL DEPARTAMENTO YA EXISTE");
        }
    }
}
