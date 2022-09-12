package br.com.dac.oficina.dao;

import br.com.dac.oficina.model.Concerto;
import br.com.dac.oficina.util.JPAUtil;

import javax.persistence.EntityManager;

public class ConcertoDAO extends JPAUtil {

   public void salvar(Concerto concerto) {
       EntityManager em = getEntityManager();
       try {
           em.getTransaction().begin();
           em.persist(concerto);
           em.getTransaction().commit();
       } catch (Exception e) {
           em.getTransaction().rollback();
       }
   }

   public void remover(Long id) {
       EntityManager em = getEntityManager();
       try {
           em.getTransaction().begin();
           Concerto concerto = em.find(Concerto.class, id);
           em.remove(concerto);
       } catch (Exception e) {
           em.getTransaction().rollback();
       }
   }
}
