package com.dawes.DTO;

import java.time.LocalDate;

import com.dawes.modelo.FincaVO;
import com.dawes.modelo.VariedadVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecoleccionDTO {
	private int idrecoleccion;
	private LocalDate fechaRecogida;
	private int recolecta;
	private FincaVO finca;
	private VariedadVO variedad;
}
