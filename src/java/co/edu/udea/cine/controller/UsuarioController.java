package co.edu.udea.cine.controller;

import co.edu.udea.cine.controller.util.MobilePageController;
import co.edu.udea.cine.pojo.Usuario;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "usuarioController")
@ViewScoped
public class UsuarioController extends AbstractController<Usuario> {

    @Inject
    private GeneroController generoidGeneroController;
    @Inject
    private MunicipioController mUNICIPIOidMUNICIPIOController;
    @Inject
    private MobilePageController mobilePageController;

    public UsuarioController() {
        // Inform the Abstract parent controller of the concrete Usuario Entity
        super(Usuario.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        generoidGeneroController.setSelected(null);
        mUNICIPIOidMUNICIPIOController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Genero controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareGeneroidGenero(ActionEvent event) {
        if (this.getSelected() != null && generoidGeneroController.getSelected() == null) {
            generoidGeneroController.setSelected(this.getSelected().getGeneroidGenero());
        }
    }

    /**
     * Sets the "selected" attribute of the Municipio controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMUNICIPIOidMUNICIPIO(ActionEvent event) {
        if (this.getSelected() != null && mUNICIPIOidMUNICIPIOController.getSelected() == null) {
            mUNICIPIOidMUNICIPIOController.setSelected(this.getSelected().getMUNICIPIOidMUNICIPIO());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Reserva entities that are
     * retrieved from Usuario?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Reserva page
     */
    public String navigateReservaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Reserva_items", this.getSelected().getReservaList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/GUI/reserva/index";
    }

}
