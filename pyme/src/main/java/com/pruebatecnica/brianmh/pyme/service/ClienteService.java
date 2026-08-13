package com.pruebatecnica.brianmh.pyme.service;
import java.util.List;

import com.pruebatecnica.brianmh.pyme.entity.Cliente;

public interface ClienteService {

    public List<Cliente> getAllClientes();

    public Cliente addCliente(Cliente cliente);

    public Cliente getById(Long id);

    public Cliente updateCliente(Cliente cliente);

    public void deleteCliente(Long id);
}
