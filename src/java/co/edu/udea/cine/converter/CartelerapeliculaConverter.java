package co.edu.udea.cine.converter;

import co.edu.udea.cine.pojo.Cartelerapelicula;
import co.edu.udea.cine.bean.CartelerapeliculaFacade;
import co.edu.udea.cine.controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "cartelerapeliculaConverter")
public class CartelerapeliculaConverter implements Converter {

    @Inject
    private CartelerapeliculaFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    co.edu.udea.cine.pojo.CartelerapeliculaPK getKey(String value) {
        co.edu.udea.cine.pojo.CartelerapeliculaPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new co.edu.udea.cine.pojo.CartelerapeliculaPK();
        key.setIdCARTELERAPELICULA(Integer.parseInt(values[0]));
        key.setPELICULAidPELICULA(Integer.parseInt(values[1]));
        key.setCARTELERAidCARTELERA(Integer.parseInt(values[2]));
        return key;
    }

    String getStringKey(co.edu.udea.cine.pojo.CartelerapeliculaPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIdCARTELERAPELICULA());
        sb.append(SEPARATOR);
        sb.append(value.getPELICULAidPELICULA());
        sb.append(SEPARATOR);
        sb.append(value.getCARTELERAidCARTELERA());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof Cartelerapelicula) {
            Cartelerapelicula o = (Cartelerapelicula) object;
            return getStringKey(o.getCartelerapeliculaPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Cartelerapelicula.class.getName()});
            return null;
        }
    }

}
