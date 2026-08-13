package com.pruebatecnica.brianmh.pyme.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatecnica.brianmh.pyme.entity.Cliente;
import com.pruebatecnica.brianmh.pyme.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> getAllClientes(){
        return repository.findAll();
    }

    @Override
    public Cliente addCliente(Cliente cliente) {
        return repository.save(cliente);
    }

}
