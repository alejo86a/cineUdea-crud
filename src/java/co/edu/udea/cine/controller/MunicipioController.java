package co.edu.udea.cine.controller;

import co.edu.udea.cine.controller.util.MobilePageController;
import co.edu.udea.cine.pojo.Municipio;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "municipioController")
@ViewScoped
public class MunicipioController extends AbstractController<Municipio> {

    @Inject
    private MobilePageController mobilePageController;

    public MunicipioController() {
        // Inform the Abstract parent controller of the concrete Municipio Entity
        super(Municipio.class);
    }

    /**
     * Sets the "items" attribute with a collection of Usuario entities that are
     * retrieved from Municipio?cap_first and returns the navigation outcome.
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
