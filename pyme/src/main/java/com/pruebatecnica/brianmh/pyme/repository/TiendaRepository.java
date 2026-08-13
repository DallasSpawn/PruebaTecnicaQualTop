package com.pruebatecnica.brianmh.pyme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pruebatecnica.brianmh.pyme.entity.Tienda;

@Repository
public interface TiendaRepository  extends JpaRepository<Tienda, Long>{

}
