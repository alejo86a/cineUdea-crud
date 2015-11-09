package co.edu.udea.cine.controller;

import co.edu.udea.cine.controller.util.MobilePageController;
import co.edu.udea.cine.pojo.Lenguaje;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "lenguajeController")
@ViewScoped
public class LenguajeController extends AbstractController<Lenguaje> {

    @Inject
    private MobilePageController mobilePageController;

    public LenguajeController() {
        // Inform the Abstract parent controller of the concrete Lenguaje Entity
        super(Lenguaje.class);
    }

    /**
     * Sets the "items" attribute with a collection of Pelicula entities that
     * are retrieved from Lenguaje?cap_first and returns the navigation outcome.
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
