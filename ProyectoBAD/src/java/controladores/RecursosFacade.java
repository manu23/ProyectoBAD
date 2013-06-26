/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Recursos;
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
    
    //FUNCION QUE VERIFICA SI YA EXISTE EL IDRECURSO
    public List<Recursos> existeRecursoID(String id){
        
        Query consulta = em.createNamedQuery("Recursos.findByIdrecursos"); 
        //Se le pasan los parametros
        consulta.setParameter("idrecursos", id);
        List<Recursos> resultado = consulta.getResultList();
        return resultado;        
    }
    
}
