package co.edu.udea.cine.controller;

import co.edu.udea.cine.controller.util.MobilePageController;
import co.edu.udea.cine.pojo.Programacion;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "programacionController")
@ViewScoped
public class ProgramacionController extends AbstractController<Programacion> {

    @Inject
    private SalaController sALAidSALAController;
    @Inject
    private MobilePageController mobilePageController;

    public ProgramacionController() {
        // Inform the Abstract parent controller of the concrete Programacion Entity
        super(Programacion.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        sALAidSALAController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Sala controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSALAidSALA(ActionEvent event) {
        if (this.getSelected() != null && sALAidSALAController.getSelected() == null) {
            sALAidSALAController.setSelected(this.getSelected().getSALAidSALA());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Funcion entities that are
     * retrieved from Programacion?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Funcion page
     */
    public String navigateFuncionList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Funcion_items", this.getSelected().getFuncionList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/GUI/funcion/index";
    }

}
