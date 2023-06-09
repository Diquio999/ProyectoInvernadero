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
@NoArgsConstructor
@AllArgsConstructor
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
	
	public FincaVO(String nombre, String direccion, float superficie, LocalDate fecha) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.superficie = superficie;
		this.fecha = fecha;
	}
}
