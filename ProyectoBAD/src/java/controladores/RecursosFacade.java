/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Recursos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mejia
 */
@Stateless
public class RecursosFacade extends AbstractFacade<Recursos> {
    @PersistenceContext(unitName = "ProyectoBADPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RecursosFacade() {
        super(Recursos.class);
    }
    
}
