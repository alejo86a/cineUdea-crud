/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.cine.bean;

import co.edu.udea.cine.pojo.Silla;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alejandro
 */
@Stateless
public class SillaFacade extends AbstractFacade<Silla> {
    @PersistenceContext(unitName = "cineUdeAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SillaFacade() {
        super(Silla.class);
    }
    
}
