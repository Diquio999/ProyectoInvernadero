package com.dawes.modelo;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recoleccion",uniqueConstraints = @UniqueConstraint(columnNames = {"fechaRecogida","idfinca","idvariedad"}) )
public class RecoleccionVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idrecoleccion;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaRecogida;
	private int recolecta;
	@ManyToOne
	@JoinColumn(name="idfinca")
	private FincaVO finca;
	@ManyToOne
	@JoinColumn(name="idvariedad")
	private VariedadVO variedad;
	
	public RecoleccionVO(LocalDate fechaRecogida, int recolecta, FincaVO finca, VariedadVO variedad) {
		this.fechaRecogida=fechaRecogida;
		this.recolecta=recolecta;
		this.finca=finca;
		this.variedad=variedad;
	}
}
