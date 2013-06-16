package convertidores;

import entidades.Cargo;
import controladores.CargoFacade;
import beans.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@ManagedBean
public class CargoConverter implements Converter {

    @EJB
    private CargoFacade ejbFacade;
    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    entidades.CargoPK getKey(String value) {
        entidades.CargoPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new entidades.CargoPK();
        key.setIddocente(values[0]);
        key.setIddepartamento(values[1]);
        key.setIdcargo(values[2]);
        return key;
    }

    String getStringKey(entidades.CargoPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIddocente());
        sb.append(SEPARATOR);
        sb.append(value.getIddepartamento());
        sb.append(SEPARATOR);
        sb.append(value.getIdcargo());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof Cargo) {
            Cargo o = (Cargo) object;
            return getStringKey(o.getCargoPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Cargo.class.getName()});
            return null;
        }
    }
}
