package co.edu.udea.cine.controller;

import co.edu.udea.cine.controller.util.MobilePageController;
import co.edu.udea.cine.pojo.Localidad;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "localidadController")
@ViewScoped
public class LocalidadController extends AbstractController<Localidad> {

    @Inject
    private MobilePageController mobilePageController;

    public LocalidadController() {
        // Inform the Abstract parent controller of the concrete Localidad Entity
        super(Localidad.class);
    }

    /**
     * Sets the "items" attribute with a collection of Silla entities that are
     * retrieved from Localidad?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Silla page
     */
    public String navigateSillaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Silla_items", this.getSelected().getSillaList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/GUI/silla/index";
    }

    /**
     * Sets the "items" attribute with a collection of Precio entities that are
     * retrieved from Localidad?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Precio page
     */
    public String navigatePrecioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Precio_items", this.getSelected().getPrecioList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/GUI/precio/index";
    }

}
