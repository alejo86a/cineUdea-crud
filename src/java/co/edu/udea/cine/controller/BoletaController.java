package co.edu.udea.cine.controller;

import co.edu.udea.cine.controller.util.MobilePageController;
import co.edu.udea.cine.pojo.Boleta;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "boletaController")
@ViewScoped
public class BoletaController extends AbstractController<Boleta> {

    @Inject
    private FuncionController funcionController;
    @Inject
    private PrecioController precioidPrecioController;
    @Inject
    private ReservaController reservaController;
    @Inject
    private SillaController sILLANumeroController;
    @Inject
    private MobilePageController mobilePageController;

    public BoletaController() {
        // Inform the Abstract parent controller of the concrete Boleta Entity
        super(Boleta.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        funcionController.setSelected(null);
        precioidPrecioController.setSelected(null);
        reservaController.setSelected(null);
        sILLANumeroController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Funcion controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareFuncion(ActionEvent event) {
        if (this.getSelected() != null && funcionController.getSelected() == null) {
            funcionController.setSelected(this.getSelected().getFuncion());
        }
    }

    /**
     * Sets the "selected" attribute of the Precio controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePrecioidPrecio(ActionEvent event) {
        if (this.getSelected() != null && precioidPrecioController.getSelected() == null) {
            precioidPrecioController.setSelected(this.getSelected().getPrecioidPrecio());
        }
    }

    /**
     * Sets the "selected" attribute of the Reserva controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareReserva(ActionEvent event) {
        if (this.getSelected() != null && reservaController.getSelected() == null) {
            reservaController.setSelected(this.getSelected().getReserva());
        }
    }

    /**
     * Sets the "selected" attribute of the Silla controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSILLANumero(ActionEvent event) {
        if (this.getSelected() != null && sILLANumeroController.getSelected() == null) {
            sILLANumeroController.setSelected(this.getSelected().getSILLANumero());
        }
    }
}
