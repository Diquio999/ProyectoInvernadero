package com.dawes.DTO;

import java.time.LocalDate;
import java.time.Period;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FincaDTO {
	private int idfinca;
	private String nombre;
	private String direccion;
	private float superficie;
	private LocalDate fecha;
}
