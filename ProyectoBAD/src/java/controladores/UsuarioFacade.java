/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import entidades.Usuario;
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
public class UsuarioFacade extends AbstractFacade<Usuario> {
    @PersistenceContext(unitName = "ProyectoBADPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    //FUNCION ADICIONAL DE LOGIN
    public List<Usuario> existeUser(String usr,String pass){
        
        Query consulta = em.createNamedQuery("Usuario.login"); //Se vrea la consulta de nombre Usuario.login
        //Se le pasan los parametros
        consulta.setParameter("idusuario", usr);
        consulta.setParameter("password", pass);
        List<Usuario> resultado = consulta.getResultList();
        return resultado;        
    }
    
    
      
}
