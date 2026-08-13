package com.pruebatecnica.brianmh.pyme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/actualizar/{id}")
    public String actualizarCliente(@PathVariable Long id, Model model){
        model.addAttribute("cliente", service.getById(id));
        return "actualizarCliente";
    }

    @PostMapping("/clientes/{id}")
    public String guardarClienteActualizado(@PathVariable Long id, @ModelAttribute("cliente") Cliente cliente, Model model){
        Cliente clienteById = service.getById(id);
        clienteById.setId(id);
        clienteById.setNombre(cliente.getNombre());
        clienteById.setApellidoPat(cliente.getApellidoPat());
        clienteById.setApellidoMat(cliente.getApellidoMat());
        clienteById.setEmail(cliente.getEmail());
        service.updateCliente(clienteById);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/{id}")
    public String eliminarCliente(@PathVariable Long id){
        service.deleteCliente(id);
        return "redirect:/clientes";
    }
}
