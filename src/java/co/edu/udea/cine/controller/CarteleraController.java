package co.edu.udea.cine.controller;

import co.edu.udea.cine.controller.util.MobilePageController;
import co.edu.udea.cine.pojo.Cartelera;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "carteleraController")
@ViewScoped
public class CarteleraController extends AbstractController<Cartelera> {

    @Inject
    private MobilePageController mobilePageController;

    public CarteleraController() {
        // Inform the Abstract parent controller of the concrete Cartelera Entity
        super(Cartelera.class);
    }

    /**
     * Sets the "items" attribute with a collection of Cartelerapelicula
     * entities that are retrieved from Cartelera?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for Cartelerapelicula page
     */
    public String navigateCartelerapeliculaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Cartelerapelicula_items", this.getSelected().getCartelerapeliculaList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/GUI/cartelerapelicula/index";
    }

    /**
     * Sets the "items" attribute with a collection of Cinema entities that are
     * retrieved from Cartelera?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Cinema page
     */
    public String navigateCinemaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Cinema_items", this.getSelected().getCinemaList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/GUI/cinema/index";
    }

}
