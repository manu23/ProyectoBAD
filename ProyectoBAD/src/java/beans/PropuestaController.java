package beans;

import entidades.Propuesta;
import controladores.PropuestaFacade;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
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
    
        
    //Funcion mejorada para crear un propuesta
    public void CrearNew(ActionEvent e) {
        String id = "PRO";
        boolean salir = false;
        int cont = 0;
        List<Propuesta> R = null;
        while(!salir){
            super.getSelected().setIdpropuesta(id + cont);
            R = ejbFacade.existePropuesta(super.getSelected().getIdpropuesta());
            if(R.isEmpty()){
                salir = true;
            }else{
                salir = false;
                R.clear();
                cont++;
            }
        }//FIN WHILE
        super.getSelected().setAprobadojefe(BigInteger.ZERO);
        super.getSelected().setAprobadodirector(BigInteger.ZERO);
        super.getSelected().setAprobadojunta(BigInteger.ZERO);
        super.saveNew(e);
    }
}
