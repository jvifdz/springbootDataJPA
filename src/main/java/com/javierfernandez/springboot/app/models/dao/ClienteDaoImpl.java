package com.javierfernandez.springboot.app.models.dao;

import com.javierfernandez.springboot.app.models.entity.Cliente;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository("clienteDaoJPA")
public class ClienteDaoImpl implements ICLienteDao{

    @PersistenceContext
    private EntityManager em;
    @SuppressWarnings("unchecked")
    @Override
    public List<Cliente> findAll() {
        return em.createQuery("from Cliente").getResultList();
    }

    @Override
    public Cliente findOne(Long id) {
        return em.find(Cliente.class,id);
    }

    @Override
    public void save(Cliente cliente) {

        if (cliente.getId()!= null&& cliente.getId()>0){
            em.merge(cliente);
        }else{
        em.persist(cliente);
        }
    }

    @Override

    public void delete(Long id) {
        /*Cliente cliente = findOne(id);
        em.remove(cliente);*/
        em.remove(findOne(id));
    }
}
