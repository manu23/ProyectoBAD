/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Pensum;
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
public class PensumFacade extends AbstractFacade<Pensum> {
    @PersistenceContext(unitName = "ProyectoBADPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PensumFacade() {
        super(Pensum.class);
    }
    
    //FUNCION QUE VERIFICA SI YA EXISTE EL IDPENSUM
    public List<Pensum> existePensumID(String id){
        
        Query consulta = em.createNamedQuery("Pensum.findByIdpensum"); 
        //Se le pasan los parametros
        consulta.setParameter("idpensum", id);
        List<Pensum> resultado = consulta.getResultList();
        return resultado;        
    }
}
