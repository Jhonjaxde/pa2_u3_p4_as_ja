package com.example.demo.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Table(name = "habitacion")
@Entity
public class Habitacion {

	@GeneratedValue(generator = "seq_habitacion", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_habitacion", sequenceName = "seq_habitacion", allocationSize = 1)

	@Id
	@Column(name = "hab_id")
	private Integer id;// pk que utilizamos para lo tecnico

	@Column(name = "hab_numero")
	private String numero;

	@Column(name = "hab_valor")
	private BigDecimal valor;
	@Transient
	private BigDecimal valorIncluidoIva;

	// muchos a uno
	@ManyToOne
	@JoinColumn(name = "hab_id_hotel")
	private Hotel hotel;

	// set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public BigDecimal getValorIncluidoIva() {
		return valorIncluidoIva;
	}

	public void setValorIncluidoIva(BigDecimal valorIncluidoIva) {
		this.valorIncluidoIva = valorIncluidoIva;
	}
	
}