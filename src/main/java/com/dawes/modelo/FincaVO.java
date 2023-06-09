package com.dawes.modelo;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name="finca",uniqueConstraints = @UniqueConstraint (columnNames = "nombre"))
public class FincaVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idfinca;
	private String nombre;
	private String direccion;
	private float superficie;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	public FincaVO(int idfinca, String nombre, String direccion, float superficie, LocalDate fecha) {
		super();
		this.idfinca = idfinca;
		this.nombre = nombre;
		this.direccion = direccion;
		this.superficie = superficie;
		this.fecha = fecha;
	}
	public FincaVO() {
	
	}
	public int getIdfinca() {
		return idfinca;
	}
	public void setIdfinca(int idfinca) {
		this.idfinca = idfinca;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public float getSuperficie() {
		return superficie;
	}
	public void setSuperficie(float superficie) {
		this.superficie = superficie;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	
	
}
