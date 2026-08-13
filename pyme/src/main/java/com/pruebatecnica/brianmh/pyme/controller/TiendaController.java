package com.pruebatecnica.brianmh.pyme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pruebatecnica.brianmh.pyme.entity.Tienda;
import com.pruebatecnica.brianmh.pyme.service.TiendaService;

@Controller
public class TiendaController {

    @Autowired
    TiendaService service;

    @GetMapping("/tiendas")
    public String listaTiendas(Model model){
        model.addAttribute("tiendas", service.getAllTiendas());
        return "tiendas";
    }

    @GetMapping("/tiendas/nuevo")
    public String crearTienda(Model model){
        Tienda tienda = new Tienda();
        model.addAttribute("tienda", tienda);
        return "nuevaTienda";
    }

    @PostMapping("/tiendas")
    public String guardarTienda(@ModelAttribute("tienda") Tienda tienda){
        service.addTienda(tienda);
        return "redirect:/tiendas";
    }

    @GetMapping("/tiendas/actualizar/{id}")
    public String actualizarTienda(@PathVariable Long id, Model model){
        model.addAttribute("tienda", service.getById(id));
        return "actualizarTienda";
    }

    @PostMapping("/tiendas/{id}")
    public String guardarTiendaActualizado(@PathVariable Long id, @ModelAttribute("tienda") Tienda tienda, Model model){
        Tienda tiendaById = service.getById(id);
        tiendaById.setId(id);
        tiendaById.setNombre(tienda.getNombre());
        tiendaById.setDireccion(tienda.getDireccion());
        service.updateTienda(tiendaById);
        return "redirect:/tiendas";
    }

    @GetMapping("/tiendas/{id}")
    public String eliminarTienda(@PathVariable Long id){
        service.deleteTienda(id);
        return "redirect:/tiendas";
    }

}
