/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Propuesta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mejia
 */
@Stateless
public class PropuestaFacade extends AbstractFacade<Propuesta> {
    @PersistenceContext(unitName = "ProyectoBADPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PropuestaFacade() {
        super(Propuesta.class);
    }
    
}
