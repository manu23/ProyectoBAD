package beans;

import beans.util.Auxiliares;
import entidades.Docente;
import controladores.DocenteFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "docenteController")
@ViewScoped
public class DocenteController extends AbstractController<Docente> implements Serializable {

    private int contadorID=0;
    @EJB
    private DocenteFacade ejbFacade;

    public DocenteController() {
        super(Docente.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
    
    //Funcion mejorada para crear un docente
    public void CrearNew(ActionEvent e) {
        String id = "DOC";
        super.getSelected().setCargo("Docente");
        boolean salir = false;
        int cont = 0;
        List<Docente> R = null;
        while(!salir){
            super.getSelected().setIddocente(id + cont);
            R = ejbFacade.existeDocente(super.getSelected().getIddocente());
            if(R.isEmpty()){
                salir = true;
            }else{
                salir = false;
                R.clear();
                cont++;
            }
        }//FIN WHILE
        super.saveNew(e);
    }
    
}
