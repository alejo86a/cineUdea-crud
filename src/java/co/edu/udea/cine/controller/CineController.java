package co.edu.udea.cine.controller;

import co.edu.udea.cine.controller.util.MobilePageController;
import co.edu.udea.cine.pojo.Cine;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "cineController")
@ViewScoped
public class CineController extends AbstractController<Cine> {

    @Inject
    private MobilePageController mobilePageController;

    public CineController() {
        // Inform the Abstract parent controller of the concrete Cine Entity
        super(Cine.class);
    }

    /**
     * Sets the "items" attribute with a collection of Cinema entities that are
     * retrieved from Cine?cap_first and returns the navigation outcome.
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
