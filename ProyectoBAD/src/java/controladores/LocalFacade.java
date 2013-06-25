/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Local;
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
public class LocalFacade extends AbstractFacade<Local> {
    @PersistenceContext(unitName = "ProyectoBADPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LocalFacade() {
        super(Local.class);
    }
    
    //FUNCION QUE VERIFICA SI YA EXISTE EL LOCAL
    public List<Local> existeLocal(String id){
        
        Query consulta = em.createNamedQuery("Local.findByIdlocal"); 
        //Se le pasan los parametros
        consulta.setParameter("idlocal", id);
        List<Local> resultado = consulta.getResultList();
        return resultado;        
    }
    
}
