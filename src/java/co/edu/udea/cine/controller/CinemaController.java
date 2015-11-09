package co.edu.udea.cine.controller;

import co.edu.udea.cine.controller.util.MobilePageController;
import co.edu.udea.cine.pojo.Cinema;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "cinemaController")
@ViewScoped
public class CinemaController extends AbstractController<Cinema> {

    @Inject
    private CarteleraController carteleraController;
    @Inject
    private CineController cineNitController;
    @Inject
    private MobilePageController mobilePageController;

    public CinemaController() {
        // Inform the Abstract parent controller of the concrete Cinema Entity
        super(Cinema.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        carteleraController.setSelected(null);
        cineNitController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Sala entities that are
     * retrieved from Cinema?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Sala page
     */
    public String navigateSalaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Sala_items", this.getSelected().getSalaList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/GUI/sala/index";
    }

    /**
     * Sets the "selected" attribute of the Cartelera controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCartelera(ActionEvent event) {
        if (this.getSelected() != null && carteleraController.getSelected() == null) {
            carteleraController.setSelected(this.getSelected().getCartelera());
        }
    }

    /**
     * Sets the "selected" attribute of the Cine controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCineNit(ActionEvent event) {
        if (this.getSelected() != null && cineNitController.getSelected() == null) {
            cineNitController.setSelected(this.getSelected().getCineNit());
        }
    }
}
