package convertidores;

import entidades.Prerrequisito;
import controladores.PrerrequisitoFacade;
import beans.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@ManagedBean
public class PrerrequisitoConverter implements Converter {

    @EJB
    private PrerrequisitoFacade ejbFacade;
    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    entidades.PrerrequisitoPK getKey(String value) {
        entidades.PrerrequisitoPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new entidades.PrerrequisitoPK();
        key.setIdpropuesta(values[0]);
        key.setCodigomateria(values[1]);
        return key;
    }

    String getStringKey(entidades.PrerrequisitoPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIdpropuesta());
        sb.append(SEPARATOR);
        sb.append(value.getCodigomateria());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof Prerrequisito) {
            Prerrequisito o = (Prerrequisito) object;
            return getStringKey(o.getPrerrequisitoPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Prerrequisito.class.getName()});
            return null;
        }
    }
}
