package co.edu.udea.cine.controller;

import co.edu.udea.cine.controller.util.MobilePageController;
import co.edu.udea.cine.pojo.Pelicula;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "peliculaController")
@ViewScoped
public class PeliculaController extends AbstractController<Pelicula> {

    @Inject
    private ClasificacionController censuraController;
    @Inject
    private FormatoController formatoController;
    @Inject
    private GeneroController generoidGeneroController;
    @Inject
    private LenguajeController lenguajeController;
    @Inject
    private MobilePageController mobilePageController;

    public PeliculaController() {
        // Inform the Abstract parent controller of the concrete Pelicula Entity
        super(Pelicula.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        censuraController.setSelected(null);
        formatoController.setSelected(null);
        generoidGeneroController.setSelected(null);
        lenguajeController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Cartelerapelicula
     * entities that are retrieved from Pelicula?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for Cartelerapelicula page
     */
    public String navigateCartelerapeliculaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Cartelerapelicula_items", this.getSelected().getCartelerapeliculaList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/GUI/cartelerapelicula/index";
    }

    /**
     * Sets the "selected" attribute of the Clasificacion controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCensura(ActionEvent event) {
        if (this.getSelected() != null && censuraController.getSelected() == null) {
            censuraController.setSelected(this.getSelected().getCensura());
        }
    }

    /**
     * Sets the "selected" attribute of the Formato controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareFormato(ActionEvent event) {
        if (this.getSelected() != null && formatoController.getSelected() == null) {
            formatoController.setSelected(this.getSelected().getFormato());
        }
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
     * Sets the "selected" attribute of the Lenguaje controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareLenguaje(ActionEvent event) {
        if (this.getSelected() != null && lenguajeController.getSelected() == null) {
            lenguajeController.setSelected(this.getSelected().getLenguaje());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Funcion entities that are
     * retrieved from Pelicula?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Funcion page
     */
    public String navigateFuncionList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Funcion_items", this.getSelected().getFuncionList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/GUI/funcion/index";
    }

    /**
     * Sets the "items" attribute with a collection of Comentarios entities that
     * are retrieved from Pelicula?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Comentarios page
     */
    public String navigateComentariosList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Comentarios_items", this.getSelected().getComentariosList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/GUI/comentarios/index";
    }

}
