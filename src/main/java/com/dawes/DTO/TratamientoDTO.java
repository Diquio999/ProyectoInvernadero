package com.dawes.DTO;

import com.dawes.enums.TipoTratamiento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TratamientoDTO {
	private int idtratamiento;
	private String nombre;
	private String descripcion;
	private TipoTratamiento tipo;
}
