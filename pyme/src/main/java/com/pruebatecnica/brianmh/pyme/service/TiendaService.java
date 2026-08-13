package com.pruebatecnica.brianmh.pyme.service;
import java.util.List;

import com.pruebatecnica.brianmh.pyme.entity.Tienda;

public interface TiendaService {

    public List<Tienda> getAllTiendas();

    public Tienda addTienda(Tienda tienda);

    public Tienda getById(Long id);

    public Tienda updateTienda(Tienda tienda);

    public void deleteTienda(Long id);
}
