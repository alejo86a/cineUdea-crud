package co.edu.udea.cine.controller;

import co.edu.udea.cine.controller.util.MobilePageController;
import co.edu.udea.cine.pojo.Sala;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "salaController")
@ViewScoped
public class SalaController extends AbstractController<Sala> {

    @Inject
    private CinemaController cINEMAidCINEMAController;
    @Inject
    private MobilePageController mobilePageController;

    public SalaController() {
        // Inform the Abstract parent controller of the concrete Sala Entity
        super(Sala.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        cINEMAidCINEMAController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Silla entities that are
     * retrieved from Sala?cap_first and returns the navigation outcome.
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
     * Sets the "selected" attribute of the Cinema controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCINEMAidCINEMA(ActionEvent event) {
        if (this.getSelected() != null && cINEMAidCINEMAController.getSelected() == null) {
            cINEMAidCINEMAController.setSelected(this.getSelected().getCINEMAidCINEMA());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Programacion entities
     * that are retrieved from Sala?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Programacion page
     */
    public String navigateProgramacionList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Programacion_items", this.getSelected().getProgramacionList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/GUI/programacion/index";
    }

}
