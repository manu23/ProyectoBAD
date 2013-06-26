/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Departamento;
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
public class DepartamentoFacade extends AbstractFacade<Departamento> {
    @PersistenceContext(unitName = "ProyectoBADPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartamentoFacade() {
        super(Departamento.class);
    }
    
    //FUNCION QUE VERIFICA SI YA EXISTE EL IDDEPARTAMENTO
    public List<Departamento> existeDeptoID(String id){
        
        Query consulta = em.createNamedQuery("Departamento.findByIddepartamento"); 
        //Se le pasan los parametros
        consulta.setParameter("iddepartamento", id);
        List<Departamento> resultado = consulta.getResultList();
        return resultado;        
    }
    
    //FUNCION QUE VERIFICA SI YA EXISTE EL NOMBRE DEL DEPARTAMENTO
    public List<Departamento> existeDeptoNOM(String nombre){
        
        Query consulta = em.createNamedQuery("Departamento.findByNombredepartamento"); 
        //Se le pasan los parametros
        consulta.setParameter("nombredepartamento", nombre);
        List<Departamento> resultado = consulta.getResultList();
        return resultado;        
    }
}
