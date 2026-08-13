package com.pruebatecnica.brianmh.pyme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pruebatecnica.brianmh.pyme.entity.Cliente;
import com.pruebatecnica.brianmh.pyme.service.ClienteService;


@Controller
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("/clientes")
    public String listaCliente(Model model){
        model.addAttribute("clientes", service.getAllClientes());
        return "clientes";
    }

    @GetMapping("/clientes/nuevo")
    public String crearCliente(Model model){
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return "nuevoCliente";
    }

    @PostMapping("/clientes")
    public String guardarCliente(@ModelAttribute("cliente") Cliente cliente){
        service.addCliente(cliente);
        return "redirect:clientes";
    }
}
