package com.dawes.modelo;

import com.dawes.enums.TipoTratamiento;
import jakarta.persistence.Column;
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
@Table(name="tratamiento",uniqueConstraints = @UniqueConstraint (columnNames = "nombre"))
public class TratamientoVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtratamiento;
	private String nombre;
	@Column (length = 40) 
	private String descripcion;
	private TipoTratamiento tipo;
	public TratamientoVO(int idtratamiento, String nombre, String descripcion, TipoTratamiento tipo) {
		super();
		this.idtratamiento = idtratamiento;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipo = tipo;
	}
	public TratamientoVO() {
	}
	public int getIdtratamiento() {
		return idtratamiento;
	}
	public void setIdtratamiento(int idtratamiento) {
		this.idtratamiento = idtratamiento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public TipoTratamiento getTipo() {
		return tipo;
	}
	public void setTipo(TipoTratamiento tipo) {
		this.tipo = tipo;
	}
	

}
