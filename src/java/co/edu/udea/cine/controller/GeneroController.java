package co.edu.udea.cine.controller;

import co.edu.udea.cine.controller.util.MobilePageController;
import co.edu.udea.cine.pojo.Genero;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "generoController")
@ViewScoped
public class GeneroController extends AbstractController<Genero> {

    @Inject
    private MobilePageController mobilePageController;

    public GeneroController() {
        // Inform the Abstract parent controller of the concrete Genero Entity
        super(Genero.class);
    }

    /**
     * Sets the "items" attribute with a collection of Pelicula entities that
     * are retrieved from Genero?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Pelicula page
     */
    public String navigatePeliculaList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Pelicula_items", this.getSelected().getPeliculaList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/GUI/pelicula/index";
    }

    /**
     * Sets the "items" attribute with a collection of Usuario entities that are
     * retrieved from Genero?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Usuario page
     */
    public String navigateUsuarioList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Usuario_items", this.getSelected().getUsuarioList());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/GUI/usuario/index";
    }

}
