package com.nexos.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "mercancia")
public class Mercancia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idmercancia;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column
    private int cantidad;

    @Column(name = "fecha_ingreso")
    private String fechaIngreso;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Usuario usuario;

	public long getIdmercancia() {
		return idmercancia;
	}

	public void setIdmercancia(long idmercancia) {
		this.idmercancia = idmercancia;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


    
}
