package co.edu.udea.cine.controller;

import co.edu.udea.cine.controller.util.MobilePageController;
import co.edu.udea.cine.pojo.Comentarios;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "comentariosController")
@ViewScoped
public class ComentariosController extends AbstractController<Comentarios> {

    @Inject
    private PeliculaController peliculaController;
    @Inject
    private MobilePageController mobilePageController;

    public ComentariosController() {
        // Inform the Abstract parent controller of the concrete Comentarios Entity
        super(Comentarios.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        peliculaController.setSelected(null);
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
