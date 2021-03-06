package com.javierfernandez.springboot.app.models.dao;

import com.javierfernandez.springboot.app.models.entity.Cliente;

import java.util.List;

public interface ICLienteDao {

    public List<Cliente> findAll();

    public void save(Cliente cliente);

    public Cliente findOne(Long id);

    public void delete(Long id);

}
