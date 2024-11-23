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
public class DAORevisao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoFinalPU");
    EntityManager em = emf.createEntityManager();

    public boolean inserir(Revisao r) {
        em.getTransaction().begin();
        try {
            em.persist(r);
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

    public boolean editar(Revisao r) {
        em.getTransaction().begin();
        try {
            em.merge(r);
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

    public boolean excluir(Revisao r) {
        em.getTransaction().begin();
        try {
            em.remove(r);
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

    public List<Revisao> listar(Automovel a) {
        Query consulta = em.createQuery("select r from Revisao r where r.automovel=:n");
        consulta.setParameter("n", a);
        return consulta.getResultList();
    }

}
