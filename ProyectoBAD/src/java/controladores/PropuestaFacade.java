/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Propuesta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    
    //FUNCION QUE VERIFICA SI YA EXISTE EL ID PROPUESTA
    public List<Propuesta> existePropuesta(String id){
        Query consulta = em.createNamedQuery("Propuesta.findByIdpropuesta"); 
        //Se le pasan los parametros
        consulta.setParameter("idpropuesta", id);
        List<Propuesta> resultado = consulta.getResultList();
        return resultado;
    }
}
