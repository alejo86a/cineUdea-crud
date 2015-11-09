package co.edu.udea.cine.controller;

import co.edu.udea.cine.controller.util.MobilePageController;
import co.edu.udea.cine.pojo.Precio;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "precioController")
@ViewScoped
public class PrecioController extends AbstractController<Precio> {

    @Inject
    private FormatoController fORMATOidFORMATOController;
    @Inject
    private LocalidadController localidadIdlocalidadController;
    @Inject
    private MobilePageController mobilePageController;

    public PrecioController() {
        // Inform the Abstract parent controller of the concrete Precio Entity
        super(Precio.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        fORMATOidFORMATOController.setSelected(null);
        localidadIdlocalidadController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Formato controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareFORMATOidFORMATO(ActionEvent event) {
        if (this.getSelected() != null && fORMATOidFORMATOController.getSelected() == null) {
            fORMATOidFORMATOController.setSelected(this.getSelected().getFORMATOidFORMATO());
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
     * retrieved from Precio?cap_first and returns the navigation outcome.
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
