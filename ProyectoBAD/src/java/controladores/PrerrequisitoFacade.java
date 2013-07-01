/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Prerrequisito;
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
    
     //FUNCION QUE VERIFICA SI YA EXISTE EL PRERREQUISITO
    public List<Prerrequisito> existePrerrequisito(String cod, String pre){
        
        Query consulta = em.createNamedQuery("Prerrequisito.existePrerrequisito"); 
        //Se le pasan los parametros
        consulta.setParameter("codigomateria", cod);
        consulta.setParameter("nombreprerrequisito", pre);
        List<Prerrequisito> resultado = consulta.getResultList();
        return resultado;        
    }
}
