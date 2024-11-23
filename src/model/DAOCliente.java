/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author guilherme
 */
public class DAOCliente {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoFinalPU");
    EntityManager em = emf.createEntityManager();

    public boolean Inserir(Cliente c) {

        em.getTransaction().begin();
        try {
            em.persist(c);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
    }
    public boolean editar(Cliente c) {
        em.getTransaction().begin();
        try {
            em.merge(c);
            em.getTransaction().commit();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
    }
    
       public boolean excluir(Cliente c) {
        em.getTransaction().begin();
        try {
            em.remove(c);
            em.getTransaction().commit();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
    }

    public Cliente selecionar(String cpf) {
        Query consulta = em.createQuery("select c from Cliente c where c.cpf =:n");
        consulta.setParameter("n", cpf);
        return (Cliente) consulta.getResultList();

    }
    
    public List<Cliente> listar() {
        Query consulta = em.createQuery("select c from Cliente c ");
        return consulta.getResultList();
    }

}
