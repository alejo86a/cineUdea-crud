package co.edu.udea.cine.controller;

import co.edu.udea.cine.controller.util.MobilePageController;
import co.edu.udea.cine.pojo.Funcion;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "funcionController")
@ViewScoped
public class FuncionController extends AbstractController<Funcion> {

    @Inject
    private PeliculaController pELICULAidPELICULAController;
    @Inject
    private ProgramacionController pROGRAMACIONidProgramacionController;
    @Inject
    private MobilePageController mobilePageController;

    public FuncionController() {
        // Inform the Abstract parent controller of the concrete Funcion Entity
        super(Funcion.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        pELICULAidPELICULAController.setSelected(null);
        pROGRAMACIONidProgramacionController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Boleta entities that are
     * retrieved from Funcion?cap_first and returns the navigation outcome.
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
     * Sets the "selected" attribute of the Pelicula controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePELICULAidPELICULA(ActionEvent event) {
        if (this.getSelected() != null && pELICULAidPELICULAController.getSelected() == null) {
            pELICULAidPELICULAController.setSelected(this.getSelected().getPELICULAidPELICULA());
        }
    }

    /**
     * Sets the "selected" attribute of the Programacion controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePROGRAMACIONidProgramacion(ActionEvent event) {
        if (this.getSelected() != null && pROGRAMACIONidProgramacionController.getSelected() == null) {
            pROGRAMACIONidProgramacionController.setSelected(this.getSelected().getPROGRAMACIONidProgramacion());
        }
    }
}
