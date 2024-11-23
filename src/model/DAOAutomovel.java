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
public class DAOAutomovel {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoFinalPU");
    EntityManager em = emf.createEntityManager();

    public boolean inserir(Automovel a) {

        em.getTransaction().begin();
        try {
            em.persist(a);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
    }

    public boolean editar(Automovel a) {

        em.getTransaction().begin();
        try {
            em.merge(a);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
    }

    public boolean excluir(Automovel a) {

        em.getTransaction().begin();
        try {
            em.remove(a);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
    }

    public Automovel selecionar(Automovel a) {
        Query consulta = em.createQuery("select a from Automovel a where a.placa =: n");
        consulta.setParameter("n", a);
        return (Automovel) consulta.getSingleResult();
    }

    public List<Automovel> listar() {
        return em.createQuery("select a from Automovel a").getResultList();

    }
}
