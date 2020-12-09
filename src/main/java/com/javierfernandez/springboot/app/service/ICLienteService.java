package com.javierfernandez.springboot.app.service;

import com.javierfernandez.springboot.app.models.entity.Cliente;

import java.util.List;

public interface ICLienteService {


    public List<Cliente> findAll();

    public void save(Cliente cliente);

    public Cliente findOne(Long id);

    public void delete(Long id);

}
