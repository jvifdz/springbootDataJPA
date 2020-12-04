package com.javierfernandez.springboot.app.controllers;

import com.javierfernandez.springboot.app.models.dao.ICLienteDao;
import com.javierfernandez.springboot.app.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class ClienteController {

    @Autowired
    @Qualifier("clienteDaoJPA")
    private ICLienteDao clienteDao;

    @RequestMapping(value = "/listar",method = RequestMethod.GET)
    public String listar(Model model){
        model.addAttribute("titulo","Listado de clientes");
        model.addAttribute("clientes",clienteDao.findAll());
        return "listar";
    }

    @RequestMapping(value = "/form")
    public String crear(Map <String, Object> model){
        Cliente cliente = new Cliente();
        model.put("cliente", cliente);

        model.put("titulo", "Formulario de Cliente");
        return "form";
    }


    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar (@Valid /*@ModelAttribute("cliente")*/ Cliente cliente, BindingResult result, Model model){
        //si tiene errores volvemos a la vista formulario
        //y volvemos a pasar el titulo
        //no pasamos cliente por que lo pasa automaticamente pero debe llamarese ela clase Cliente
        //no importa la mayus
        //igual que como lo pasas a la vista arriba en el put ("cliente")
        //sino se indica en el @ModelAtribute
        if (result.hasErrors()){
            model.addAttribute("titulo","Formulario del Cliente");

            return "form";
        }

        clienteDao.save(cliente);
        return "redirect:listar";
    }

}
