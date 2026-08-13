package com.pruebatecnica.brianmh.pyme.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name= "nombre", nullable=false, length=50)
    private String nombre;

    @Column(name= "apellidoPaterno", nullable=false, length=50)
    private String apellidoPat;

    @Column(name= "apellidoMaterno", nullable=true, length=50)
    private String apellidoMat;

    @Column(name= "email", nullable=false, length=50, unique=true)
    private String email;

    public Cliente(){

    }

    public Cliente(Long id, String nombre, String apellidoPat, String apellidoMat, String email){
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.email = email;
    }

	public Cliente(String nombre, String apellidoPat, String apellidoMat, String email){
        super();
        this.nombre = nombre;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.email = email;
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

	public String getApellidoPat() {
		return this.apellidoPat;
	}

	public void setApellidoPat(String apellidoPat) {
		this.apellidoPat = apellidoPat;
    }

	public String getApellidoMat() {
		return this.apellidoMat;
	}

	public void setApellidoMat(String apellidoMat) {
		this.apellidoMat = apellidoMat;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
