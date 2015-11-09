package co.edu.udea.cine.controller;

import co.edu.udea.cine.controller.util.MobilePageController;
import co.edu.udea.cine.pojo.Reserva;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "reservaController")
@ViewScoped
public class ReservaController extends AbstractController<Reserva> {

    @Inject
    private UsuarioController uSUARIODocumentController;
    @Inject
    private MobilePageController mobilePageController;

    public ReservaController() {
        // Inform the Abstract parent controller of the concrete Reserva Entity
        super(Reserva.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        uSUARIODocumentController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Boleta entities that are
     * retrieved from Reserva?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Boleta page
     */
    public String navigateBoletaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Boleta_items", this.getSelected().getBoletaList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/GUI/boleta/index";
    }

    /**
     * Sets the "selected" attribute of the Usuario controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUSUARIODocument(ActionEvent event) {
        if (this.getSelected() != null && uSUARIODocumentController.getSelected() == null) {
            uSUARIODocumentController.setSelected(this.getSelected().getUSUARIODocument());
        }
    }
}
