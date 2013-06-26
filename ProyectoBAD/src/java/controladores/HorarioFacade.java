/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Horario;
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
public class HorarioFacade extends AbstractFacade<Horario> {
    @PersistenceContext(unitName = "ProyectoBADPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HorarioFacade() {
        super(Horario.class);
    }
    
     //FUNCION QUE VERIFICA SI YA EXISTE EL IDHORARIO
    public List<Horario> existeHorarioID(String id){
        
        Query consulta = em.createNamedQuery("Horario.findByIdhorario"); 
        //Se le pasan los parametros
        consulta.setParameter("idhorario", id);
        List<Horario> resultado = consulta.getResultList();
        return resultado;        
    }
}
