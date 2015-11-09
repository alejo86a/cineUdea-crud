package co.edu.udea.cine.controller;

import co.edu.udea.cine.controller.util.MobilePageController;
import co.edu.udea.cine.pojo.Clasificacion;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "clasificacionController")
@ViewScoped
public class ClasificacionController extends AbstractController<Clasificacion> {

    @Inject
    private MobilePageController mobilePageController;

    public ClasificacionController() {
        // Inform the Abstract parent controller of the concrete Clasificacion Entity
        super(Clasificacion.class);
    }

    /**
     * Sets the "items" attribute with a collection of Pelicula entities that
     * are retrieved from Clasificacion?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Pelicula page
     */
    public String navigatePeliculaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Pelicula_items", this.getSelected().getPeliculaList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/GUI/pelicula/index";
    }

}
