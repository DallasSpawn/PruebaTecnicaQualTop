package com.pruebatecnica.brianmh.pyme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatecnica.brianmh.pyme.entity.Tienda;
import com.pruebatecnica.brianmh.pyme.repository.TiendaRepository;

@Service
public class TiendaServiceImpl implements TiendaService{

    @Autowired
    TiendaRepository repository;

    @Override
    public List<Tienda> getAllTiendas(){
        return repository.findAll();
    }

    @Override
    public Tienda addTienda(Tienda tienda) {
        return repository.save(tienda);
    }

    @Override
    public Tienda getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Tienda updateTienda(Tienda tienda) {
        return repository.save(tienda);
    }

    @Override
    public void deleteTienda(Long id) {
        repository.deleteById(id);
    }

}
