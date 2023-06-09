package com.dawes.modelo;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.dawes.enums.EstadoArbol;

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
@Table(name = "arbol",uniqueConstraints = @UniqueConstraint(columnNames = {"columna","fila","idfinca"}))
public class ArbolVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idarbol;
	private int fila;
	private int columna;
	private EstadoArbol estado;
	@ManyToOne
	@JoinColumn(name = "idfinca")
	private FincaVO finca;
	@ManyToOne
	@JoinColumn(name = "idvariedad")
	private VariedadVO variedad;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaplantacion;
	public int getIdarbol() {
		return idarbol;
	}
	public void setIdarbol(int idarbol) {
		this.idarbol = idarbol;
	}
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}
	public int getColumna() {
		return columna;
	}
	public void setColumna(int columna) {
		this.columna = columna;
	}
	public EstadoArbol getEstado() {
		return estado;
	}
	public void setEstado(EstadoArbol estado) {
		this.estado = estado;
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
	public LocalDate getFechaplantacion() {
		return fechaplantacion;
	}
	public void setFechaplantacion(LocalDate fechaplantacion) {
		this.fechaplantacion = fechaplantacion;
	}
	public ArbolVO(int idarbol, int fila, int columna, EstadoArbol estado, FincaVO finca, VariedadVO variedad,
			LocalDate fechaplantacion) {
		super();
		this.idarbol = idarbol;
		this.fila = fila;
		this.columna = columna;
		this.estado = estado;
		this.finca = finca;
		this.variedad = variedad;
		this.fechaplantacion = fechaplantacion;
	}
	
	public ArbolVO() {
	
	}

}
