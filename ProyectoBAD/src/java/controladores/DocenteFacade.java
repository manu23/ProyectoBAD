/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Docente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Mejia
 */
@Stateless
public class DocenteFacade extends AbstractFacade<Docente> {
    @PersistenceContext(unitName = "ProyectoBADPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocenteFacade() {
        super(Docente.class);
    }
    
    //FUNCION QUE VERIFICA SI YA EXISTE EL DOCENTE
    public List<Docente> existeDocente(String id){
        Query consulta = em.createNamedQuery("Docente.findByIddocente"); 
        //Se le pasan los parametros
        consulta.setParameter("iddocente", id);
        List<Docente> resultado = consulta.getResultList();
        return resultado;
    }
    
    
    
}
