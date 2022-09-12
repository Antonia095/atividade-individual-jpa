package br.com.dac.oficina.dao;

import br.com.dac.oficina.model.Concerto;
import br.com.dac.oficina.model.Funcionario;


import javax.persistence.EntityManager;
import java.util.List;

public class FuncionarioDAO {

    private EntityManager em;

    public FuncionarioDAO(EntityManager em) {
        this.em = em;
    }

    public void salvar(Concerto concerto) {
        try {
            em.getTransaction().begin();
            em.persist(concerto);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void remover(Long id) {
        try {
            em.getTransaction().begin();
            Concerto concerto = em.find(Concerto.class, id);
            em.remove(concerto);
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public List<Funcionario> buscarTodos() {

            String jpql = "SELECT f FROM Funcionario f";
            return em.createQuery(jpql, Funcionario.class).getResultList();
    }

    public List<Funcionario> buscarPorNome(String nome) {
        String jpql = "SELECT f FROM Funcionario f WHERE f.nome = :nome";
        return em.createQuery(jpql, Funcionario.class)
                .setParameter("nome", nome)
                .getResultList();
    }
}
