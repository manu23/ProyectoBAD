/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Prerrequisito;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mejia
 */
@Stateless
public class PrerrequisitoFacade extends AbstractFacade<Prerrequisito> {
    @PersistenceContext(unitName = "ProyectoBADPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrerrequisitoFacade() {
        super(Prerrequisito.class);
    }
    
}
