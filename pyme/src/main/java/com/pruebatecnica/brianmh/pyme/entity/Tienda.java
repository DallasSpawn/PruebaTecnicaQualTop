package com.pruebatecnica.brianmh.pyme.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tiendas")
public class Tienda {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name= "nombre", nullable=false, length=50)
    private String nombre;

    @Column(name= "direccion", nullable=false, length=255)
    private String direccion;

    public Tienda(){

    }

    public Tienda(Long id, String nombre, String direccion){
        super();
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

	public Tienda(String nombre, String direccion){
        super();
        this.nombre = nombre;
        this.direccion = direccion;
    }

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
