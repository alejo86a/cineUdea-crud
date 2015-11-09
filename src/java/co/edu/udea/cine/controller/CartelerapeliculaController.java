package co.edu.udea.cine.controller;

import co.edu.udea.cine.controller.util.MobilePageController;
import co.edu.udea.cine.pojo.Cartelerapelicula;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "cartelerapeliculaController")
@ViewScoped
public class CartelerapeliculaController extends AbstractController<Cartelerapelicula> {

    @Inject
    private CarteleraController carteleraController;
    @Inject
    private PeliculaController peliculaController;
    @Inject
    private MobilePageController mobilePageController;

    public CartelerapeliculaController() {
        // Inform the Abstract parent controller of the concrete Cartelerapelicula Entity
        super(Cartelerapelicula.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getCartelerapeliculaPK().setPELICULAidPELICULA(this.getSelected().getPelicula().getIdPELICULA());
        this.getSelected().getCartelerapeliculaPK().setCARTELERAidCARTELERA(this.getSelected().getCartelera().getIdCARTELERA());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setCartelerapeliculaPK(new co.edu.udea.cine.pojo.CartelerapeliculaPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        carteleraController.setSelected(null);
        peliculaController.setSelected(null);
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
     * Sets the "selected" attribute of the Pelicula controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePelicula(ActionEvent event) {
        if (this.getSelected() != null && peliculaController.getSelected() == null) {
            peliculaController.setSelected(this.getSelected().getPelicula());
        }
    }
}
