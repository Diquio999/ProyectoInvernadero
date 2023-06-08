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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tratamientosarbol")
public class TratamientoArbolVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtratamientoarbol;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechatratamiento;
	@ManyToOne
	@JoinColumn(name = "idarbol")
	private ArbolVO arbol;
	@ManyToOne
	@JoinColumn(name = "idtratamiento")
	private TratamientoVO tratamiento;
}
