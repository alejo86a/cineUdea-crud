package co.edu.udea.cine.controller;

import co.edu.udea.cine.controller.util.MobilePageController;
import co.edu.udea.cine.pojo.Formato;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "formatoController")
@ViewScoped
public class FormatoController extends AbstractController<Formato> {

    @Inject
    private MobilePageController mobilePageController;

    public FormatoController() {
        // Inform the Abstract parent controller of the concrete Formato Entity
        super(Formato.class);
    }

    /**
     * Sets the "items" attribute with a collection of Pelicula entities that
     * are retrieved from Formato?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Pelicula page
     */
    public String navigatePeliculaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Pelicula_items", this.getSelected().getPeliculaList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/GUI/pelicula/index";
    }

    /**
     * Sets the "items" attribute with a collection of Precio entities that are
     * retrieved from Formato?cap_first and returns the navigation outcome.
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
