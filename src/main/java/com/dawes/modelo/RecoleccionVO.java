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
	public RecoleccionVO() {
	}
	public RecoleccionVO(int idrecoleccion, LocalDate fechaRecogida, int recolecta, FincaVO finca,
			VariedadVO variedad) {
		super();
		this.idrecoleccion = idrecoleccion;
		this.fechaRecogida = fechaRecogida;
		this.recolecta = recolecta;
		this.finca = finca;
		this.variedad = variedad;
	}
	public int getIdrecoleccion() {
		return idrecoleccion;
	}
	public void setIdrecoleccion(int idrecoleccion) {
		this.idrecoleccion = idrecoleccion;
	}
	public LocalDate getFechaRecogida() {
		return fechaRecogida;
	}
	public void setFechaRecogida(LocalDate fechaRecogida) {
		this.fechaRecogida = fechaRecogida;
	}
	public int getRecolecta() {
		return recolecta;
	}
	public void setRecolecta(int recolecta) {
		this.recolecta = recolecta;
	}
	public FincaVO getFinca() {
		return finca;
	}
	public void setFinca(FincaVO finca) {
		this.finca = finca;
	}
	public VariedadVO getVariedad() {
		return variedad;
	}
	public void setVariedad(VariedadVO variedad) {
		this.variedad = variedad;
	}
	

}
