package co.edu.udea.cine.controller;

import co.edu.udea.cine.controller.util.MobilePageController;
import co.edu.udea.cine.pojo.Silla;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "sillaController")
@ViewScoped
public class SillaController extends AbstractController<Silla> {

    @Inject
    private SalaController salaController;
    @Inject
    private LocalidadController localidadIdlocalidadController;
    @Inject
    private MobilePageController mobilePageController;

    public SillaController() {
        // Inform the Abstract parent controller of the concrete Silla Entity
        super(Silla.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getSillaPK().setSALAidSALA(this.getSelected().getSala().getIdSALA());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setSillaPK(new co.edu.udea.cine.pojo.SillaPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        salaController.setSelected(null);
        localidadIdlocalidadController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Sala controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSala(ActionEvent event) {
        if (this.getSelected() != null && salaController.getSelected() == null) {
            salaController.setSelected(this.getSelected().getSala());
        }
    }

    /**
     * Sets the "selected" attribute of the Localidad controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareLocalidadIdlocalidad(ActionEvent event) {
        if (this.getSelected() != null && localidadIdlocalidadController.getSelected() == null) {
            localidadIdlocalidadController.setSelected(this.getSelected().getLocalidadIdlocalidad());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Boleta entities that are
     * retrieved from Silla?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Boleta page
     */
    public String navigateBoletaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Boleta_items", this.getSelected().getBoletaList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/GUI/boleta/index";
    }

}
